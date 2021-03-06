package ru.innopolis.stc12.sockets;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static Logger logger = Logger.getLogger(ConsoleHelper.class);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleHelper() {
    }

    public static void writeMessage(String message) {
        logger.info(message);
    }

    public static String readString() {
        while (true) {
            try {
                return reader.readLine();

            } catch (IOException e) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readString());
            } catch (NumberFormatException e) {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
    }
}