package id.eudeka.osg3_klub_bola.data;

import android.support.annotation.Nullable;

import id.eudeka.osg3_klub_bola.data.local.TeamLocalDataSource;
import id.eudeka.osg3_klub_bola.data.remote.TeamRemoteDataSource;
import id.eudeka.osg3_klub_bola.model.Team;

public class TeamRepository implements TeamDataSource {

    private TeamRemoteDataSource teamRemoteDataSource;
    private TeamLocalDataSource teamLocalDataSource;

    public TeamRepository(TeamRemoteDataSource teamRemoteDataSource, TeamLocalDataSource teamLocalDataSource) {
        this.teamRemoteDataSource = teamRemoteDataSource;
        this.teamLocalDataSource = teamLocalDataSource;
    }

    @Override
    public void getListTeams(final GetTeamsCallback callback) {
        teamLocalDataSource.getListTeams(new GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                callback.onTeamLoaded(data);
            }
            @Override
            public void onDataNotAvailable(String errorMessage) {
                getTeamsfromRemoteDataSource(callback);
            }
        });
    }

    private void getTeamsfromRemoteDataSource(@Nullable final GetTeamsCallback callback) {

        teamRemoteDataSource.getListTeams(new GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {

                //insert  to Database
                teamLocalDataSource.saveDataTeam(data.getTeams());
                callback.onTeamLoaded(data);
            }
            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        });
    }

}
