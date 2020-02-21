package Model;

public enum FileMass {
    LESSONEMB(1,1),
    LESSTHREEMB(2,3),
    LESSTENMB(3,10),
    LESSGB(4,1024);

    private int id;
    private int massMb;

    FileMass(int id, int massMb) {
        this.id = id;
        this.massMb = massMb;
    }

    public int getMassMb() {
        return massMb;
    }

    public int getId() {
        return id;
    }
}
