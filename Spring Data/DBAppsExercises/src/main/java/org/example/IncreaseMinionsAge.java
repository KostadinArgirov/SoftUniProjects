package org.example;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.example.Constants.COLUMN_LABEL_AGE;

public class IncreaseMinionsAge {

    private static final String SELECT_ALL_MINIONS = "SELECT name, age FROM minions ORDER BY id";
    private static final String UPDATE_MINIONS_BY_ID = "UPDATE minions SET age = age + 1, name = lower(name) WHERE id IN (%s)";

    public static void main(String[] args) throws SQLException {
        Scanner console = new Scanner(System.in);

        List<String> minionIds = Arrays.stream(console.nextLine().split("\\s+")).collect(Collectors.toList());

        final Connection connection = Utils.getSQLConnection();

        updateMinions(minionIds, connection);

        printMinions(connection);

        connection.close();
    }

    private static void printMinions(Connection connection) throws SQLException {
        final PreparedStatement selectMinions = connection.prepareStatement(SELECT_ALL_MINIONS);
        final ResultSet printMinions = selectMinions.executeQuery();

        while (printMinions.next()) {
            String name = printMinions.getString(Constants.COLUMN_LABEL_NAME);
            int age = printMinions.getInt(COLUMN_LABEL_AGE);

            System.out.println(name + " " + age);
        }
    }

    private static void updateMinions(List<String> minionsId, Connection connection) throws SQLException {
        String updateMinionsSQL = String.format(UPDATE_MINIONS_BY_ID,
                minionsId.stream()
                        .map(v -> "?")
                        .collect(Collectors.joining(", ")));

        final PreparedStatement updateMinions = connection.prepareStatement(updateMinionsSQL);

        for (int i = 1; i <= minionsId.size(); i++) {
            updateMinions.setInt(i, Integer.parseInt(minionsId.get(i - 1)));
        }

        updateMinions.executeUpdate();
    }
}