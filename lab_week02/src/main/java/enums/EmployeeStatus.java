package enums;

public enum EmployeeStatus {
    ACTIVE(1),
    INACTIVE(0),
    STOP(-1);
    private int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

    public int getInvoke() {
        return value;
    }
}
