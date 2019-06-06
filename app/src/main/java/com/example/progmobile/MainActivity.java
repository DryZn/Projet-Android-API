package com.example.progmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView liste_persos;
    private RecyclerView.Adapter adaptateur;
    private RecyclerView.LayoutManager layoutManager;
    private ControllerAPI reponse;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reponse  = new ControllerAPI(this);
        reponse.start();
    }

    protected void initRecycler(List<Characters> changesList){
        liste_persos = findViewById(R.id.liste_persos);
        liste_persos.setHasFixedSize(true);
        //layoutManager = new GridLayoutManager(this, 4);
        layoutManager = new LinearLayoutManager(this);
        liste_persos.setLayoutManager(layoutManager);
        adaptateur = new PersoAdapter(changesList);
        liste_persos.setAdapter(adaptateur);
    }

    protected void showDetails(View v){
        textView = v.findViewById(R.id.textt);
        textView.setText("ok");
        Intent intent = new Intent(this, Details.class);
        startActivity(intent);
    }
}