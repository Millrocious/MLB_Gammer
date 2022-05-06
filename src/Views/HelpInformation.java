package Views;

import java.util.LinkedList;

public class HelpInformation {
    private static LinkedList<String> messageBin = new LinkedList<>();
    private static LinkedList<String> messageMulti = new LinkedList<>();
    private static LinkedList<String> messageLong = new LinkedList<>();
    private static LinkedList<String> messageByteStr = new LinkedList<>();
    private static LinkedList<String> messageByteCode = new LinkedList<>();
    private static LinkedList<String> messageCrypted = new LinkedList<>();

    private static void printListItem(LinkedList<String> messageList, int index) {
        if (index < messageList.size()) {
            System.out.println(messageList.get(index));
        }
    }

    public static void display() {
        for (int i = 0; i < messageCrypted.size(); i++) {
            printListItem(messageBin, i);
            printListItem(messageMulti, i);
            printListItem(messageLong, i);
            printListItem(messageByteStr, i);
            printListItem(messageByteCode, i);
            printListItem(messageCrypted, i);
        }
    }

    public static LinkedList<String> getMessageBin() {
        return messageBin;
    }

    public static LinkedList<String> getMessageMulti() {
        return messageMulti;
    }

    public static LinkedList<String> getMessageLong() {
        return messageLong;
    }

    public static LinkedList<String> getMessageByteStr() {
        return messageByteStr;
    }

    public static LinkedList<String> getMessageByteCode() {
        return messageByteCode;
    }

    public static LinkedList<String> getMessageCrypted() {
        return messageCrypted;
    }

    public static void setMessageBin(String messageBin) {
        HelpInformation.messageBin.add(messageBin);
    }

    public static void setMessageMulti(String messageMulti) {
        HelpInformation.messageMulti.add(messageMulti);
    }

    public static void setMessageLong(String messageLong) {
        HelpInformation.messageLong.add(messageLong);
    }

    public static void setMessageByteStr(String  messageByteStr) {
        HelpInformation.messageByteStr.add(messageByteStr);
    }

    public static void setMessageByteCode(String messageByteCode) {
        HelpInformation.messageByteCode.add(messageByteCode);
    }

    public static void setMessageCrypted(String messageCrypted) {
        HelpInformation.messageCrypted.add(messageCrypted);
    }
}
