package com.example.shonmaker.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shonmaker.R;
import com.example.shonmaker.ui.Player;

import java.util.List;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.ViewHolder> {

    private List<Player> players;
    private Context context;


    public PlayersAdapter(List<Player> players, Context context) {
        this.players = players;
        this.context = context;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_row,parent , false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.numerize.setText(String.valueOf(position + 1));

            holder.playerName.setText(getPlayers().get(position).getName());
            holder.playerPosition.setText(getPlayers().get(position).getPosition());
            holder.playerRating.setText(getPlayers().get(position).getRate());

            holder.playerName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if ( holder.playerName.getText().toString().equals("")){
                        holder.playerName.getBackground().setColorFilter(context.getResources()
                                .getColor(R.color.design_default_color_error), PorterDuff.Mode.SRC_ATOP);
                    }else {
                        holder.playerName.getBackground().setColorFilter(context.getResources()
                                .getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                        players.get(position).setName(charSequence.toString());
                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            holder.playerPosition.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if ( holder.playerPosition.getText().toString().equals("")){
                        holder.playerPosition.getBackground().setColorFilter(context.getResources()
                                .getColor(R.color.design_default_color_error), PorterDuff.Mode.SRC_ATOP);
                    }else {
                        holder.playerPosition.getBackground().setColorFilter(context.getResources()
                                .getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                        //TODO: with photos
//                        players.get(position).set(charSequence.toString());
                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            holder.playerRating.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if ( holder.playerRating.getText().toString().equals("")){
                        holder.playerRating.getBackground().setColorFilter(context.getResources()
                                .getColor(R.color.design_default_color_error), PorterDuff.Mode.SRC_ATOP);
                    }else {
                        holder.playerRating.getBackground().setColorFilter(context.getResources()
                                .getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                        players.get(position).setRate(charSequence.toString());
                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            //animation
            holder.parentLayout.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale));

            //Dialogs init
            final Dialog positionDialog = new Dialog(context);
            positionDialog.setContentView(R.layout.position_dialog);
            Window window = positionDialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }

            final Dialog ratingDialog = new Dialog(context);
            ratingDialog.setContentView(R.layout.rating_dialog);
            Window window2 = ratingDialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }

            holder.playerPosition.setOnFocusChangeListener((view, b) -> {
                if (b){
                    positionDialog.getWindow().getAttributes().windowAnimations = R.style.DialogSlide;
                    positionDialog.show();

                    CircleImageView attack = positionDialog.findViewById(R.id.attack);
                    CircleImageView midd = positionDialog.findViewById(R.id.middlefder);
                    CircleImageView defence = positionDialog.findViewById(R.id.defence);
                    CircleImageView gk = positionDialog.findViewById(R.id.goalkeeper);

                    attack.setOnClickListener(button->{
                        holder.playerPosition.setText(attack.getContentDescription());
                        positionDialog.dismiss();
                    });
                    midd.setOnClickListener(button->{
                        holder.playerPosition.setText(midd.getContentDescription());
                        positionDialog.dismiss();
                    });
                    defence.setOnClickListener(button->{
                        holder.playerPosition.setText(defence.getContentDescription());
                        positionDialog.dismiss();
                    });
                    gk.setOnClickListener(button->{
                        holder.playerPosition.setText(gk.getContentDescription());
                        positionDialog.dismiss();
                    });
                }
            });


            holder.playerRating.setOnFocusChangeListener((view, b) -> {
                if (b){
                    ratingDialog.getWindow().getAttributes().windowAnimations = R.style.DialogSlide;
                    ratingDialog.show();

                    RatingBar ratingBar = ratingDialog.findViewById(R.id.rating_rb);
                    SeekBar seekBar = ratingDialog.findViewById(R.id.rating_sb);
                    TextView textView = ratingDialog.findViewById(R.id.rating_tv);
                    Button button = ratingDialog.findViewById(R.id.rating_finish);

                    ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                        @Override
                        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                            holder.playerRating.setText(String.valueOf(ratingBar.getRating()));
                            ratingDialog.dismiss();
                        }
                    });

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

                    button.setOnClickListener(v->{
                        holder.playerRating.setText(textView.getText());
                        ratingDialog.dismiss();
                    });
                }

            });



    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == players.size()) ? R.layout.button_for_recycler : R.layout.player_row;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private EditText playerName;
        private EditText playerRating;
        private EditText playerPosition;
        private TextView numerize;
        private CardView parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);
            playerRating = itemView.findViewById(R.id.player_rating);
            playerPosition = itemView.findViewById(R.id.player_position);
            numerize = itemView.findViewById(R.id.numerize);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }

        public EditText getPlayerName() {
            return playerName;
        }

        public EditText getPlayerRating() {
            return playerRating;
        }

        public EditText getPlayerPosition() {
            return playerPosition;
        }

        public TextView getNumerize() {
            return numerize;
        }

        public CardView getParentLayout() {
            return parentLayout;
        }
    }


}
