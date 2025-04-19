package com.example.quizfilmy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class QuizActivity extends AppCompatActivity {

    private int currentQuestion = 0;
    private int score = 0;
    private String question = "What is the name of this movie?";
    private int[] images = {};
    private String[][] options = {};
    private int[] answers = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        String category = getIntent().getStringExtra("category");

        if (category == null || category.isEmpty()) {
            Toast.makeText(this, "Category not selected!", Toast.LENGTH_SHORT).show();
            finish();
        }

        loadCategoryQuestions(category);

        loadQuestion();

        Button option1 = findViewById(R.id.option1);
        Button option2 = findViewById(R.id.option2);
        Button option3 = findViewById(R.id.option3);
        Button option4 = findViewById(R.id.option4);

        // Przypisanie tagów do przycisków
        option1.setTag(0);
        option2.setTag(1);
        option3.setTag(2);
        option4.setTag(3);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOption = Integer.parseInt(v.getTag().toString());
                checkAnswer(selectedOption);
            }
        };

        option1.setOnClickListener(listener);
        option2.setOnClickListener(listener);
        option3.setOnClickListener(listener);
        option4.setOnClickListener(listener);

    }

        private void loadCategoryQuestions(String category) {
            Map<String, CategoryData> categories = new HashMap<>();

            // Fantasy
            categories.put("fantasy", new CategoryData(
                    new int[]{
                            R.drawable.fantasy1, R.drawable.fantasy2, R.drawable.fantasy3,
                            R.drawable.fantasy4, R.drawable.fantasy5, R.drawable.fantasy6,
                            R.drawable.fantasy7, R.drawable.fantasy8, R.drawable.fantasy9, R.drawable.fantasy10
                    },
                    new String[][]{
                            {"Hobbit", "Władca Pierścieni", "Eragon", "Kroniki Shannary"}, // Władca Pierścieni
                            {"Piraci z Północnego Morza", "Wyspa Tajemnic", "Piraci z Karaibów", "Wyspa Skarbów"}, // Piraci z Karaibów
                            {"Harry Potter", "Percy Jackson", "Zwiadowcy", "Baśnie Braci Grimm"}, // Harry Potter
                            {"Czarodziej z Oz", "Gambit", "Niekończąca się Opowieść", "Alicja w krainie czarów"}, // Alicja w krainie czarów
                            {"Czekolada", "Charlie i fabryka czekolady", "Pan Wonka i jego Czekolada", "Kraina Czarów"}, // Charlie i fabryka czekolady
                            {"Cień Anioła", "Joe Black", "Siedem", "Spotkanie z Wiecznością"}, // Joe Black
                            {"Królowa Śniegu", "Władca Bestii", "Opowieści z Narnii", "Kraina Snów"}, // Opowieści z Narnii
                            {"Zmierzch", "Pamiętniki Wampirów", "Wojna Władców", "Krwiożercy"}, // Zmierzch
                            {"Gwiezdne Wojny", "Strażnicy Galaktyki", "Star Trek", "Battlestar Galactica"}, // Gwiezdne Wojny
                            {"Dirty Dancing", "Między Niebem a Ziemią", "Ghost", "Uwierzyć w ducha"}// Uwierzyć w ducha
                    },
                    new int[]{1, 2, 0, 3, 1, 1, 2, 0, 0, 3}
            ));

            categories.put("cartoon", new CategoryData(
                    new int[]{
                            R.drawable.cartoon1, R.drawable.cartoon2, R.drawable.cartoon3,
                            R.drawable.cartoon4, R.drawable.cartoon5, R.drawable.cartoon6,
                            R.drawable.cartoon7, R.drawable.cartoon8, R.drawable.cartoon9, R.drawable.cartoon10
                    },
                    new String[][]{
                            {"Roboty", "Epoka Lodowcowa", "Minionki", "WALL-E"}, // WALL-E
                            {"Mała Księżniczka", "Królewna Śnieżka", "Czarodziej z Oz", "Kopciuszek"}, // Kopciuszek
                            {"Kraina Lodu", "Potwory i spółka", "W głowie się nie mieści", "Ralph Demolka"}, // W głowie się nie mieści
                            {"Zaplątani", "Kraina Lodu", "Tajemnice lasu", "Piękna i Bestia"}, // Zaplątani
                            {"Shrek", "Madagaskar", "Kung Fu Panda", "Epoka Lodowcowa"}, // Shrek
                            {"Coco", "Wielka szóstka", "Megamocny", "Jak wytresować smoka"}, // Wielka szóstka
                            {"Mała Syrenka", "Podwodne życie", "Syrenka Arielka", "Atlantyda: Zaginiony ląd"}, // Syrenka Arielka
                            {"Królowa Śniegu", "Król Lew", "Piękna i Bestia", "Śpiąca królewna"}, // Śpiąca królewna
                            {"Mulan", "Pocahontas", "Herkules", "Księżniczka i żaba"}, // Mulan
                            {"Auta", "Toy Story", "Iniemamocni", "Coco"} // Toy Story
                    },

            new int[]{3, 3, 2, 0, 0, 1, 2, 3, 0, 1}
            ));


            // Comedy
            categories.put("comedy", new CategoryData(
                    new int[]{
                            R.drawable.comedy1, R.drawable.comedy2, R.drawable.comedy3,
                            R.drawable.comedy4, R.drawable.comedy5, R.drawable.comedy6,
                            R.drawable.comedy7, R.drawable.comedy8, R.drawable.comedy9, R.drawable.comedy10
                    },
                    new String[][]{
                            {"Skazani na Shawshank", "Forrest Gump", "Zielona Mila", "Lot nad kukułczym gniazdem"}, // Forrest Gump
                            {"Kac Vegas", "Projekt X", "Superbad", "Wieczór Kawalerski"}, // Kac Vegas
                            {"Rejs", "Chłopaki nie płaczą", "Kiler", "Poranek Kojota"}, // Kiler
                            {"Kevin sam w Nowym Jorku", "Kevin sam w domu", "Grinch: Świąteczny Złodziej", "Elf"}, // Kevin sam w domu
                            {"Czekolada", "To właśnie miłość", "Powiedz tak", "Dziennik Bridget Jones"}, // Dziennik Bridget Jones
                            {"Chłopaki nie płaczą", "Poranek Kojota", "Seksmisja", "Rejs"}, // Chłopaki nie płaczą
                            {"Czekolada", "Holiday", "Listy do M.", "Zakochany bez pamięci"}, // Holiday
                            {"Kill Bill", "Wściekłe psy", "Straszny Film", "Pulp Fiction"}, // Pulp Fiction
                            {"Kłamca, kłamca", "Ace Ventura", "Głupi i Głupszy", "Wieczny student"}, // Głupi i Głupszy
                            {"Asterix i Obelix: Misja Kleopatra", "Asterix na Olimpiadzie", "Asterix i wikingowie", "Asterix i Obelix kontra Cezar"} // Asterix i Obelix
                    },

            new int[]{1, 0, 2, 1, 3, 0, 1, 3, 2, 0}
            ));

            // Drama
            categories.put("drama", new CategoryData(
                    new int[]{
                            R.drawable.drama1, R.drawable.drama2, R.drawable.drama3,
                            R.drawable.drama4, R.drawable.drama5, R.drawable.drama6,
                            R.drawable.drama7, R.drawable.drama8, R.drawable.drama9, R.drawable.drama10
                    },
                    new String[][]{
                            {"Skazani na Shawshank", "Lot nad kukułczym gniazdem", "Requiem dla snu", "Zielona Mila"}, // Zielona Mila
                            {"Chłopiec w pasiastej piżamie", "Mafia", "Ojciec Chrzestny", "Casino"}, // Ojciec Chrzestny
                            {"Lista Schindlera", "Pianista", "Amadeusz", "Czas Apokalipsy"}, // Pianista
                            {"Zapach Kobiety", "Adwokat Diabła", "Rain Man", "Siedem"}, // Zapach Kobiety
                            {"Rzeka miłości", "Pamiętnik", "Gwiezdny pył", "Miłość i inne używki"}, // Pamiętnik
                            {"Narodziny gwiazdy", "Skazany na Bluesa", "Rocketman", "Bohemian Rhapsody"}, // Bohemian Rhapsody
                            {"Człowiek z blizną", "Ojciec Chrzestny II", "Kasyno", "Carlito's Way"}, // Człowiek z blizną
                            {"Rekiny Wojny", "Bękarty Wojny", "Pewnego razu... w Hollywood", "Infiltracja"}, // Pewnego razu... w Hollywood
                            {"Ojciec Chrzestny", "Znachor", "Człowiek z marmuru", "Pianista"}, // Znachor
                            {"Titanic", "Miasto aniołów", "Zatańcz ze mną", "Wyspa miłości"} // Titanic
                    },
                    new int[]{3, 2, 1, 0, 1, 3, 0, 2, 1, 0}
            ));

            // Series
            categories.put("series", new CategoryData(
                    new int[]{
                            R.drawable.series1, R.drawable.series2, R.drawable.series3,
                            R.drawable.series4, R.drawable.series5, R.drawable.series6,
                            R.drawable.series7, R.drawable.series8, R.drawable.series9, R.drawable.series10
                    },
                    new String[][]{
                            {"Wikingowie", "Czarnobyl", "Gra o Tron", "Westworld"}, // Gra o Tron
                            {"Grey's Anatomy", "Dr House", "Chicago Med", "The Good Doctor"}, // Dr House
                            {"Parks and Recreation", "The Office", "Brooklyn Nine-Nine", "Scrubs"}, // The Office
                            {"Narcos", "Fargo", "Ozark", "Breaking Bad"}, // Breaking Bad
                            {"Stranger Things", "Dark", "The Umbrella Academy", "Locke & Key"}, // Stranger Things
                            {"How I Met Your Mother", "Przyjaciele", "Teoria wielkiego podrywu", "Dwóch i pół"}, // Przyjaciele
                            {"Sherlock", "Elementary", "The Mentalist", "Broadchurch"}, // Sherlock
                            {"Gambit Królowej", "Dom z papieru", "El Internado", "Toy Boy"}, // Dom z papieru
                            {"Boardwalk Empire", "Dżentelmeni", "Synowie Anarchii", "Peaky Blinders"}, // Peaky Blinders
                            {"Współczesna Rodzina", "Przyjaciele", "Świat według Bundych", "Różowe lata 70."} // Świat według Bundych
                    },
                    new int[]{2, 1, 1, 3, 0, 1, 0, 1, 3, 2}
            ));

            if (categories.containsKey(category)) {
                CategoryData data = categories.get(category);
                images = data.images;
                options = data.options;
                answers = data.answers;
            } else {
                Toast.makeText(this, "Category not found!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }


    private static class CategoryData {
        int[] images;
        String[][] options;
        int[] answers;

        public CategoryData(int[] images, String[][] options, int[] answers) {
            this.images = images;
            this.options = options;
            this.answers = answers;
        }
    }

    private void loadQuestion() {
        if (currentQuestion < images.length) {
            TextView questionText = findViewById(R.id.questionText);
            ImageView questionImage = findViewById(R.id.questionImage);
            Button option1 = findViewById(R.id.option1);
            Button option2 = findViewById(R.id.option2);
            Button option3 = findViewById(R.id.option3);
            Button option4 = findViewById(R.id.option4);

            questionText.setText(question); // Ustaw to samo pytanie dla każdej kategorii
            questionImage.setImageResource(images[currentQuestion]);
            option1.setText(options[currentQuestion][0]);
            option2.setText(options[currentQuestion][1]);
            option3.setText(options[currentQuestion][2]);
            option4.setText(options[currentQuestion][3]);
        } else {
            endQuiz();
        }
    }

    private void checkAnswer(int selectedOption) {
        if (selectedOption == answers[currentQuestion]) {
            score++;
        }
        currentQuestion++;
        if (currentQuestion < images.length) {
            loadQuestion();
        } else {
            endQuiz();
        }
    }

    private void endQuiz() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }
}
