package Models;

import Views.HelpInformation;
import core.CodeController;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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
        int shiftCoef = (int) (SHIFT_SIZE - NUM_BIT_LENGTH); // 8*4-4 = 28
        long longCode = 0;
        int newCodeBits;
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("[?] Multi code -> ");
        for (int i = 0; i < 8; i++) {
            newCodeBits = 0;
            for (int j = 0; j < n; j++) {
                newCodeBits += keyArray[j] * phaseArray[j];
            }
            newCodeBits %= p;
            strBuild.append(newCodeBits).append(" ");

            for (int j = 0; j < n-1; ) {
                phaseArray[j] = phaseArray[++j];
            }
            phaseArray[n-1] = (byte)newCodeBits;

            longCode += ((long) newCodeBits << shiftCoef);
            shiftCoef -= NUM_BIT_LENGTH;
        }
        HelpInformation.setMessageMulti(strBuild.toString());
        return longCode;
    }

    public static int getP() {
        return p;
    }

    public int getN() {
        return n;
    }


}