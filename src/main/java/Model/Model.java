package Model;

import java.util.ArrayList;

public class Model {

    private static ArrayList<Date_Range> date_rangeList = new ArrayList<Date_Range>();

    public void addDateRange(Date_Range date_range) {
        date_rangeList.add(date_range);
    }

    public static ArrayList<Date_Range> getDate_rangeList() {
        return date_rangeList;
    }

    public static void setDate_rangeList(ArrayList<Date_Range> date_rangeList) {
        Model.date_rangeList = date_rangeList;
    }

}
