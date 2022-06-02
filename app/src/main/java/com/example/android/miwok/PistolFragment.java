package com.example.android.miwok;


import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class PistolFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("M-951", "Beretta", R.drawable.plk,"Disneyland Dr Anaheim CA 92802", R.string.beretta, "+1 7147814636"));
        words.add(new Word("90 two", "Beretta", R.drawable.berettatwo, "4730 Crystal Springs Dr Los Angeles CA 90027 ", R.string.two90,"+1 3239134688"));
        words.add(new Word("STI ", "Tactical", R.drawable.stitactical, "5333 Zoo Dr Los Angeles CA 90027", R.string.STI,"+1 3236444200"));
        words.add(new Word("Coonan", "Coonan Arms", R.drawable.canvas, "380 Santa Monica Pier Santa Monica CA 90401", R.string.Coonan,"+1 3102608744"));
        words.add(new Word("пистолет Лебедева", "ПЛК", R.drawable.plk14, "1238 S Beach Blvd Anaheim, CA 92804", R.string.пистолетЛебедева,"+1 7142369300"));
        words.add(new Word("Пистолет Макарова", "АК", R.drawable.pm, "111 Raging Waters Dr San Dimas CA 91773", R.string.Макарова," +1 9098022200"));
        words.add(new Word("Dan Wesson", "ASG", R.drawable.denwelson, "8039 Beach Blvd Buena Park CA 90620", R.string.ASG,"+1 7142205200"));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file. ListView listView = (ListView) rootView.findViewById(R.id.list);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
        return rootView;
    }
}