package org.example;

import java.sql.*;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {

    private static Connection connection;
    private static int minionId;
    private static final String PRINT_NO_MINION_WITH_ID_EXIST = "No minion with ID %d exists in the database.%n";
    private static final String SELECT_MINIONS_INFO_BY_ID = "SELECT `name`, age FROM minions WHERE id = ?";
    private static final String CALL_PROCEDURE = "{CALL usp_get_older(?)}";
    private static final String ENTER_ID = "Enter villain id: ";

    public static void main(String[] args) throws SQLException {
        minionId = getMinionId();

        connection = Utils.getSQLConnection();

        ResultSet minionInfo = getMinionInfo();

        if (minionInfo.next()) {
            updateMinionAge();

            minionInfo = getMinionInfo();

            printMinionInfo(minionInfo);

        } else {
            System.out.printf(PRINT_NO_MINION_WITH_ID_EXIST, minionId);
        }

        connection.close();
    }

    private static void printMinionInfo(ResultSet rs) throws SQLException {
        rs.next();

        String name = rs.getString(Constants.COLUMN_LABEL_NAME);
        int age = rs.getInt(Constants.COLUMN_LABEL_AGE);

        System.out.println(name + " " + age);
    }

    private static ResultSet getMinionInfo() throws SQLException {
        PreparedStatement selectMinion = connection.prepareStatement(SELECT_MINIONS_INFO_BY_ID);

        selectMinion.setInt(1, minionId);

        return selectMinion.executeQuery();
    }

    private static void updateMinionAge() throws SQLException {
        CallableStatement updateMinionAge = connection.prepareCall(CALL_PROCEDURE);

        updateMinionAge.setInt(1, minionId);

        updateMinionAge.executeUpdate();
    }

    public static int getMinionId() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ENTER_ID);

        return Integer.parseInt(scanner.nextLine());
    }
}