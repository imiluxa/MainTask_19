public class Arithmetics {
    private int first;
    private int second;

    Arithmetics(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int Summ() {
        return this.first + this.second;
    }

    public static int Summ(int first, int second) {
        return first + second;
    }
}
