package ru.innopolis.stc12.multithread;

import org.apache.log4j.Logger;

public class WaitAndPrint implements Runnable {
    private final int period;
    private String message;
    private int loopCount = 0;
    private Thread t = new Thread(this);
    private Logger logger = Logger.getLogger(WaitAndPrint.class);

    WaitAndPrint(int period, String message) {
        this.period = period;
        this.message = message;
        t.start();
    }

    @Override
    public void run() {
        try {
            while (loopCount < 1000000)
                synchronized (Message.class) {
                    Message.class.wait();
                    if (Message.count % period == 0)
                        Message.sendMessage(message, logger);
                    loopCount++;
                }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}