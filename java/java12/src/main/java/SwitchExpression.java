public class SwitchExpression {
    public static void main(String[] args) {
        System.out.println(getSeasonOfMonth("FEBRUARY"));
        System.out.println(getSeasonOfMonth2("MAY"));
    }

    private static String getSeasonOfMonth(String month) {
        String season = "";

        switch (month.toUpperCase()) {
            case "JANUARY", "DECEMBER", "FEBRUARY" -> season = "Winter";
            case "MARCH", "MAY", "APRIL" -> season = "Spring";
            case "JUNE" -> season = "June";
            case "JULY" -> season = "July";
            case "AUGUST" -> season = "August";
            case "SEPTEMBER", "NOVEMBER", "OCTOBER" -> season = "Autumn";
            default -> season = "Unknown";
        }

        return season;
    }

    private static String getSeasonOfMonth2(String month) {
        return switch (month.toUpperCase()) {
            case "JANUARY", "DECEMBER", "FEBRUARY" -> "Winter";
            case "MARCH", "MAY", "APRIL" -> "Spring";
            case "JUNE", "AUGUST", "JULY" -> "Summer";
            case "SEPTEMBER", "NOVEMBER", "OCTOBER" -> "Autumn";
            default -> "Unknown";
        };
    }
}
