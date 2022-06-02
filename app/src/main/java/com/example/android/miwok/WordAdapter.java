package com.example.android.miwok;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>{
    static ImageView image;


    public WordAdapter(Context context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item2, parent, false);
        }
        Button rootView=listItemView.findViewById(R.id.press);
        // Get the {@link AndroidFlavor} object located at this position in the list
        final Word currentWord = getItem(position);


        TextView miwokTextView =listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView =listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView image = listItemView.findViewById(R.id.image);
        Glide.with(getContext()).load(currentWord.getImageResourceId()).into(image);

        TextView number = listItemView.findViewById(R.id.number);
        number.setText(currentWord.getNumber());

        TextView texts = listItemView.findViewById(R.id.texts);
        texts.setText(currentWord.getSomeInfo());

        TextView textaddress = listItemView.findViewById(R.id.textaddress);
        textaddress.setText(currentWord.getShowAddress());

        final TextView numberCall = listItemView.findViewById(R.id.number);
        TextView root = listItemView.findViewById(R.id.textaddress);
        // View textContainer=listItemView.findViewById(R.id.text_container);
        final RelativeLayout desc = listItemView.findViewById(R.id.linear);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (desc.getVisibility() == View.VISIBLE) {
                    desc.setVisibility(View.GONE);
                } else {
                    desc.setVisibility(View.VISIBLE);
                }
            }
        });
        numberCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = numberCall.getText().toString();
                if (!TextUtils.isEmpty((phoneNo))) {
                    String dial = "tel:" + phoneNo;
                    getContext().startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }

            }
        });
        root.setText(currentWord.getShowAddress());
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intentmap = new Intent(Intent.ACTION_VIEW);
                Intentmap.setData(Uri.parse("geo:0,0?q=" + currentWord.getShowAddress()));
                getContext().startActivity(Intentmap);
            }
        });

        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;
    }


}
