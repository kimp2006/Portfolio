package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RVInterface{

    // Init ArrayList for my projects
    ArrayList<ViewModel> viewModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.projectsView);

        setViewModels();

        RVAdapter adapter = new RVAdapter(this, viewModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Setup ViewModel to ArrayList
    private void setViewModels() {
        String[] projectNames = getResources().getStringArray(R.array.all_projects_names);
        String[] projectDescription = getResources().getStringArray(R.array.all_projects_descriptions);
        int[] projectLogos = {R.drawable.project_notes, R.drawable.project_calculator, R.drawable.project_pingpong, R.drawable.project_portfolio};

        String[] projectGitLink = getResources().getStringArray(R.array.project_github_link);
        String[] projectDate = getResources().getStringArray(R.array.project_creation_date);
        String[] projectStack = getResources().getStringArray(R.array.project_stack);
        String[] projectActivities = getResources().getStringArray(R.array.project_num_activity);

        int[] projectPreviews = {R.drawable.preview_notes, R.drawable.preview_calculator, R.drawable.preview_pingpong, R.drawable.preview_portfolio};

        for (int i = 0; i < projectNames.length; i++) {
            viewModels.add(new ViewModel(projectNames[i], projectDescription[i], projectLogos[i],
                    projectGitLink[i], projectDate[i], projectStack[i], projectActivities[i], projectPreviews[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, ProjectActivity.class);

        intent.putExtra("NAME", viewModels.get(position).getProjectName());
        intent.putExtra("DESCRIPTION", viewModels.get(position).getProjectDescription());
        intent.putExtra("LOGO", viewModels.get(position).getProjectPic());

        intent.putExtra("GIT", viewModels.get(position).getProjectGitLink());
        intent.putExtra("DATE", viewModels.get(position).getProjectDate());
        intent.putExtra("STACK", viewModels.get(position).getProjectStack());
        intent.putExtra("ACTIVITIES", viewModels.get(position).getProjectActivities());

        intent.putExtra("PREVIEW", viewModels.get(position).getProjectPreview());

        startActivity(intent);
    }
}