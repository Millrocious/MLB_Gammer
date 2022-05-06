package core;

import Models.CodeGenerator;

import java.util.ArrayList;

public class ByteController {
    public static ArrayList<Byte> getBytesFromString(String input) {
        ArrayList<Byte> strByteArr = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            strByteArr.add((byte) (input.charAt(i)));
        }
        return strByteArr;
    }
    private static byte getByteFromInteger(int res, int shift) {
        return (byte) (res >> 24-(8*shift) & 0xFF);
    }

    public static ArrayList<Byte> getBytesFromInteger(int res, int size) {
        ArrayList<Byte> resArr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resArr.add(getByteFromInteger(res, i));
        }
        return resArr;
    }

    private static byte getByteFromLong(long res, int shift) {
        return (byte) ((res >> CodeGenerator.SHIFT_SIZE-(8L * shift)) & 0xFF);
    }

    public static ArrayList<Byte> getBytesFromLong(long res, int size) {
        ArrayList<Byte> resArr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resArr.add(getByteFromLong(res, i));
        }
        return resArr;
    }
}
