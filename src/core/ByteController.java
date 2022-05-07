package core;

import Models.CodeGenerator;

import javax.sound.sampled.AudioFormat;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ByteController {
    public static List<Byte> getBytesFromString(String input) {
        byte[] byteArray = input.getBytes(StandardCharsets.UTF_8);
        return IntStream.range(0, byteArray.length)
                .mapToObj((int i) -> byteArray[i])
                .collect(Collectors.toList());
    }
    private static byte getByteFromInteger(int res, int shift) {
        return (byte) (res >> 24-(8*shift) & 0xFF);
    }

    public static List<Byte> getBytesFromInteger(int res, int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> getByteFromInteger(res, i))
                .toList();
    }

    private static byte getByteFromLong(long res, int shift) {
        return (byte) ((res >> CodeGenerator.SHIFT_SIZE-(8L * shift)) & 0xFF);
    }

    public static List<Byte> getBytesFromLong(long res, int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> getByteFromLong(res, i))
                .toList();
    }
}
