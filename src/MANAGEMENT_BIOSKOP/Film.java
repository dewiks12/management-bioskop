package MANAGEMENT_BIOSKOP;

public class Film extends Bioskop {

    String JamTayang;
    String Studio;

    public Film(String judul, String jamTayang, String studio) {
        super(judul);
        this.JamTayang = JamTayang;
        this.Studio = Studio;
    }
    @Override
    void displayInfo() {
        System.out.println("Judul : "+ judul + ", Jam Tayang : " + JamTayang + ", Studio : " + Studio);
    }
}
