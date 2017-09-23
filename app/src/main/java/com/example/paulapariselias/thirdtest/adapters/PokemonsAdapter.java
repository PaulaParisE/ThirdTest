package com.example.paulapariselias.thirdtest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paulapariselias.thirdtest.R;
import com.example.paulapariselias.thirdtest.data.Nodes;
import com.example.paulapariselias.thirdtest.models.Pokemon;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by paulapariselias on 21-09-17.
 */

public class PokemonsAdapter extends FirebaseRecyclerAdapter<Pokemon, PokemonsAdapter.PokemonsHolder>{

private Context context;

    public PokemonsAdapter(DatabaseReference reference, Context context) {
        super(Pokemon.class, R.layout.list_item_pokemons, PokemonsHolder.class, reference);
        this.context = context;
    }





    @Override
    protected void populateViewHolder(final PokemonsHolder viewHolder, Pokemon model, int position) {
        TextView textView = viewHolder.name;
        textView.setText(model.getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pokemon pokemon = getItem(viewHolder.getAdapterPosition());
                String key = pokemon.getName().replace(" ", "").toLowerCase();
                new Nodes().favorites().child(key).setValue(pokemon);
                Toast.makeText(context, "holi", Toast.LENGTH_SHORT).show();

            }
        });

    }

    static class PokemonsHolder extends RecyclerView.ViewHolder {

        private TextView name;


        public PokemonsHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.pokemonsTv);
        }
    }
}

