package com.example.portfolioapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {
    private final RVInterface rvInterface;

    Context context;
    ArrayList<ViewModel> viewModels;

    public RVAdapter(Context context, ArrayList<ViewModel> viewModels, RVInterface rvInterface) {
        this.context = context;
        this.viewModels = viewModels;
        this.rvInterface = rvInterface;
    }

    @NonNull
    @Override
    public RVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // This is where you inflate the layout (Giving a look to rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_item, parent, false);
        return new RVAdapter.MyViewHolder(view, rvInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.MyViewHolder holder, int position) {

        // Assigning values to the views we created in the view_item layout file
        // Based on the position of the RecyclerView
        holder.projectLogo.setImageResource(viewModels.get(position).getProjectPic());
        holder.projectName.setText(viewModels.get(position).getProjectName());
        holder.projectDescription.setText(viewModels.get(position).getProjectDescription());
    }

    @Override
    public int getItemCount() {

        // The RecyclerView just wants to know the number of items you want displayed
        return viewModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Grabbing the views from view_item layout file
        // Kinda like in the onCreate method
        ImageView projectLogo;
        TextView projectName, projectDescription;

        public MyViewHolder(@NonNull View itemView, RVInterface rvInterface) {
            super(itemView);

            projectLogo = itemView.findViewById(R.id.cardLogo);
            projectName = itemView.findViewById(R.id.cardTitle);
            projectDescription = itemView.findViewById(R.id.cardDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (rvInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            rvInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
