package com.example.lab5;

import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private List<String> data;
    public RecyclerViewAdapter(List<String> data) {
        this.data= data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);ViewHolderholder = new ViewHolder(view);return holder;
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setContact(data.get(position));
        holder.bindData();
    }
    @Override
    public int getItemCount() {return data.size();}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private String memo;
        private TextView nameLabel;
        private TextView addressLabel;

        public ViewHolder(View itemView) {
            super(itemView);
        }
        public Contact getContact() {
            return contact;
        }
        public void setContact(Contact contact) {
            this.contact= contact;
        }
        public void bindData() {
            if (nameLabel== null) {nameLabel= (TextView) itemView.findViewById(R.id.contactNameLabel);
            }

            nameLabel.setText(contact.getName());
        }
    }
}
