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

        if (budget < g.huidigeWaarde() ) {
            waarde = false;
            return waarde;
        }

        if (mijnGames.size() > 0) {
            for (Game game : mijnGames) {
                if (game.equals(g)) {
                    waarde = false;
                    return waarde;
                }
            }
        }

        mijnGames.add(g);
        budget = budget - g.huidigeWaarde();
        System.out.println(budget);

        return waarde;
    }

    public boolean verkoop(Game g, Persoon koper) {

        boolean waarde2 = false;

        if (mijnGames.size() > 0) {
            for (Game game : mijnGames)
                if ( game.equals(g) && koper.koop(g)) {

                    waarde2 = true;
                    mijnGames.remove(g);
                    budget += g.huidigeWaarde();
                    return waarde2;

                }
        }


        return waarde2;
    }

    public Game zoekGameOpNaam(String g) {

        Game status = null;


        for (Game game : mijnGames)
            if (game.equals(g)) {
                status = null;
                return status;
            } else {
                status = game;
            }

        return status;

    }

    public String toString() {
        String s = naam + " heeft een budget van €"+ String.format("%.2f", budget) + " en bezit de volgende games:";
        for (Game game : mijnGames)
            s += "\n" +game.toString();
        return s;
    }
}
