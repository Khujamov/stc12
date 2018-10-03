package ru.innopolis.stc12.jdbc.basicks;

import org.apache.log4j.Logger;

import java.sql.*;

public class Example2 {
    static ResultSet resultSet;
    private static Logger logger = Logger.getLogger(Example2.class);
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MobilePhones", "postgres", Example.password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.students  WHERE public.students.city = ? AND age > ?");
        ) {
            preparedStatement.setString(1, "Rostov");
            preparedStatement.setInt(2, 19);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                logger.info(resultSet.getString("name") + "; ");
                logger.info(resultSet.getString("family_name") + "; ");
                logger.info(resultSet.getInt("age") + "; ");
                logger.info(resultSet.getString("city") + "; ");

            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
}

