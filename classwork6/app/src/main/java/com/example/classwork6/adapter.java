package com.example.classwork6;

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

public class adapter extends RecyclerView.Adapter {

    ArrayList<pokemon> pArray;
    Context c;

    public adapter(ArrayList<pokemon> pArray, Context c) {
        this.pArray = pArray;
        this.c = c;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.stuff,parent,false);
        ViewHolder vh = new ViewHolder (v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ((ViewHolder)holder).img.setImageResource (pArray.get (position).getImage ());
        ((ViewHolder)holder).PokemonName.setText (pArray.get (position).getName ()+"");
        ((ViewHolder)holder).PokemonTotal.setText (pArray.get (position).getTotal ()+"");

        ((ViewHolder)holder).view.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent i = new Intent (c,details.class);

                i.putExtra("pokemon",pArray.get (position));

                c.startActivity (i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return pArray.size ();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img;
        public TextView PokemonName ;
        public TextView PokemonTotal ;
        public View view ;

        public ViewHolder(@NonNull View itemView) {
            super (itemView);
           view = itemView;
           PokemonName = itemView.findViewById(R.id.pokemonNameTag);
           PokemonTotal = itemView.findViewById(R.id.number);
           img = itemView.findViewById(R.id.profile_image);
        }
    }
}
