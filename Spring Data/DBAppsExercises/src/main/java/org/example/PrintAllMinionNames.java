package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;

public class PrintAllMinionNames {

    private static final String SELECT_ALL_MINIONS = "SELECT name FROM minions ORDER BY id";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement getAllMinions = connection.prepareStatement(SELECT_ALL_MINIONS);
        final ResultSet resultSet = getAllMinions.executeQuery();

        ArrayDeque<String> minionNames = new ArrayDeque<>();

        while (resultSet.next()) {
            minionNames.offer(resultSet.getString(Constants.COLUMN_LABEL_NAME));
        }

        while (minionNames.size() > 2) {
            System.out.println(minionNames.pollFirst());
            System.out.println(minionNames.pollLast());
        }

        while (!minionNames.isEmpty()) {
            System.out.println(minionNames.poll());
        }

        connection.close();
    }
}