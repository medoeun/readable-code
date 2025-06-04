package cleancode.studycafe.mytobe.model;

import cleancode.studycafe.mytobe.exception.AppException;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권", "%s시간권 - %d원"),
    WEEKLY("주 단위 이용권", "%s주권 - %d원"),
    FIXED("1인 고정석", "%s주권 - %d원");

    private final String description;
    private final String format;

    StudyCafePassType(String description, String format) {
        this.description = description;
        this.format = format;
    }

//    public String getDescription() {
//        return description;
//    }

    public String formatDisplay(int duration, int price) {
        return String.format(format, duration, price);
    }

    public static StudyCafePassType fromInput(String input) {
        return switch (input) {
            case "1" -> HOURLY;
            case "2" -> WEEKLY;
            case "3" -> FIXED;
            default -> throw new AppException("잘못된 입력입니다.");
        };
    }
}
