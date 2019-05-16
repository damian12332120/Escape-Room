package escapeRoom.PomieszczeniePierwsze;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;
import escapeRoom.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

public class EkranDotykowy extends Mebel {

    public EkranDotykowy(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        super(nazwa, przedmioty, uzytkownik);
    }

    @Override
    public void reakcja() {
        opis();
        odpowiedzi(pytania());
    }

    @Override
    public void opis() {
        System.out.println("Podchodzisz do komody która ma wyswietlacz. Na ekranie wyswietlają się pytania, odpowiedz na nie.");
    }

    public int pytania() {
        List<String> pytania = new ArrayList<>();
        pytania.add("Czy stolicą Hiszpani jest Madryt?");
        pytania.add("Czy w Polsce jest wiecej kobiet niż mężczyzn?");
        pytania.add("Czy koloratka jest koloru białego?");
        pytania.add("Czy Watykan jest krajem");
        boolean czyDobrze;
        int licznik = 0;
        for (String pytanie : pytania) {
            czyDobrze = getScanner().potwierdz(pytanie);
            if (czyDobrze) {
                licznik++;
            }
        }
        return licznik;
    }

    public void odpowiedzi(int licznik) {
        System.out.println("licznik" + licznik);
        if (!isCzyJuzByl()) {
            if (licznik == 4) {
                System.out.println("Gratulacje odpowiedziałeś na wszystkie pytania poprawnie. Zauważasz, ze skrytka zostaje otwarta," +
                        "a w niej Ameryka Północna!");
                setCzyJuzByl(true);
                zbierzPrzedmiot();
            } else {
                if (getScanner().potwierdz("Niestety nie na wszystkie pytania odpowiedziałeś poprawnie, czy chcesz spróbować " +
                        "jeszcze raz?")) {
                    odpowiedzi(pytania());
                }
            }
        } else {
            System.out.println("Udało Ci się po raz kolejny rozwiązać dobrze zadanie, lecz nic wiecej nie dostaniesz;)");
        }
    }


}
