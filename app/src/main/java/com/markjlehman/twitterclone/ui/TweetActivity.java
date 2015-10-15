package com.markjlehman.twitterclone.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.markjlehman.twitterclone.R;
import com.markjlehman.twitterclone.models.Tweet;

public class TweetActivity extends Activity {
    public static String TAG = TweetActivity.class.getSimpleName();

    private Tweet mTweet;
    private TextView mTweetContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);

        String tweetId = getIntent().getStringExtra("tweetId");
        mTweet = Tweet.find(Integer.parseInt(tweetId));
        mTweetContent = (TextView) findViewById(R.id.tweetContent);
        mTweetContent.setText(mTweet.getmContent());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tweet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
