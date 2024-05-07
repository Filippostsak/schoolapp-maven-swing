package filippos.tsakiris.scool_app_pro.dao.util;

import filippos.tsakiris.scool_app_pro.enums.Gender;
import filippos.tsakiris.scool_app_pro.model.Student;
import filippos.tsakiris.scool_app_pro.service.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DBHelper {

    public static void eraseData() throws SQLException {
        String disableFKQuery = "SET @foreign_key_checks = 0";
        String enableFKQuery = "SET @foreign_key_checks = 1";
        String selectTablesQuery = "SELECT TABLE_NAME FROM information_schema.tables WHERE TABLE_SCHEMA = 'SchoolDBPro'";
        String deleteTemplate = "DELETE FROM %s";
        String resetAutoIncrementTemplate = "ALTER TABLE %s AUTO_INCREMENT = 1";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement disableFK = connection.prepareStatement(disableFKQuery);
             PreparedStatement enableFK = connection.prepareStatement(enableFKQuery);
             PreparedStatement selectTables = connection.prepareStatement(selectTablesQuery)) {

            disableFK.executeUpdate();
            ResultSet rs = selectTables.executeQuery();
            List<String> tables = mapRSToList(rs);

            for (String table : tables) {
                try (PreparedStatement deleteStmt = connection.prepareStatement(String.format(deleteTemplate, table));
                     PreparedStatement resetAIStmt = connection.prepareStatement(String.format(resetAutoIncrementTemplate, table))) {
                    deleteStmt.executeUpdate();
                    resetAIStmt.executeUpdate();
                }
            }
            enableFK.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Failed to erase data: " + e.getMessage(), e);
        }
    }

    private static List<String> mapRSToList(ResultSet rs) throws SQLException {
        List<String> tables = new ArrayList<>();
        while (rs.next()) {
            tables.add(rs.getString("TABLE_NAME"));
        }
        return tables;
    }

}
