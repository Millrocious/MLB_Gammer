import Controllers.ThreadController;
import Models.BinarySequenceGenerator;
import Models.CodeGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CodeGenerator codeGen = new CodeGenerator(
                new short[] {2, 0, 1},
                new short[] {4, 4, 4},
                5
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