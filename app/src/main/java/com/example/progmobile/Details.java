package com.example.progmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {
    public static Characters perso;
    private ImageView imageStats;
    private String[] phrases;
    public static int compteur;

    public Details(){
        this.phrases = new String[]{"Un combattant redoutable! (ou presque)", "Je ne m'y frotterais pas!",
                "Encore quelqu'un que je n'aimerai pas croiser dans la rue", "Smash = testostérone? Peut-être pas non plus...",
                "Il y en a beaucoup de phrases différentes non?", "Il est temps de se répéter..."};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        imageStats = findViewById(R.id.perso);
        Picasso.get().load(perso.getStatsUrl()).into(imageStats);
        imageStats.setDrawingCacheEnabled(true); //plus d'une heure de recherche pour cette ligne
        Toast.makeText(this, phrases[compteur], Toast.LENGTH_LONG).show();
    }
}