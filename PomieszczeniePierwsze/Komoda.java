package escapeRoom.PomieszczeniePierwsze;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;
import escapeRoom.Uzytkownik;
import escapeRoom.kolkoIKrzyzyk.KolkoiKrzyzyk;

import java.util.List;

public class Komoda extends Mebel {

    public Komoda(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        super(nazwa, przedmioty, uzytkownik);
    }

    @Override
    public void reakcja() {
        opis();
    }

    @Override
    public void opis() {
        if (getScanner().potwierdz("Podchodzisz do komody która ma wyswietlacz. Na niej uruchomiona jest gra Kołko i Krzyżyk." +
                " Chcesz zagrać?")) {
            kolkoIKrzyzyk();
        } else {
            System.out.println("Ok, wróć do niego później");
        }
    }

    public void kolkoIKrzyzyk() {
        if (KolkoiKrzyzyk.menu()) {
            if (!isCzyJuzByl()) {
                System.out.println("Gratulacje, dzięki wygranej dostałeś kolejny zbierzPrzedmiot! Jest to Ameryka Południowa!");
                zbierzPrzedmiot();
                setCzyJuzByl(true);
            } else {
                System.out.println("Udało Ci się po raz kolejny rozwiązać dobrze zadanie, lecz nic wiecej nie dostaniesz;)");
            }
        }
    }
}

