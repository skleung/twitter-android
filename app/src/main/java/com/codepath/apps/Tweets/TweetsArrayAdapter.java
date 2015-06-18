package com.codepath.apps.Tweets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.Tweets.models.Tweet;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sleung on 6/13/15.
 */
// Taking tweet objects and turning them into views
public class TweetsArrayAdapter extends ArrayAdapter<Tweet>{


     public TweetsArrayAdapter(Context context, List<Tweet> tweets) {
        super(context, android.R.layout.simple_list_item_1, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tweet tweet = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tweet_view, parent, false);
        }
        ImageView profilePic = (ImageView) convertView.findViewById(R.id.ivProfile);
        TextView username = (TextView) convertView.findViewById(R.id.tvHandle);
        TextView body = (TextView) convertView.findViewById(R.id.tvBody);
        username.setText(tweet.getUser().getScreenName());
        body.setText(tweet.getBody());
        profilePic.setImageResource(android.R.color.transparent); //clears out old image
        String url = tweet.getUser().getProfileImageUrl();
        Picasso.with(getContext()).load(url);
        return convertView;
    }
}
