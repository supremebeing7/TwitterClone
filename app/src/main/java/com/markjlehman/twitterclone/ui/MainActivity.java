package com.markjlehman.twitterclone.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.markjlehman.twitterclone.R;
import com.markjlehman.twitterclone.models.Tweet;
import com.markjlehman.twitterclone.models.User;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private SharedPreferences mPreferences;
    private User mUser;
    private EditText mTweetText;
    private Button mSubmitButton;
    private ArrayList<Tweet> mTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getApplicationContext().getSharedPreferences("twitter", Context.MODE_PRIVATE);

        if (!isRegistered()) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        } else {
            mTweetText = (EditText) findViewById(R.id.newTweetEdit);
            mSubmitButton = (Button) findViewById(R.id.tweetSubmitButton);
            mTweets = (ArrayList) Tweet.all();

            mSubmitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    createTweet();
                }
            });
        }
    }

    private void createTweet() {
        String content = mTweetText.getText().toString();
        Tweet newTweet = new Tweet(mUser, content);
        newTweet.save();
        mTweets.add(newTweet);
        mTweetText.setText("");
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

    }

    private boolean isRegistered() {
        String name = mPreferences.getString("name", null);
        String email = mPreferences.getString("email", null);
        if (email != null) {
            setUser(name, email);
            return true;
        } else {
            return false;
        }
    }

    private void setUser(String name, String email) {
        User user = User.findByEmail(email);
        if (user != null) {
            mUser = user;
        } else {
            mUser = new User(name, email);
            mUser.save();
        }
        Toast.makeText(this, "Welcome " + mUser.getmName(), Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
