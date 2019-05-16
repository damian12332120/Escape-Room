package escapeRoom.PomieszczenieDrugie;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;
import escapeRoom.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

public class KuchennaSzafkaJeden extends Mebel {
    public KuchennaSzafkaJeden(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        super(nazwa, przedmioty, uzytkownik);
    }


    @Override
    public void reakcja() {
        opis();
    }

    @Override
    public void opis() {
        System.out.println("Otwierasz szafke, a w niej kilka przypraw...");
        przyprawy();
        coChceszZrobic();
    }

    public void przyprawy() {
        List<String> przyprawy = new ArrayList<>();
        przyprawy.add("pieprz");
        przyprawy.add("sól");
        przyprawy.add("kurkuma");
        przyprawy.add("szafran");
        przyprawy.add("goździki");
        przyprawy.add("majeranek");
        przyprawy.add("zioła prowansalskie");
        przyprawy.add("oregano");
        przyprawy.add("curry");
        for (String s : przyprawy) {
            System.out.print(s + ", ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void coChceszZrobic() {
        int liczba = getScanner().dajLiczbe("Co chcesz zrobić\n1.Przeszukać przyprawy.\n2.Zamknąć szafkę.");
        if (liczba == 1) {
            szukanieKlucza();
        }
    }

    public void szukanieKlucza() {
        String majeranek;
        do {
            majeranek = getScanner().dajTekst("Jaką przyprawę chcesz otworzyć?");
            if (!majeranek.toLowerCase().trim().equals("majeranek")) {
                System.out.println("W woreczku jest to czego się mogłeś spodziewać po nazwie na opakowaniu.");
            }
        } while (!majeranek.toLowerCase().trim().equals("majeranek"));
        if (!isCzyJuzByl()) {
            System.out.println("Gratuluje znalazłeś klucz!");
            zbierzPrzedmiot();
            setCzyJuzByl(true);

        } else {
            System.out.println("W przyprawie juz wiecej nic nie ma");
        }
    }
}
