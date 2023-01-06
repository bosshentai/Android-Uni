package com.example.androidclient;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavorityRecyclerViewAdapter extends RecyclerView.Adapter<FavorityRecyclerViewAdapter.FavorityViewHolder> {

   private Context context;

   public FavorityRecyclerViewAdapter(Context context){
       this.context = context;
   }


    @NonNull
    @Override
    public FavorityRecyclerViewAdapter.FavorityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FavorityRecyclerViewAdapter.FavorityViewHolder holder, int position) {

       if(Db.contactList.get(position).getFav() == true){
           holder.contactFullName.setText(Db.contactList.get(position).getFullName());
           holder.contactPhoneNumber.setText(Db.contactList.get(position).getPhoneNumber());
           holder
       }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FavorityViewHolder extends RecyclerView.ViewHolder {

       private ImageView contactIcon;
       private TextView contactFullName, contactPhoneNumber, contactEmail;
       private ImageView favoriteIcon;


        public FavorityViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
