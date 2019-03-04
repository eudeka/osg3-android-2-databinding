package id.eudeka.osg3_klub_bola;

import android.content.Context;

import id.eudeka.osg3_klub_bola.data.TeamRepository;
import id.eudeka.osg3_klub_bola.data.local.TeamLocalDataSource;
import id.eudeka.osg3_klub_bola.data.remote.TeamRemoteDataSource;

public class Injection {
    public static TeamRepository provideTeamRepository(Context context) {
        return new TeamRepository(new TeamRemoteDataSource(), new TeamLocalDataSource(context));
    }
}
