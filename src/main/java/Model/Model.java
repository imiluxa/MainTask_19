package Model;

import java.util.ArrayList;

public class Model {

    private static ArrayList<Date_Range> date_rangeList = new ArrayList<Date_Range>();
    private static ArrayList<FileMass> fileMassList = new ArrayList<FileMass>();
    private static ArrayList<PictureTags> pictureTagsList = new ArrayList<PictureTags>();

    public void addPictureTags(PictureTags pictureTags) {
        pictureTagsList.add(pictureTags);
    }

    public static ArrayList<PictureTags> getPictureTagsList() {
        return pictureTagsList;
    }

    public static void setPictureTagsList(ArrayList<PictureTags> pictureTagsList) {
        Model.pictureTagsList = pictureTagsList;
    }

    public void addFileMass(FileMass fileMass) {
        fileMassList.add(fileMass);
    }

    public static ArrayList<FileMass> getFileMassList() {
        return fileMassList;
    }

    public static void setFileMassList(ArrayList<FileMass> fileMassList) {
        Model.fileMassList = fileMassList;
    }

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
