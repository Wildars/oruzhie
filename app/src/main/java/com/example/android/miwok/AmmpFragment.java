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
 * {@link Fragment} that displays a list of color vocabulary words.
 */
public class AmmpFragment extends Fragment {



    public AmmpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("М2 ANA Tactical", "<Бронежилет>", R.drawable.bronijilet, "100 Universal City Plaza", R.string.bronijilet,"+1 7865623452"));
        words.add(new Word("Phoenix RME", "Plate Carrier 6094-PH", R.drawable.broni, "2800 E Observatory Rd", R.string.broni,"+1 9483254876"));
        words.add(new Word("АО ФНПЦ", "Заря-3", R.drawable.zarya, "5905 Wilshire Blvd", R.string.zarya,"+1 9375726545"));
        words.add(new Word("Mk 2A1", "Mk II", R.drawable.mk2, "111 S Grand Ave", R.string.mk2,"+1 8746238454"));
        words.add(new Word("Вишня", "НР-43", R.drawable.nr40, "900 W Exposition Blvd", R.string.nr40,"+1 9236754675"));
        words.add(new Word("ЦКИБ", "ОЦ-04", R.drawable.knife, "6060 Wilshire Blvd", R.string.knife,"+1 9234675858"));

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