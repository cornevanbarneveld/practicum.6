package practica.practicum6A;
import java.time.Year;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr) {
        this.naam = nm;
        this.releaseJaar = rJ;
        this.nieuwprijs = nwpr;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        int year = Year.now().getValue();
        int verschilJaren = (year - releaseJaar);

        double prijs = nieuwprijs;

        for (int i = 1; i <= verschilJaren; ++i) {
            prijs = prijs * 0.7;

        }

        return prijs;
    }

    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false;

        if (andereObject instanceof Game) {
            Game andereGame = (Game) andereObject;

            if (this.naam.equals(andereGame.naam) && this.releaseJaar == andereGame.releaseJaar) {

                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }

    public String toString() {
        String s = naam +", uitgegeven in " + releaseJaar +"; nieuwprijs: €" +String.format("%.2f", nieuwprijs)+ " nu voor: €" + String.format("%.2f", huidigeWaarde()) ;
        return s;

    }
}


