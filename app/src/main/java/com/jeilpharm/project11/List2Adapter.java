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

public class List2Adapter extends RecyclerView.Adapter<List2Adapter.VH> {

    Context context;
    ArrayList<List2item> list2items;

    public List2Adapter(Context context, ArrayList<List2item> list2items) {
        this.context = context;
        this.list2items = list2items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View list2itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_list2,parent,false);
        return new VH(list2itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        List2item list2item= list2items.get(position);
        holder.num.setText(list2item.tvNum);
        holder.Sigun.setText(list2item.tvSigun);
        holder.name.setText(list2item.tvName);

    }

    @Override
    public int getItemCount() {
        return list2items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView num;
        TextView Sigun;
        TextView name;

        public VH(@NonNull View itemView) {
            super(itemView);
            num=itemView.findViewById(R.id.tv_recycler_list2_num);
            Sigun=itemView.findViewById(R.id.tv_recycler_list2_sigun);
            name=itemView.findViewById(R.id.tv_recycler_list2_name);

        }
    }
}
