package Model;


public enum Date_Range {
    TODAY(0),
    THISWEEK(7),
    THISMONTH(31),
    THISYEAR(365);

    private int dayBack;

    Date_Range(int i) {
        this.dayBack = i;
    }

    public int getDayBack() {
        return dayBack;
    }
}
