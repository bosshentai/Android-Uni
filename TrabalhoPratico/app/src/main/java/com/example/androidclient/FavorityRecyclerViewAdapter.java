package com.example.androidclient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavorityRecyclerViewAdapter extends RecyclerView.Adapter<FavorityRecyclerViewAdapter.FavorityViewHolder> {

   private Context context;
   private ArrayList<Contact> favList;
//   private int dbContactPosition;

   public FavorityRecyclerViewAdapter(Context context, ArrayList<Contact> favList){
       this.context = context;
       this.favList = favList;
   }


    @NonNull
    @Override
    public FavorityRecyclerViewAdapter.FavorityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.contact_item_recycle_view,parent,false);
        return new FavorityRecyclerViewAdapter.FavorityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavorityRecyclerViewAdapter.FavorityViewHolder holder, int position) {

//       if(Db.contactList.get(position).getFav() == true){
//           holder.contactFullName.setText(Db.contactList.get(position).getFullName());
//           holder.contactPhoneNumber.setText(Db.contactList.get(position).getPhoneNumber());
//           holder.contactEmail.setText(Db.contactList.get(position).getEmail());
//           holder.favoriteIcon.setImageResource(R.drawable.ic_baseline_star_24);
//       }
        holder.contactFullName.setText(favList.get(position).getFullName());
        holder.contactPhoneNumber.setText(favList.get(position).getPhoneNumber());
        holder.contactEmail.setText(favList.get(position).getEmail());
        holder.favoriteIcon.setImageResource(R.drawable.ic_baseline_star_24);


    }

    @Override
    public int getItemCount() {
        return favList.size();
    }

    public class FavorityViewHolder extends RecyclerView.ViewHolder  {

       private ImageView contactIcon;
       private TextView contactFullName, contactPhoneNumber, contactEmail;
       private ImageView favoriteIcon;


        public FavorityViewHolder(@NonNull View itemView) {
            super(itemView);

            contactIcon = itemView.findViewById(R.id.contactIcon);
            contactFullName = itemView.findViewById(R.id.contactFullName);
            contactPhoneNumber = itemView.findViewById(R.id.contactNumber);
            contactEmail = itemView.findViewById(R.id.contactEmail);
            favoriteIcon = itemView.findViewById(R.id.contactFavorite);


//            itemView.setOnCreateContextMenuListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent moveToUpdateIntent = new Intent(context,UpdateActivity.class);
//                    int positon = 0;

//                    for(int i= 0; i< Db.contactList.size();i++){
//
//                    }

                    moveToUpdateIntent.putExtra("userData", ""+ favList.get(getLayoutPosition()).getId());
                    context.startActivity(moveToUpdateIntent);
                }
            });




        }
    }
}
