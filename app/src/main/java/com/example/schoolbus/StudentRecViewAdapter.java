package com.example.schoolbus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StudentRecViewAdapter extends RecyclerView.Adapter<StudentRecViewAdapter.ViewHolder> {

    private ArrayList<StudentModel> studentModels = new ArrayList<>();

    private Context context;

    public StudentRecViewAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.txtName.setText(studentModels.get(position).getStu_firstname());
    }

    @Override
    public int getItemCount() {
        return studentModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}
