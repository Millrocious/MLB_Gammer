package core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringController {
    public static String byteToBinaryString(byte code) {
        return String.format("%8s", Integer.toBinaryString(code & 0xFF)).replace(' ', '0');
    }

    public static String bytesToBinaryString(List<Byte> code) {
        return code.stream()
                .map(StringController::byteToBinaryString)
                .toString();
    }
}
