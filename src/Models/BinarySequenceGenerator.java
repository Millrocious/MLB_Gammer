package Models;

public class BinarySequenceGenerator {
    private int key;
    private int phase;

    public BinarySequenceGenerator(int key, int phase) {
        this.key = key;
        this.phase = phase;
    }

    public boolean generateRecurrenceSequence() {
        int recurrenceSequenceTemp;
        int recurrenceSequenceBitCount;

        recurrenceSequenceTemp = phase & key;
        recurrenceSequenceBitCount = Integer.bitCount(recurrenceSequenceTemp);

        phase <<= 1;

        if (recurrenceSequenceBitCount % 2 == 1) {
            phase++;
        }
        //System.out.println(!((phase & 0x80) == 0));
        return !((phase & 0x80) == 0);
    }
}