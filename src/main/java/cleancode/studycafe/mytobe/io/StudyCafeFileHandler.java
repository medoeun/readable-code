package cleancode.studycafe.mytobe.io;

import cleancode.studycafe.mytobe.model.StudyCafeLockerPass;
import cleancode.studycafe.mytobe.model.StudyCafePass;
import cleancode.studycafe.mytobe.model.StudyCafePassType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudyCafeFileHandler {

    public List<StudyCafePass> readStudyCafePasses() {
        return readLines(
                "src/main/resources/cleancode/studycafe/pass-list.csv",
                line -> {
                    String[] values = line.split(",");
                    return StudyCafePass.of(
                            StudyCafePassType.valueOf(values[0]),
                            Integer.parseInt(values[1]),
                            Integer.parseInt(values[2]),
                            Double.parseDouble(values[3])
                    );
                }
        );
    }

    public List<StudyCafeLockerPass> readLockerPasses() {
        return readLines("src/main/resources/cleancode/studycafe/locker.csv",
                line -> {
                    String[] values = line.split(",");
                    return StudyCafeLockerPass.of(
                            StudyCafePassType.valueOf(values[0]),
                            Integer.parseInt(values[1]),
                            Integer.parseInt(values[2])
                    );
                }
        );
    }

    private <T> List<T> readLines(String path, Function<String, T> mapper) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            return lines.stream()
                    .map(mapper)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }
}

