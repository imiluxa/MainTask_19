package Model;

public enum NameTags {
    ANIMALS(1,"Animals"),
    MEMS(2,"Mems"),
    WORLD(3,"World"),
    GOT(4,"GoT");

    private int id;
    private String tag;

    NameTags(int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public static String getTagById(int id) {
        String returnValue = "";
        for (NameTags nameTags :
            NameTags.values()) {
            if (nameTags.getId() == id) {
                returnValue = nameTags.getTag();
            }
        }
        return returnValue;
    }

    public String getTag() {
        return this.tag;
    }

    public int getId() {
        return this.id;
    }
}
