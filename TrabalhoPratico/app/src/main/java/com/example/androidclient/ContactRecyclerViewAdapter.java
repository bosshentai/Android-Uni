package com.example.androidclient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ContactViewHolder>{

    private Context context;
//    private ArrayList<Contact> mContacList;

    public ContactRecyclerViewAdapter(Context context, ArrayList<Contact> db) {
        this.context = context;
//        this.mContacList = db;

    }

    @NonNull
    @Override
    public ContactRecyclerViewAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (Giving a look to our rows

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.contact_item_recycle_view, parent, false);
        return new ContactRecyclerViewAdapter.ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactRecyclerViewAdapter.ContactViewHolder holder, int position) {
        // assigning values to the views we created in the recycle_view_row layout file
        // base on the position of the recycler view


        holder.contactFullName.setText(Db.contactList.get(position).getFullName());
        holder.contactPhoneNumber.setText(Db.contactList.get(position).getPhoneNumber());
        holder.contactEmail.setText(Db.contactList.get(position).getEmail());
//        holder.position = position;

        if (Db.contactList.get(position).getFav() == true) {
            holder.favoriteIcon.setImageResource(R.drawable.ic_baseline_star_24);
        } else {
            holder.favoriteIcon.setImageResource(R.drawable.ic_baseline_star_border_24);
        }

//        holder.favoriteIcon.setImageResource();
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you want displayed
        return Db.contactList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        // grabbing the views from our contact_item_recycle_view layout file
        // kinda like in the onCreate method

        private ImageView contactIcon;
        private TextView contactFullName, contactPhoneNumber, contactEmail;
        private ImageView favoriteIcon;

//        private int position;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            contactIcon = itemView.findViewById(R.id.contactIcon);
            contactFullName = itemView.findViewById(R.id.contactFullName);
            contactPhoneNumber = itemView.findViewById(R.id.contactNumber);
            contactEmail = itemView.findViewById(R.id.contactEmail);
            favoriteIcon = itemView.findViewById(R.id.contactFavorite);

            itemView.setOnCreateContextMenuListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    int position = getLayoutPosition();

//                    Toast.makeText(context,  "CLick " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    Intent moveToUpdateIntent = new Intent(context,UpdateActivity.class);
                    moveToUpdateIntent.putExtra("userData","" + getLayoutPosition());
                    context.startActivity(moveToUpdateIntent);
                }
            });


        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(0, itemView.getId(), 0, "Call").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    String phoneNumber = "tel:" + Db.contactList.get(getLayoutPosition()).getPhoneNumber();
                    Intent moveToCallIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber));
//                    context.startActivity(moveToCallIntent);

                    if (moveToCallIntent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(moveToCallIntent);
//                        ((Activity) itemView.getContext()).startActivity(moveToCallIntent);
                    } else {
                        Log.d("ImplicitIntents", "Can't handle this");
                    }

                    return false;
                }
            });


            menu.add(0, itemView.getId(), 0, "SMS").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    String number = Db.contactList.get(getLayoutPosition()).getPhoneNumber();
                    Intent moveToSMS = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms",number,null));
                    if(moveToSMS.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(moveToSMS);
                    }else{
                        Log.d("ImplicitIntents","Can't handle this");
                    }
//                    if(moveToSMS.resolveActivity())

                    return false;
                }
            });

            menu.add(0, itemView.getId(), 0, "Favorite").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
//                    Log.d("123",Db.contactList.get(getLayoutPosition()).getFullName());

//                    Db.contactList.get(position)
                    if (Db.contactList.get(getLayoutPosition()).getFav() == true) {
                        Db.contactList.get(getLayoutPosition()).setFav(false);
                        Toast.makeText(itemView.getContext(), "Remove Favorite " + Db.contactList.get(getLayoutPosition()).getFullName(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(itemView.getContext(), "Remove Favorite " + position, Toast.LENGTH_SHORT).show();

                    } else {
                        Db.contactList.get(getLayoutPosition()).setFav(true);
                        Toast.makeText(itemView.getContext(), "Add Favorite " + Db.contactList.get(getLayoutPosition()).getFullName(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(itemView.getContext(), "Add Favorite " + position, Toast.LENGTH_SHORT).show();
                    }
                    return false;
                }
            });

            menu.add(0, itemView.getId(), 0, "Remove").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(itemView.getContext(), "Remove " + Db.contactList.get(getLayoutPosition()).getFullName(), Toast.LENGTH_SHORT).show();
                    Db.contactList.remove(getLayoutPosition());
                    return false;
                }
            });

            menu.add(0, itemView.getId(), 0, "Share").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    String number = Db.contactList.get(getLayoutPosition()).getPhoneNumber();
                    Intent moveToShareIntent = new Intent(Intent.ACTION_SEND);
                    moveToShareIntent.putExtra(Intent.EXTRA_TEXT,number);
                    moveToShareIntent.setType("text/plain");
                    if(moveToShareIntent.resolveActivity(context.getPackageManager())!= null){
                        context.startActivity(moveToShareIntent);
                    }else{
                        Log.d("ImplicitIntentts","Can't handle this");
                    }
                    return false;
                }
            });
        }
    }
}
