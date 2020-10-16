package com.bianhailena.project1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cards#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cards extends Fragment {
    public Cards() { }

    ImageButton but;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int totcount = 0, oppCount;
    ImageView c1, c2;
    TextView status, wins, total, opp;
    Button startOver, stand;
    boolean inGame = true, s = true;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = this.getActivity().getSharedPreferences("Values", Context.MODE_PRIVATE);
        but = view.findViewById(R.id.imageButton);
        c1 = view.findViewById(R.id.but1);
        c2 = view.findViewById(R.id.but2);
        editor = sharedPreferences.edit();
        status = view.findViewById(R.id.status);
        startOver = view.findViewById(R.id.startover);
        wins = view.findViewById(R.id.wins);
        total = view.findViewById(R.id.total);
        opp = view.findViewById(R.id.opponent);
        status = view.findViewById(R.id.status);
        startOver = view.findViewById(R.id.startover);
        stand = view.findViewById(R.id.stand);
        startOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startOver();
            }
        });
        setCards();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inGame) {
                    int count = (int) (Math.random() * 12 + 1);
                    switch (count) {
                        case 1:
                            but.setImageResource(R.drawable.card1);
                            totcount += 11;
                            if (totcount > 21)
                                totcount -= 10;
                            break;
                        case 2:
                            but.setImageResource(R.drawable.card2);
                            totcount += 2;
                            break;
                        case 3:
                            but.setImageResource(R.drawable.card3);
                            totcount += 3;
                            break;
                        case 4:
                            but.setImageResource(R.drawable.card4);
                            totcount += 4;
                            break;
                        case 5:
                            but.setImageResource(R.drawable.card5);
                            totcount += 5;
                            break;
                        case 6:
                            but.setImageResource(R.drawable.card6);
                            totcount += 6;
                            break;
                        case 7:
                            but.setImageResource(R.drawable.card7);
                            totcount += 7;
                            break;
                        case 8:
                            but.setImageResource(R.drawable.card8);
                            totcount += 8;
                            break;
                        case 9:
                            but.setImageResource(R.drawable.card9);
                            totcount += 9;
                            break;
                        case 10:
                            but.setImageResource(R.drawable.card10);
                            totcount += 10;
                            break;
                        case 11:
                            but.setImageResource(R.drawable.card11);
                            totcount += 10;
                            break;
                        case 12:
                            but.setImageResource(R.drawable.card12);
                            totcount += 10;
                            break;
                        default:
                            but.setImageResource(R.drawable.card13);
                            totcount += 10;
                            break;
                    }
                    setValues();
                }
            }
        });

        stand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s) {
                    inGame = false;
                    setValues();
                    s = false;
                }
            }
        });

    }
    public void startOver(){
        inGame = true;
        s = true;
        status.setText("");
        setCards();
    }
    public void setValues(){
        if(totcount == 21 || ((totcount > oppCount) && !inGame)) {
            editor.putInt("wins", sharedPreferences.getInt("wins", 0) + 1);
            editor.apply();
            s = false;
            status.setTextColor(Color.BLUE);
            status.setText("You win!");
            inGame = false;
        }
        else if((oppCount == totcount) && !inGame){
            status.setTextColor(Color.BLUE);
            status.setText("Tie");
            s = false;
            inGame = false;
        }
        else if(totcount > 21 || !inGame){
            status.setTextColor(Color.RED);
            status.setText("You lose!");
            s = false;
            inGame = false;
        }
        total.setText("Total: " + totcount);
        wins.setText("Wins: " + sharedPreferences.getInt("wins", 0));
    }
    public void setCards(){
        totcount = 0;
        status.setText("");
        int count = (int)(Math.random() * 12 + 1);
        but.setImageResource(R.drawable.back);
        oppCount = (int)(Math.random() * 4 + 17);
        opp.setText("Opponent: " + oppCount);
        if(oppCount == 21)
            inGame = false;
        else {
            switch (count) {
                case 1:
                    c1.setImageResource(R.drawable.card1);
                    totcount += 11;
                    if (totcount > 21)
                        totcount -= 10;
                    break;
                case 2:
                    c1.setImageResource(R.drawable.card2);
                    totcount += 2;
                    break;
                case 3:
                    c1.setImageResource(R.drawable.card3);
                    totcount += 3;
                    break;
                case 4:
                    c1.setImageResource(R.drawable.card4);
                    totcount += 4;
                    break;
                case 5:
                    c1.setImageResource(R.drawable.card5);
                    totcount += 5;
                    break;
                case 6:
                    c1.setImageResource(R.drawable.card6);
                    totcount += 6;
                    break;
                case 7:
                    c1.setImageResource(R.drawable.card7);
                    totcount += 7;
                    break;
                case 8:
                    c1.setImageResource(R.drawable.card8);
                    totcount += 8;
                    break;
                case 9:
                    c1.setImageResource(R.drawable.card9);
                    totcount += 9;
                    break;
                case 10:
                    c1.setImageResource(R.drawable.card10);
                    totcount += 10;
                    break;
                case 11:
                    c1.setImageResource(R.drawable.card11);
                    totcount += 10;
                    break;
                case 12:
                    c1.setImageResource(R.drawable.card12);
                    totcount += 10;
                    break;
                default:
                    c1.setImageResource(R.drawable.card13);
                    totcount += 10;
                    break;
            }
            int count2 = (int) (Math.random() * 12 + 1);
            switch (count2) {
                case 1:
                    c2.setImageResource(R.drawable.card1);
                    totcount += 11;
                    if (totcount > 21)
                        totcount -= 10;
                    break;
                case 2:
                    c2.setImageResource(R.drawable.card2);
                    totcount += 2;
                    break;
                case 3:
                    c2.setImageResource(R.drawable.card3);
                    totcount += 3;
                    break;
                case 4:
                    c2.setImageResource(R.drawable.card4);
                    totcount += 4;
                    break;
                case 5:
                    c2.setImageResource(R.drawable.card5);
                    totcount += 5;
                    break;
                case 6:
                    c2.setImageResource(R.drawable.card6);
                    totcount += 6;
                    break;
                case 7:
                    c2.setImageResource(R.drawable.card7);
                    totcount += 7;
                    break;
                case 8:
                    c2.setImageResource(R.drawable.card8);
                    totcount += 8;
                    break;
                case 9:
                    c2.setImageResource(R.drawable.card9);
                    totcount += 9;
                    break;
                case 10:
                    c2.setImageResource(R.drawable.card10);
                    totcount += 10;
                    break;
                case 11:
                    c2.setImageResource(R.drawable.card11);
                    totcount += 10;
                    break;
                case 12:
                    c2.setImageResource(R.drawable.card12);
                    totcount += 10;
                    break;
                default:
                    c2.setImageResource(R.drawable.card13);
                    totcount += 10;
                    break;
            }
        }
        setValues();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cards, container, false);
    }
}