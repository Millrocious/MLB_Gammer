package Models;

import Views.HelpInformation;
import core.CodeController;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class CodeGenerator {
    private short[] keyArray;
    private short[] phaseArray;
    private static int p;
    private int n;

    public static int NUM_BIT_LENGTH;
    public static long SHIFT_SIZE;

    public CodeGenerator(short[] keyArray, short[] phaseArray, int p) {
        this.keyArray = keyArray;
        this.phaseArray = phaseArray;
        this.p = p;
        n = this.keyArray.length;

        NUM_BIT_LENGTH = CodeController.getBitLengthOfInteger(p);
        SHIFT_SIZE = 8L * NUM_BIT_LENGTH;

    }

    public long generateCodeLong() { // String key = "201", phase = "444"; 5**3
        AtomicInteger shiftCoef = new AtomicInteger((int) (SHIFT_SIZE - NUM_BIT_LENGTH)); // 8*4-4 = 28
        AtomicLong longCode = new AtomicLong();
        AtomicInteger newCodeBits = new AtomicInteger();
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("[?] Multi code -> ");

        IntStream.range(0, 8).forEach(i -> {
            newCodeBits.set(0);
            IntStream.range(0, n).forEach(j -> newCodeBits.addAndGet(keyArray[j] * phaseArray[j]));
            IntStream.range(0, n-1).forEach(j -> phaseArray[j] = phaseArray[j+1]);
            phaseArray[n-1] = (short) newCodeBits.get();

            newCodeBits.updateAndGet(v -> v % p);
            strBuild.append(newCodeBits.get()).append(" ");

            longCode.addAndGet((long) newCodeBits.get() << shiftCoef.get());
            shiftCoef.updateAndGet(v -> v - NUM_BIT_LENGTH);
        });
//        for (int i = 0; i < 8; i++) {
//
//        }
        HelpInformation.setMessageMulti(strBuild.toString());
        return longCode.get();
    }

    public static int getP() {
        return p;
    }

    public int getN() {
        return n;
    }


}