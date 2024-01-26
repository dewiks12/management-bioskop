package MANAGEMENT_BIOSKOP;
public abstract class Bioskop {
    String judul;

    public Bioskop(String judul){
        this.judul = judul;
    }

    abstract void displayInfo();
}
