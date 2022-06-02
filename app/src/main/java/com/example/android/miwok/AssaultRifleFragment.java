package com.example.android.miwok;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of family vocabulary words.
 */
public class AssaultRifleFragment extends Fragment {



    public AssaultRifleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create and setup the {@link AudioManager} to request audio focus


        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("АК","Автомат Калашникова ", R.drawable.ak47, "8151 Santa Monica Blvd", R.string.ak47,"+1 3236543030"));
        words.add(new Word("Colt Model 920","M4", R.drawable.m4a4, "3455 Overland Ave", R.string.m4," +1 3108366252"));
        words.add(new Word("Le Clairon","FA MAS F1", R.drawable.famas, "5955 Melrose Ave", R.string.famas,"+17346543535"));
        words.add(new Word("Steyr","AUG", R.drawable.aug, "380 Santa Monica Pier Santa Monica CA 90401", R.string.aug,"+13102608744"));
        words.add(new Word("B&T APC-556","APC-300 ", R.drawable.apc, "12743 Ventura Blvd", R.string.apc,"+1 8186238844"));
        words.add(new Word("Colt","ACR", R.drawable.acr, "8715 Melrose Ave", R.string.acr,"+1315764744"));



        WordAdapter adapter = new WordAdapter(getActivity(), words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
        return rootView;
    }
}
