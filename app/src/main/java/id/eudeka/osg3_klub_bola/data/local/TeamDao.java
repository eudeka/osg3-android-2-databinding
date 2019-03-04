package id.eudeka.osg3_klub_bola.data.local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import id.eudeka.osg3_klub_bola.model.TeamDetail;

import java.util.List;

@Dao
public interface TeamDao {
    @Query("SELECT * FROM team")
    List<TeamDetail> getTeams();

    @Insert
    void insertTeam(List<TeamDetail> team);
}
