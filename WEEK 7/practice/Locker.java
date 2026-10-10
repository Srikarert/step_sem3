public class Locker {
    private String combinationCode;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        boolean change1 = l.changeCode("1234", "5678");
        System.out.println("Change code 1234->5678: " + (change1 ? "success" : "rejected"));

        boolean change2 = l.changeCode("0000", "9999");
        System.out.println("Change code 0000->9999: " + (change2 ? "success" : "rejected"));

        boolean change3 = l.changeCode("5678", "9999");
        System.out.println("Change code 5678->9999: " + (change3 ? "success" : "rejected"));
    }
}
