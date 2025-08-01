package PhoneManage;

public class IdGenerator {
    private static int newPhoneCount = 0;
    private static int oldPhoneCount = 0;

    public static String generateNewPhoneId() {
        newPhoneCount++;
        return String.format("DTM%03d", newPhoneCount);
    }
    public static String generateOldPhoneId() {
        oldPhoneCount++;
        return String.format("DTC%03d", oldPhoneCount);
    }
}
