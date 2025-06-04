package cleancode.studycafe.mytobe.io;

import cleancode.studycafe.mytobe.exception.AppException;
import cleancode.studycafe.mytobe.model.StudyCafePass;
import cleancode.studycafe.mytobe.model.StudyCafePassType;

import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private static final String YES_INPUT = "1";

    private static final Scanner SCANNER = new Scanner(System.in);

    public StudyCafePassType getPassTypeSelectingUserAction() {
        return StudyCafePassType.fromInput(SCANNER.nextLine());
    }

    public StudyCafePass getSelectPass(List<StudyCafePass> passes) {
        try {
            int selectedIndex = Integer.parseInt(SCANNER.nextLine()) - 1;
            return passes.get(selectedIndex);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new AppException("올바르지 않은 선택입니다.");
        }
    }

    public boolean doesUserWantLocker() {
        String userInput = SCANNER.nextLine();

        if (!"1".equals(userInput) && !"2".equals(userInput)) {
            throw new AppException("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
        }

        return YES_INPUT.equals(userInput);
    }
}
