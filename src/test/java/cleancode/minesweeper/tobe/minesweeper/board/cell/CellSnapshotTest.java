package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CellSnapshot 단위 테스트")
public class CellSnapshotTest {

    @DisplayName("ofFlag FLAG 상태 반환")
    @Test
    void ofFlag_returnsFlagStatus() {
        // when
        CellSnapshot snapshot = CellSnapshot.ofFlag();

        // then
        assertEquals(CellSnapshotStatus.FLAG, snapshot.getStatus());
    }

    @DisplayName("같은 상태와 값이면 equals true")
    @Test
    void sameStatusAndValue_equalsTrue() {
        // given
        CellSnapshot a = CellSnapshot.ofNumber(3);
        CellSnapshot b = CellSnapshot.of(CellSnapshotStatus.NUMBER, 3);

        // then
        assertEquals(a, b);
    }

}
