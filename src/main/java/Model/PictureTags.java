package Model;

public enum PictureTags {

    ONE(new ImageFile("1.jpg", 1, 1, "Animals")),
    TWO(new ImageFile("2.jpg",1, 4, "Mems")),
    THREE(new ImageFile("3.jpg", 1, 7, "GoT")),
    FOUR(new ImageFile("4.jpg", 2, 12, "Mems")),
    FIVE(new ImageFile("5.jpg",2, 110, "World")),
    SIX(new ImageFile("6.jpg",2, 30, "World")),
    SEVEN(new ImageFile("7.jpg",33, 60, "World")),
    EIGHT(new ImageFile("8.jpg",46, 90, "Animals")),
    NINE(new ImageFile("9.jpg",360, 1050, "Animals")),
    TEN(new ImageFile("10.jpg",370, 2000, "GoT"));

    private ImageFile imageFile;

    PictureTags(ImageFile imageFile) {
        this.imageFile = imageFile;
    }

    public String getMainName() {
        return this.imageFile.getNameImage();
    }

    public int getDate() {
        return this.imageFile.getDate();
    }

    public int getMass() {
        return this.imageFile.getMass();
    }

    public String getTag() {
        return this.imageFile.getTag();
    }

}
