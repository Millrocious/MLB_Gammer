package core;

import java.util.ArrayList;

public class GammingController {
    public static String cryptString(ArrayList<Byte> strByteArr, ArrayList<Byte> byteArr) {
        char[] chars = new char[strByteArr.size()];
        for (int i = 0; i < strByteArr.size(); i++) {
            chars[i] = cryptChar(byteArr.get(i), strByteArr.get(i));
            //System.out.println(cryptChar(byteArr.get(i), strByteArr.get(i)));
        }
        //System.out.println(new String(chars));
        return new String(chars);
    }

    public static char cryptChar(byte str, byte code) {
        return (char) ((byte) (code ^ str));
    }
}
