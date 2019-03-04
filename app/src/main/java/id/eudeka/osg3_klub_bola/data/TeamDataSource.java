package id.eudeka.osg3_klub_bola.data;

import id.eudeka.osg3_klub_bola.model.Team;

public interface TeamDataSource {

    void getListTeams(GetTeamsCallback callback);


    interface GetTeamsCallback {
        void onTeamLoaded(Team data);
        void onDataNotAvailable(String errorMessage);
    }


}
