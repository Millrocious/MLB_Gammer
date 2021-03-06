package core;

import Models.CodeGenerator;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ByteController {
    public static ArrayList<Byte> getBytesFromString(String input) {
        return input.chars()
                .mapToObj(c -> (byte)c)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    private static byte getByteFromInteger(int res, int shift) {
        return (byte) (res >> 24-(8*shift) & 0xFF);
    }

    public static ArrayList<Byte> getBytesFromInteger(int res, int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> getByteFromInteger(res, i))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static byte getByteFromLong(long res, int shift) {
        return (byte) ((res >> CodeGenerator.SHIFT_SIZE-(8L * shift)) & 0xFF);
    }

    public static ArrayList<Byte> getBytesFromLong(long res, int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> getByteFromLong(res, i))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
