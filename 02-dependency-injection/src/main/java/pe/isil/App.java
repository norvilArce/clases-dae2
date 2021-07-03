package pe.isil;

import pe.isil.player.Messi;
import pe.isil.player.MessiDI;
import pe.isil.team.Barcelona;
import pe.isil.team.Juventus;
import pe.isil.team.Manchester;

public class App {
    public static void main(String[] args) {
//        Messi messi = new Messi();
//        messi.showClubName();

        MessiDI messiDI = new MessiDI(new Manchester());
        messiDI.showClubName();
    }
}
