package com.example.quizfilmy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button fantasyButton = findViewById(R.id.fantasyButton);
        Button cartoonButton = findViewById(R.id.cartoonButton);
        Button comedyButton = findViewById(R.id.comedyButton);
        Button dramaButton = findViewById(R.id.dramaButton);
        Button seriesButton = findViewById(R.id.seriesButton);

                View.OnClickListener listener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(CategoryActivity.this, QuizActivity.class);
                        if (v.getId() == R.id.fantasyButton) {
                            intent.putExtra("category", "fantasy");
                        } else if (v.getId() == R.id.cartoonButton) {
                            intent.putExtra("category", "cartoon");
                        } else if (v.getId() == R.id.comedyButton) {
                            intent.putExtra("category", "comedy");
                        } else if (v.getId() == R.id.dramaButton) {
                            intent.putExtra("category", "drama");
                        } else if (v.getId() == R.id.seriesButton) {
                            intent.putExtra("category", "series");
                        }
                        startActivity(intent);
                    }
                };

                fantasyButton.setOnClickListener(listener);
                cartoonButton.setOnClickListener(listener);
                comedyButton.setOnClickListener(listener);
                dramaButton.setOnClickListener(listener);
                seriesButton.setOnClickListener(listener);


    }
};


