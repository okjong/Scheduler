package com.jeilpharm.project11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TodoRecyclerAdapter extends RecyclerView.Adapter<TodoRecyclerAdapter.VH> {

    Context context;
    ArrayList<Item> items;

    public TodoRecyclerAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false);

        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        Item item= items.get(position);

        holder.rcv_tv_hospital.setText(item.hospital);
        holder.rcv_tv_title.setText(item.title);
        holder.rcv_tv_date.setData(item.date);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView rcv_tv_hospital;
        TextView rcv_tv_title;
        Text rcv_tv_date;

        public VH(@NonNull View itemView) {
            super(itemView);

            rcv_tv_hospital=itemView.findViewById(R.id.recyclerview_item_tv_hospital);
            rcv_tv_title=itemView.findViewById(R.id.recyclerview_item_tv_title);
            rcv_tv_date=itemView.findViewById(R.id.recyclerview_item_tv_date);

        }
    }


}
