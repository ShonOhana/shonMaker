package com.example.shonmaker.ui.home;

import android.app.Activity;
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
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.shonmaker.R;
import com.example.shonmaker.ui.Player;

import java.util.ArrayList;
import java.util.List;

public class GroupsFragment extends Fragment {

    private TextView playersNum;
    private TextView teamsNum;
    private SeekBar playerSeekBar;
    private SeekBar teamSeekBar;
    private Switch playerLevelSwitch;
    private Switch playerPositionSwitch;
    private Button nextBtn;
    private Bundle bundle;

    public GroupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_groups, container, false);



        //find view by id
        playersNum = root.findViewById(R.id.number);
        teamsNum = root.findViewById(R.id.number2);
        playerSeekBar = root.findViewById(R.id.seekBar);
        teamSeekBar = root.findViewById(R.id.seekBar2);
        playerLevelSwitch = root.findViewById(R.id.switch1);
        playerPositionSwitch = root.findViewById(R.id.switch2);
        nextBtn = root.findViewById(R.id.btn_next);

        //relate the seek bar to the text view
        teamSeekBar.setMax(playerSeekBar.getMax()/2);
        changeNumBySeekBar(playerSeekBar,playersNum);
        changeNumBySeekBar(teamSeekBar,teamsNum);

        //TEAMS TEXTVIEW


        //switch
        playerLevelSwitch.setChecked(true);
        playerPositionSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        //setonclicklisteners
        nextBtn.setOnClickListener(b->{

            bundle = new Bundle();
            bundle.putInt("players_size", Integer.parseInt(playersNum.getText().toString()));

            PlayersFragment playersFragment = new PlayersFragment();
            playersFragment.setArguments(bundle);


            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_right_to_left)
                    .replace(R.id.group_container, playersFragment).addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();


        });

        return root;
    }

    private void changeNumBySeekBar(SeekBar seekBar, TextView textView){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBar.setProgress(i);
                textView.setText(String.valueOf(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}