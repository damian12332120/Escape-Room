package escapeRoom.PomieszczenieDrugie;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;
import escapeRoom.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

public class KuchennaSzafkaDwa extends Mebel {
    public KuchennaSzafkaDwa(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        super(nazwa, przedmioty, uzytkownik);
    }


    @Override
    public void reakcja() {
        opis();
    }

    public void opis() {
        boolean czyMaKlucz = false;
        List<Przedmiot> klucz = new ArrayList<>();
        if (!isCzyJuzByl()) {
            if (getScanner().potwierdz("Szafka posiada zamek, czy masz do niego klucz?")) {
                for (Przedmiot przedmiot : getUzytkownik().getZebraneArtykuły()) {
                    if (przedmiot.getNazwa().equals("Klucz")) {
                        System.out.println("Szafka została otwarta");
                        klucz.add(przedmiot);
                        czyMaKlucz = true;
                        setCzyJuzByl(true);
                    }
                }
            }
            if (!czyMaKlucz) {
                System.out.println("Nie posiadasz klucza, lub twój klucz nie pasuje do tego zamka.");
            } else {
                garnki();
            }
            getUzytkownik().getZebraneArtykuły().removeAll(klucz);
        } else {
            System.out.println("W szafce nie ma niczego nowego;)");
        }
    }

    public void garnki() {
        if (getScanner().potwierdz("Widzisz mnóstwo garnków i innych urządzeń kuchennych, czy chcesz je obejrzeć?")) {
            if (getScanner().potwierdz("W środku nie ma nic ciekawego, no chyba, że interesuje Cię kawałek sznurka do bielizy," +
                    "jeśli chesz to możesz go wziąć  ")) {
                zbierzPrzedmiot();
            } else {
                System.out.println("Jak chcesz;)");
            }
        }
    }
}
