package practica.practicum6A;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;

    public Persoon(String nm, double bud) {
        this.naam = nm;
        this.budget = bud;
        mijnGames = new ArrayList<Game>();

    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game g) {

        boolean waarde = true;
        if (mijnGames.size() > 0)
            for (Game game : mijnGames)

                if (budget < g.huidigeWaarde() | game.equals(g)) {
                    waarde = false;
                }

        if (waarde)
            mijnGames.add(g);

        return waarde;

    }

    public boolean verkoop(Game g, Persoon koper) {

        boolean waarde2 = false;

        if (mijnGames.size() > 0) {
            for (Game game : mijnGames)
                if ( !game.equals(g) && koper.koop(g)) {

                    waarde2 = true;
                    mijnGames.remove(g);
                    budget += g.huidigeWaarde();
                    koper.budget -= g.huidigeWaarde();

                }
        }


        return waarde2;
    }

    public String toString() {
        String s = naam + " heeft een budget van "+ String.format("%.2f", budget) + " en bezit de volgende games:";
        for (Game game : mijnGames)
            s += "\n" +game.toString();
        return s;
    }
}
