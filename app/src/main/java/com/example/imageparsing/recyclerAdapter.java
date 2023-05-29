package com.example.imageparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ImageClass> arrayList;

    public recyclerAdapter(Context context, ArrayList<ImageClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public recyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleritem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.ViewHolder holder, int position) {
        ImageClass imageClass = arrayList.get(position);
        Picasso.get().load(imageClass.getUrl()).into(holder.url);
        Picasso.get().load(imageClass.getThumbnailUrl()).into(holder.thumbnailUrl);
        holder.title.setText(imageClass.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView url;
        ImageView thumbnailUrl;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            url = itemView.findViewById(R.id.url);
            thumbnailUrl = itemView.findViewById(R.id.thumbnailUrl);
            title = itemView.findViewById(R.id.title);
        }
    }
}
