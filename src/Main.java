import Controllers.ThreadController;
import Models.BinarySequenceGenerator;
import Models.CodeGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CodeGenerator codeGen = new CodeGenerator(
                new byte[] {2, 0, 1, 12},
                new byte[]  {9, 9, 9, 9},
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