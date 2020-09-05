package com.example.contactdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private Context context;
    private List<ContactsData> contactsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView display;
        public ImageButton editImage, deleteImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            display = itemView.findViewById(R.id.displayText);
            editImage = itemView.findViewById(R.id.imageEdit);
            deleteImage = itemView.findViewById(R.id.imageDelete);
        }
    }

    public ContactAdapter(Context context, List<ContactsData> contactsList) {
        this.context = context;
        this.contactsList = contactsList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

      /*  holder.display.setText(String.format(Locale.getDefault(), "%s, %s, %s, %s",
                contactsList.get(position).getFirstName(),
                contactsList.get(position).getLastName(),
                contactsList.get(position).getPhoneNumber(),
                contactsList.get(position).getEmail()
        ));
        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });

        holder.deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        String fullName = contactsList.get(position).getFirstName() + " "
                + contactsList.get(position).getLastName() + " "
                + contactsList.get(position).getPhoneNumber() + " "
                + contactsList.get(position).getEmail();

        holder.display.setText(fullName);

    }


    @Override
    public int getItemCount() {
        return contactsList.size();
        ///return contactsList != null ? contactsList.size() : 0;
    }


}
