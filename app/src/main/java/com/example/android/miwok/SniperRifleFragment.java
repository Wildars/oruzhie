package com.example.android.miwok;

import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class SniperRifleFragment extends Fragment {

    @Override
    public View onCreateView( final LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("McMillan", "M-88", R.drawable.mcmillan, "900 W Olympic Blvd", R.string.mcmillan,"+1 213-743-8800"));
        words.add(new Word("Dragunov", "SVD", R.drawable.svd, "9641 Sunset Blvd", R.string.svd,"+1302608744"));
        words.add(new Word("Винторез", "ВСС", R.drawable.vss, "416 W 8th St", R.string.vss,"+1312608744"));
        words.add(new Word("ОРСИС", "Т-5000", R.drawable.t5000, " 9850 Wilshire Blvd", R.string.t5000,"+1310608744"));
        words.add(new Word("Barett", "M-82A1", R.drawable.m82a1, "300 Doheny Dr", R.string.m82a1,"+1 3102732222"));
        words.add(new Word("M-24", "M24-K1", R.drawable.m24, "900 W Olympic Blvd", R.string.m24,"+1 2137658600"));
        words.add(new Word("Armory Viper", "M2000", R.drawable.m2000, "9500 Wilshire Blvd", R.string.m2000,"+1 310260874"));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
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

