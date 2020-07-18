package com.example.shonmaker.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shonmaker.R;
import com.example.shonmaker.ui.Player;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private List<Player> players;
    private Context context;

    public GroupAdapter(List<Player> players, Context context) {
        this.players = players;
        this.context = context;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_row,parent , false);
        return new GroupViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        holder.name.setText(players.get(position).getName());
        holder.position.setText(players.get(position).getPosition());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView position;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            position = itemView.findViewById(R.id.item_position);
        }
    }
}
