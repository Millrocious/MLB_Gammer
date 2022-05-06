package core;

import java.util.ArrayList;

public class StringController {
    public static String byteToBinaryString(byte code) {
        return String.format("%8s", Integer.toBinaryString(code & 0xFF)).replace(' ', '0');
    }

    public static String bytesToBinaryString(ArrayList<Byte> code) {
        StringBuilder temp = new StringBuilder();
        for (Byte index : code) {
            temp.append(byteToBinaryString(index));
        }

        return temp.toString();
    }
}
