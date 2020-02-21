package Model;


public enum Date_Range {
    TODAY(1,0),
    THISWEEK(2,7),
    THISMONTH(3,31),
    THISYEAR(4,365);

    private int id;
    private int dayBack;

    Date_Range(int id, int i) {
        this.id = id;
        this.dayBack = i;
    }

    public int getDayBack() {
        return dayBack;
    }

    public int getId() {
        return id;
    }
}
