package com.firebaserecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    Context ctx;
    List<NameList> nameLists;

    Adapter(Context ctx, List<NameList> nameLists){
    this.ctx=ctx;
    this.nameLists=nameLists;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(ctx).inflate(R.layout.row,parent,false);
        viewHolder viewHolder=new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
       NameList nameList= nameLists.get(position);

       holder.ist.setText(nameList.getName());
       holder.sec.setText(nameList.getSurname());
    }

    @Override
    public int getItemCount() {
        return nameLists.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView ist,sec;
        public viewHolder(View itemView) {
            super(itemView);

            ist= itemView.findViewById(R.id.ist);
            sec = itemView.findViewById(R.id.snd);
        }
    }
}
