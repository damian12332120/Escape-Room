package escapeRoom.PomieszczenieDrugie;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;
import escapeRoom.Uzytkownik;

import java.util.List;

public class KuchennaSzafkaTrzy extends Mebel {
    public KuchennaSzafkaTrzy(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        super(nazwa, przedmioty, uzytkownik);
    }

    @Override
    public void reakcja() {
        opis();
    }

    public void opis() {
        if (!isCzyJuzByl()) {
            System.out.println("Otwierasz szafkę, a w niej kluczyk do Lodowki;)");
            zbierzPrzedmiot();
            setCzyJuzByl(true);
        }else{
            System.out.println("Szafka jest pusta");
        }
    }
}
