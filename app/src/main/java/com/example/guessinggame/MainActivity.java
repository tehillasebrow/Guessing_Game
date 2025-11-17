package com.example.guessinggame;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import com.example.guessinggame.databinding.ActivityMainBinding;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private GuessingGame mGame;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // This is now safe because mGame is always initialized in onCreate
        outState.putString("GAME", mGame.getJSONStringFromThis());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);


        if (savedInstanceState != null) {
            mGame = GuessingGame.getGuessingGameObjectFromJSONString(savedInstanceState.getString("GAME"));
        } else {
            mGame = new GuessingGame();
        }
        binding.fab.setOnClickListener(view -> {
            mGame.startNewGame();
            Snackbar.make(view, "New game started! The winning number has been reset.", Snackbar.LENGTH_LONG).show();
        });


        setupButtonListeners();
        binding.fab.setOnClickListener(view -> {
            mGame.startNewGame();
            Snackbar.make(view, "New game started! The winning number has been reset.", Snackbar.LENGTH_LONG).show();
        });
    }

    private void setupButtonListeners() {

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this::handleGuess);
        button2.setOnClickListener(this::handleGuess);
        button3.setOnClickListener(this::handleGuess);
    }

    public void handleGuess(View view) {
        Button currentButton = (Button) view;
        String currentButtonText = currentButton.getText().toString();


        if (mGame == null) return;

        String resultsText = currentButtonText.equals(String.valueOf(mGame.getWinningNumber()))
                ? String.format(Locale.US, "Yes! %s is the right number.", currentButtonText)
                : String.format(Locale.US, "Sorry. %s is not the right number.", currentButtonText);

        Snackbar.make(view, resultsText, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
