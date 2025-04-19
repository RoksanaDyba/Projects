# Opis projektu -  APLIKACJA Z QUIZEM FILMOWYM 

Platforma: Android (Java)


## Opis funkcjonalności:
Aplikacja umożliwia użytkownikowi rozwiązanie quizu dotyczącego znajomości filmów i seriali. Rozgrywka polega na rozpoznawaniu tytułów filmów na podstawie obrazów i wybieraniu poprawnej odpowiedzi z czterech dostępnych opcji.


## Przebieg działania aplikacji:

### Ekran główny (MainActivity):
Zawiera przycisk „Start”, który przenosi użytkownika do wyboru kategorii.

### Wybór kategorii (CategoryActivity):
Użytkownik wybiera jedną z pięciu kategorii:
- Fantasy
- Bajki
- Komedia
- Dramat
- Seriale

Po wybraniu kategorii uruchamiany jest quiz.

### Quiz (QuizActivity):

Dla danej kategorii ładowane są zdjęcia filmowe (jako pytania) oraz cztery możliwe odpowiedzi (tytuły filmów).
Użytkownik odpowiada na 10 pytań, a za każdą poprawną odpowiedź przyznawany jest punkt.
Po zakończeniu quizu wynik jest przekazywany do ekranu wyników.

### Wynik (ResultActivity):
Wyświetla liczbę zdobytych punktów.
Istnieje możliwość rozpoczęcia quizu od nowa.


## Technologie użyte w projekcie:
Język programowania: Java
Framework: Android SDK
Interfejs użytkownika: Android XML Layouts
Mechanizm przekazywania danych: Intent z putExtra i getStringExtra
