package com.example.shonmaker.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.shonmaker.R;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    private CircleImageView stoper;
    private CircleImageView createGroups;
    private CircleImageView myPlayers;
    private TextView welcome;

    public HomeFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        stoper = root.findViewById(R.id.stoper_iv);
        createGroups = root.findViewById(R.id.create_teams_iv);
        myPlayers = root.findViewById(R.id.my_players_iv);
        welcome = root.findViewById(R.id.welcome);

        //title animatye
        YoYo.with(Techniques.Landing)
                .duration(3000)
                .playOn(welcome);

        //onclicklisteners
        createGroups.setOnClickListener(v->{
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_left_to_right,
                            R.anim.enter_left_to_right,R.anim.exit_right_to_left).
                    replace(R.id.test, new GroupsFragment()).addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();

        });

        return root;
    }
}