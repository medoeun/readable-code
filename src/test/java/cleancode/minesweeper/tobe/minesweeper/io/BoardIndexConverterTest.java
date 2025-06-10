package cleancode.minesweeper.tobe.minesweeper.io;

import cleancode.minesweeper.tobe.minesweeper.exception.GameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BoardIndexConverter 단위 테스트")
public class BoardIndexConverterTest {

    private final BoardIndexConverter converter = new BoardIndexConverter();

    @DisplayName("정상 값 입력 시 올바른 행 인덱스 반환")
    @Test
    void returnsRowIndex_forValidInput() {
        // given
        String input = "b3"; // row = 3 → index = 2

        // when
        int rowIndex = converter.getSelectedRowIndex(input);

        // then
        assertEquals(2, rowIndex);
    }

    @DisplayName("정상 값 입력 시 올바른 열 인덱스 반환")
    @Test
    void returnsColIndex_forValidInput() {
        // given
        String input = "b3"; // 'b' → index = 1

        // when
        int colIndex = converter.getSelectedColIndex(input);

        // then
        assertEquals(1, colIndex);
    }

    @DisplayName("잘못된 숫자 입력 시 예외 발생")
    @Test
    void throwsException_forInvalidRowNumber() {
        // given
        String input = "a0";

        // when & then
        assertThrows(GameException.class, () -> converter.getSelectedRowIndex(input));
    }

    @DisplayName("잘못된 문자 입력 시 예외 발생")
    @Test
    void throwsException_forInvalidColChar() {
        // given
        String input = "1a"; // 첫 문자가 숫자 → invalid

        // when & then
        assertThrows(GameException.class, () -> converter.getSelectedColIndex(input));
    }

}
