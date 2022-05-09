import Controllers.ThreadController;
import Models.BinarySequenceGenerator;
import Models.CodeGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CodeGenerator codeGen = new CodeGenerator(
                new short[] {0xb, 0xc, 0xc, 0},
                new short[] {0xc, 0xc, 0xc, 0xb},
                13
        );
        BinarySequenceGenerator binSeqGen = new BinarySequenceGenerator(0b1100101, 0b1010011);

        String input = "Java Forever FoReVeR";

        ArrayList<String> splitInput = new ArrayList<>(Arrays.asList(input.split(
                "(?<=\\G.{"+CodeGenerator.NUM_BIT_LENGTH+"})")));


        System.out.println(splitInput);
        ThreadController thrd = new ThreadController(binSeqGen, codeGen, splitInput);

        thrd.start();
    }
}