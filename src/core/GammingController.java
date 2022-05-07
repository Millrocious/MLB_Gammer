package core;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class GammingController {
    public static String cryptString(ArrayList<Byte> strByteArr, ArrayList<Byte> byteArr) {
        return IntStream.range(0, Math.min(strByteArr.size(), byteArr.size()))
                .map(i-> cryptChar(byteArr.get(i), strByteArr.get(i)))
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static char cryptChar(byte str, byte code) {
        return (char) ((byte) (code ^ str));
    }
}
