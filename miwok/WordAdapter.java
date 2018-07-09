package com.example.android.miwok;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;

/**
 * Created by mats on 02/03/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceID;

    public WordAdapter(Activity context, ArrayList<Word> words, int backColorID ) {
        super(context,0,words);
        mColorResourceID = backColorID;
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
     //   return super.getView(position, convertView, parent);

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        LinearLayout parentLayoutForText = (LinearLayout) listItemView.findViewById(R.id.parentTextLayout);
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        parentLayoutForText.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultLanguageTextView = (TextView) listItemView.findViewById(R.id.english_text);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultLanguageTextView.setText(currentWord.getDefaultTranslation());


//        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
//        // Get the image resource ID from the current AndroidFlavor object and
        if(currentWord.hasImage()) {
//        // set the image to iconView
            iconView.setImageResource(currentWord.getImageResourceID());
            iconView.setVisibility(View.VISIBLE);
        }
        else {
            iconView.setVisibility(View.GONE);
        }


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
