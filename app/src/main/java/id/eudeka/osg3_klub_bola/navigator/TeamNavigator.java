package id.eudeka.osg3_klub_bola.navigator;

import id.eudeka.osg3_klub_bola.model.TeamDetail;

import java.util.List;

public interface TeamNavigator {

    void loadListTeam(List<TeamDetail> listTeam);
    void errorLoadListTeam(String message);
}
