package com.example.shonmaker.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shonmaker.R;
import com.example.shonmaker.ui.Player;

import java.util.ArrayList;
import java.util.List;


public class PlayersFragment extends Fragment {

    private List<Player> playerList;
    private String name ;
    private ArrayList<String> names = new ArrayList<>();
    private String position;
    private ArrayList<String> positions = new ArrayList<>();
    private String rating;
    private ArrayList<String> ratings = new ArrayList<>();

    public PlayersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_players, container, false);


        //set the adapter
        Bundle bundle = this.getArguments();
        int data = bundle.getInt("players_size");

        playerList = new ArrayList<>();
        for (int i = 0; i < data; i++) {
            playerList.add(new Player(""));
        }

        RecyclerView recyclerView = root.findViewById(R.id.player_rv);
        PlayersAdapter playersAdapter = new PlayersAdapter(playerList,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(playersAdapter);




        Button next = root.findViewById(R.id.btn_next);
        next.setOnClickListener(v->{


            for(int i=0; i< playersAdapter.getItemCount();i++){
                PlayersAdapter.ViewHolder viewHolder= (PlayersAdapter.ViewHolder)
                        recyclerView.findViewHolderForAdapterPosition(i);
                assert viewHolder != null;
                name = viewHolder.getPlayerName().getText().toString();
                names.add(name);
                position = viewHolder.getPlayerPosition().getText().toString();
                positions.add(position);
                rating = viewHolder.getPlayerRating().getText().toString();
                ratings.add(rating);
            }

//            if (!name.equals("") && !position.equals("") && !rating.equals("")){

            FinalFragment fragment = new FinalFragment();
            for (int i = 0; i < playersAdapter.getItemCount(); i++) {
                bundle.putStringArrayList("player_names",names);
                bundle.putStringArrayList("player_ratings",ratings);
                bundle.putStringArrayList("player_positions",positions);

            }

            bundle.putInt("size", playersAdapter.getItemCount());

            fragment.setArguments(bundle);

                requireActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_right_to_left)
                        .replace(R.id.player_container, fragment).addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
//            }else{
//                Toast.makeText(getContext(), "Empty!", Toast.LENGTH_SHORT).show();
//            }
        });



        return root;
    }
}