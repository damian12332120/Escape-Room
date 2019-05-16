package escapeRoom.PomieszczenieDrugie;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;
import escapeRoom.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

public class Lodowka extends Mebel {
    public Lodowka(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        super(nazwa, przedmioty, uzytkownik);
    }

    @Override
    public void reakcja() {
        opis();
    }

    @Override
    public void opis() {
        boolean czyMaKlucz = false;
        List<Przedmiot> klucz = new ArrayList<>();
        if (!isCzyJuzByl()) {
            if (getScanner().potwierdz("Podchodzisz do lodówki, jest zabezpieczona kłódką. Posiadasz do niej klucz?")) {
                for (Przedmiot przedmiot : getUzytkownik().getZebraneArtykuły()) {
                    if (przedmiot.getNazwa().equals("Klucz lodowka")) {
                        System.out.println("Szafka została otwarta,a w niej nowy kontynent Antarktyda!!!");
                        klucz.add(przedmiot);
                        czyMaKlucz = true;
                        setCzyJuzByl(true);
                    }
                }
            }
            if (!czyMaKlucz) {
                System.out.println("Nie posiadasz klucza, lub twój klucz nie pasuje do tego zamka.");
            } else {
                zbierzPrzedmiot();
            }
            getUzytkownik().getZebraneArtykuły().removeAll(klucz);
        } else {
            System.out.println("W szafce nie ma niczego nowego;)");
        }
    }

}
