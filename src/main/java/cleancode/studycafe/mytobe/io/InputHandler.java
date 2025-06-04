package cleancode.studycafe.mytobe.io;

import cleancode.studycafe.mytobe.exception.AppException;
import cleancode.studycafe.mytobe.model.StudyCafePass;
import cleancode.studycafe.mytobe.model.StudyCafePassType;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputHandler {

    private static final Map<String, StudyCafePassType> passTypeMap = Map.of(
            "1", StudyCafePassType.HOURLY,
            "2", StudyCafePassType.WEEKLY,
            "3", StudyCafePassType.FIXED
    );
    private static final Scanner SCANNER = new Scanner(System.in);

    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();
        if (!passTypeMap.containsKey(userInput)) {
            throw new AppException("잘못된 입력입니다.");
        }
        return passTypeMap.get(userInput);
    }

    public StudyCafePass getSelectPass(List<StudyCafePass> passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = Integer.parseInt(userInput) - 1;
        return passes.get(selectedIndex);
    }

    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return "1".equals(userInput);
    }

}
