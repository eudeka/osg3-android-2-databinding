package id.eudeka.osg3_klub_bola.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

    @Entity(tableName = "team")
    public class TeamDetail {

        @PrimaryKey(autoGenerate = true)
        public int mId;


        @ColumnInfo(name = "team_name")
        @SerializedName("strTeam")
        public String teamName;


        @ColumnInfo(name = "team_logo")
        @SerializedName("strTeamBadge")
        public  String teamLogo;


        public int getmId() {
            return mId;
        }


        public String getTeamName() {
            return teamName;
        }


        public String getTeamLogo() {
            return teamLogo;
        }

        public TeamDetail(int mId, String teamName, String teamLogo) {

            this.mId = mId;
            this.teamName = teamName;
            this.teamLogo = teamLogo;
        }
    }
