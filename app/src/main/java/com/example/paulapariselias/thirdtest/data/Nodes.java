package com.example.paulapariselias.thirdtest.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by paulapariselias on 21-09-17.
 */

public class Nodes {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    public DatabaseReference pokemons (){
        return root.child("pokemons");
    }

    public DatabaseReference favorites () {
        return root.child("favorites").child(new CurrentUser().getCurrentUser().getUid());
    }
}
