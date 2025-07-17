public class SQLValidator {
    public static void main(String[] args) {
        // Sample inputs
        String query1 = "SELECT name, age FROM Students;";
        String query2 = "SELECT FROM name Students;";

        System.out.println(validateSQL(query1));  // Valid
        System.out.println(validateSQL(query2));  // Invalid
    }

    public static String validateSQL(String query) {
        // Remove leading/trailing spaces and optional semicolon
        query = query.trim();
        if (query.endsWith(";")) {
            query = query.substring(0, query.length() - 1).trim();
        }

        // Check if it starts with SELECT
        if (!query.toUpperCase().startsWith("SELECT ")) {
            return "Invalid";
        }

        // Split by SELECT and FROM
        int selectIndex = query.toUpperCase().indexOf("SELECT");
        int fromIndex = query.toUpperCase().indexOf("FROM");

        if (selectIndex != 0 || fromIndex == -1 || fromIndex <= 7) {
            return "Invalid";
        }

        // Extract column part and table part
        String columnPart = query.substring(7, fromIndex).trim(); // after SELECT to FROM
        String tablePart = query.substring(fromIndex + 4).trim(); // after FROM

        // Check if column part and table part are non-empty
        if (columnPart.isEmpty() || tablePart.isEmpty()) {
            return "Invalid";
        }

        return "Valid";
    }
}
