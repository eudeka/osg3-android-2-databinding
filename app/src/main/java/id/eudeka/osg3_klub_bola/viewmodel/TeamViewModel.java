package id.eudeka.osg3_klub_bola.viewmodel;

import android.content.Context;

import id.eudeka.osg3_klub_bola.data.TeamDataSource;
import id.eudeka.osg3_klub_bola.data.TeamRepository;
import id.eudeka.osg3_klub_bola.model.Team;
import id.eudeka.osg3_klub_bola.navigator.TeamNavigator;

public class TeamViewModel {

    private TeamRepository teamRepository;
    private Context context;
    private TeamNavigator mNavigator;


    public TeamViewModel(TeamRepository teamRepository, Context context) {
        this.teamRepository = teamRepository;
        this.context = context;
    }

    public void setNavigator(TeamNavigator navigator) {
        mNavigator = navigator;
    }

    public void getListTeam() {

        teamRepository.getListTeams(new TeamDataSource.GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                mNavigator.loadListTeam(data.getTeams());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                mNavigator.errorLoadListTeam(errorMessage);
            }
        });
    }
}
