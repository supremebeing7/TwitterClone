package com.markjlehman.twitterclone.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.markjlehman.twitterclone.R;

public class RegisterActivity extends ActionBarActivity {

    private EditText mNameEdit;
    private EditText mEmailEdit;
    private Button mSubmitButton;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mNameEdit = (EditText) findViewById(R.id.nameText);
        mEmailEdit = (EditText) findViewById(R.id.emailText);
        mSubmitButton = (Button) findViewById(R.id.registerButton);
        mPreferences = getApplicationContext().getSharedPreferences("twitter", Context.MODE_PRIVATE);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameEdit.getText().toString();
                String email = mEmailEdit.getText().toString();
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putString("name", name);
                editor.putString("email", email);
                editor.commit();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
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
