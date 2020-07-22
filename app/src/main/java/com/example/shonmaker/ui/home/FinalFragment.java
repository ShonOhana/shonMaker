package com.example.shonmaker.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shonmaker.R;
import com.example.shonmaker.ui.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class FinalFragment extends Fragment {

    public FinalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View root = inflater.inflate(R.layout.fragment_final, container, false);

       Bundle bundle = getArguments();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> positions = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();

        assert bundle != null;
        int size = bundle.getInt("size");

        names = bundle.getStringArrayList("player_names");

        System.out.println("name " + names);
        positions = bundle.getStringArrayList("player_positions");

        System.out.println("player " + players);

        for (int i = 0; i < size ; i++) {

            players.add(new Player(names.get(i)));

        }




        List<Player> teamA = new ArrayList<>();
        List<Player> teamB = new ArrayList<>();

        for (int i = 0; i < players.size() / 2; i++) {
            teamA.add(players.get(i));
        }

        for (int i = players.size() / 2; i < players.size(); i++) {
            teamB.add(players.get(i));
        }


        RecyclerView recyclerView = root.findViewById(R.id.rv_team1);
        GroupAdapter groupAdapter = new GroupAdapter(teamA,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(groupAdapter);



        RecyclerView recyclerView2 = root.findViewById(R.id.rv_team2);
        GroupAdapter groupAdapter2 = new GroupAdapter(teamB,getContext());
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView2.setAdapter(groupAdapter2);



       return root;
    }
}