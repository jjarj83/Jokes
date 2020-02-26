package edu.psu.jjb24.csjokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] joke_title;
    String[] joke_setup;
    String[] joke_punchline;
    int currentJoke = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the action bar
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        joke_title = getResources().getStringArray(R.array.JokeTitle);
        joke_setup = getResources().getStringArray(R.array.JokeSetup);
        joke_punchline = getResources().getStringArray(R.array.JokePunchline);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_joke:
                jokeSetup();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void jokeSetup() {
        String title = joke_title[0];
        String setup = joke_setup[0];

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("content", setup);

        DisplaySetupDialog setupDialog = new DisplaySetupDialog();
        setupDialog.setArguments(args);
        setupDialog.show(getSupportFragmentManager(), "setupDialog");
    }

    public void jokePunchline() {
        String title = joke_title[0];
        String punch = joke_punchline[0];

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("content", punch);

        DisplayPunchlineDialog punchlineDialog = new DisplayPunchlineDialog();
        punchlineDialog.setArguments(args);
        punchlineDialog.show(getSupportFragmentManager(), "punchlineDialog");
    }

    public void onDialogPositiveClick (DialogFragment dialog) {
        jokePunchline();
    }

    public void onDialogNegativeClick (DialogFragment dialog) {
        jokeSetup();
    }


}