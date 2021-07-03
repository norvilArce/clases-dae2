package pe.isil.player;

import pe.isil.team.ITeam;

public class MessiDI {

    private ITeam team;

    public MessiDI() {
    }

    //injeccion de dependencias por constructor
    public MessiDI(ITeam team) {
        this.team = team;
    }

    //injeccion de dependencias por setter
    public void setTeam(ITeam team) {
        this.team = team;
    }

    public void showClubName(){
        team.showClubName();
    }
}
