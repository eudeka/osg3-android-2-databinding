package id.eudeka.osg3_klub_bola.data.local;

import android.content.Context;

import id.eudeka.osg3_klub_bola.data.TeamDataSource;
import id.eudeka.osg3_klub_bola.model.Team;
import id.eudeka.osg3_klub_bola.model.TeamDetail;

import java.util.List;

public class TeamLocalDataSource implements TeamDataSource {

    private Context context;
    private TeamDao teamDao;

    public TeamLocalDataSource(Context context) {
        this.context = context;
        teamDao = TeamDataBase.getInstance(context).teamDao();
    }

    @Override
    public void getListTeams(final GetTeamsCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<TeamDetail> team = teamDao.getTeams();
                if (team.isEmpty()) {
                    callback.onDataNotAvailable("Data di Database SQLite kosong");
                } else {
                    Team teams = new Team(team);
                    callback.onTeamLoaded(teams);
                }
            }
        };
        new Thread(runnable).start();
    }


    public void saveDataTeam(final List<TeamDetail> teamDetail) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                teamDao.insertTeam(teamDetail);
            }
        };
        new Thread(runnable).start();

    }

}