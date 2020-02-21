package Model;

import java.util.ArrayList;

public class Model {

    private static ArrayList<NameTags> nameTagsList = new ArrayList<NameTags>();
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

    public void addNameTag(NameTags nameTags) {
        nameTagsList.add(nameTags);
    }

    public static ArrayList<NameTags> getNameTagsList() {
        return nameTagsList;
    }

    public static void setNameTagsList(ArrayList<NameTags> nameTagsList) {
        Model.nameTagsList = nameTagsList;
    }

}
