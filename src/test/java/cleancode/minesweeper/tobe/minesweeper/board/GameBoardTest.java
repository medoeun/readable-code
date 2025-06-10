package cleancode.minesweeper.tobe.minesweeper.board;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshotStatus;
import cleancode.minesweeper.tobe.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.GameLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("GameBoard 단위 테스트")
public class GameBoardTest {

    private GameBoard gameBoard;

    @BeforeEach
    void setUp() {
        GameLevel dummyLevel = new GameLevel() {
            @Override public int getRowSize() { return 3; }
            @Override public int getColSize() { return 3; }
            @Override public int getLandMineCount() { return 0; } // 테스트 편의를 위해 지뢰 없음
        };
        gameBoard = new GameBoard(dummyLevel);
        gameBoard.initializeGame();
    }

    @DisplayName("초기화 시 IN_PROGRESS")
    @Test
    void isInProgress_afterInitialization() {
        // when
        boolean inProgress = gameBoard.isInProgress();

        // then
        assertTrue(inProgress);
    }

    @DisplayName("보드 범위 밖 유효하지 않은 좌표")
    @Test
    void outOfBoundPosition_isInvalid() {
        // given
        CellPosition outOfBounds = CellPosition.of(100, 100); // 확실히 범위 밖

        // when
        boolean result = gameBoard.isInvalidCellPosition(outOfBounds);

        // then
        assertTrue(result);
    }

    @DisplayName("보드 범위 내 유효한 좌표")
    @Test
    void validPosition_isNotInvalid() {
        // given
        CellPosition valid = CellPosition.of(1, 1);

        // when
        boolean result = gameBoard.isInvalidCellPosition(valid);

        // then
        assertFalse(result);
    }

    @DisplayName("모든 셀 열리면 WIN")
    @Test
    void isWin_afterAllSafeCellsOpened() {
        // given
        CellPosition safe = CellPosition.of(0, 0);

        // when
        gameBoard.openAt(safe);

        // then
        assertTrue(gameBoard.isWinStatus());
    }

    @DisplayName("깃발 꽂으면 셀 상태 FLAG")
    @Test
    void setsFlagStatus_whenFlagged() {
        // given
        CellPosition pos = CellPosition.of(0, 0);

        // when
        gameBoard.flagAt(pos);

        // then
        CellSnapshot snapshot = gameBoard.getSnapshot(pos);
        assertTrue(snapshot.isSameStatus(CellSnapshotStatus.FLAG));
    }


}
