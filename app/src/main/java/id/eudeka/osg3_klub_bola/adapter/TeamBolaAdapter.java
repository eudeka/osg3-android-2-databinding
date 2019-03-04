package id.eudeka.osg3_klub_bola.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.educa62.osg3_klub_bola.R;

import id.eudeka.osg3_klub_bola.model.TeamDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamBolaAdapter extends RecyclerView.Adapter<TeamBolaAdapter.TeamBolaHolder> {

    private List<TeamDetail> listKlubBola;

    public TeamBolaAdapter(List<TeamDetail> listKlubBola) {
        this.listKlubBola = listKlubBola;
    }

    @NonNull
    @Override
    public TeamBolaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()
        ).inflate(R.layout.item_row, viewGroup, false);
        return new TeamBolaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamBolaHolder klubBolaHolder, int i) {

        TeamDetail data = listKlubBola.get(i);
        klubBolaHolder.clubName.setText(data.getTeamName());
        Picasso.get().load(data.getTeamLogo()).into(klubBolaHolder.clubImage);
    }

    @Override
    public int getItemCount() {
        return listKlubBola.size();
    }

    public class TeamBolaHolder extends RecyclerView.ViewHolder {

        TextView clubName;
        ImageView clubImage;

        public TeamBolaHolder(@NonNull View itemView) {
            super(itemView);
            clubName = (TextView) itemView.findViewById(R.id.txt_item_club_name);
            clubImage = (ImageView) itemView.findViewById(R.id.item_club_img);
        }
    }

}
