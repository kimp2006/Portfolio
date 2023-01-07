package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int logo = getIntent().getIntExtra("LOGO",0);

        String git = getIntent().getStringExtra("GIT");
        String date = getIntent().getStringExtra("DATE");
        String stack = getIntent().getStringExtra("STACK");
        String activities = getIntent().getStringExtra("ACTIVITIES");

        int preview = getIntent().getIntExtra("PREVIEW",0);


        TextView nameTV = findViewById(R.id.projectTitle);
        TextView descriptionTV = findViewById(R.id.projectDescription);
        ImageView logoIV = findViewById(R.id.projectLogo);

        TextView gitTV = findViewById(R.id.gitText);
        TextView dateTV = findViewById(R.id.dateText);
        TextView stackTV = findViewById(R.id.stackText);
        TextView activitiesTV = findViewById(R.id.activitiesText);

        ImageView previewIV = findViewById(R.id.projectPreview);


        nameTV.setText(name);
        descriptionTV.setText(description);
        logoIV.setImageResource(logo);

        gitTV.setText(git);
        dateTV.setText(date);
        stackTV.setText(stack);
        activitiesTV.setText(activities);

        previewIV.setImageResource(preview);
    }
}