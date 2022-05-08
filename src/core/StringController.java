package core;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StringController {
    public static String byteToBinaryString(byte code) {
        return String.format("%8s", Integer.toBinaryString(code & 0xFF)).replace(' ', '0');
    }

    public static String bytesToBinaryString(ArrayList<Byte> code) {
        return code.stream()
                .map(StringController::byteToBinaryString)
                .collect( Collectors.joining(""));
    }
}
