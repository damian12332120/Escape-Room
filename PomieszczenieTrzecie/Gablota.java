package escapeRoom.PomieszczenieTrzecie;

import escapeRoom.ObiektyDziedziczone.Kontynet;
import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;
import escapeRoom.Uzytkownik;

import java.util.List;

public class Gablota extends Mebel {
    public Gablota(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        super(nazwa, przedmioty, uzytkownik);
    }


    @Override
    public void reakcja() {
        opis();
        boolean czyPrzyczepil = przyczepDoGabloty();
        boolean czyPrzyczepil2 = przyczepDoKolowrotku();
        if (czyPrzyczepil && czyPrzyczepil2) {
            wlaczKolowrotek();
        }

    }

    @Override
    public void opis() {
        if (getScanner().potwierdz("Patrzysz na piękną przeszkloną gablotę, a w niej stoi cel twojego zadania, Europa.\n" +
                "Gablota posiada haczyk, a w ścianie znajduję się kołowrotek z możliwością zabezpieczenia przed opadaniem," +
                "a także przycisk uruchamiający kołowrotek czy masz sprzęt, by to otworzyć? ")) {
        }
    }

    public boolean przyczepDoGabloty() {

        if (czyPosiada()) {
            String sznurek = getScanner().dajTekst("Co chcesz przyczepić do gabloty?").trim().toLowerCase();
            if (sznurek.equals("sznurek")) {
                getPrzedmioty().addAll(getUzytkownik().getZebraneArtykuły());
                System.out.println("Sznurek przyczepiony do gabloty, działaj dalej");
                return true;
            }
        } else {
            System.out.println("Nie masz przedmiotów, które spełnią to zadanie.");
        }
        return false;
    }

    public boolean przyczepDoKolowrotku() {
        if (czyPosiada()) {
            if (getScanner().potwierdz("Czy chcesz podejść do kołowrotku i przyczepić sznurek?")) {
                System.out.println("Sznurek został przyczepiony,");
                return true;
            }
        }
        return false;
    }

    public void wlaczKolowrotek() {
        if (getScanner().potwierdz("Wszystko działa jak należy, czy chcesz spróbować otworzyć gablotę?")) {
            System.out.println("Gablota została otwarta, podchodzisz do niej i bierzesz ostatni element układanki," +
                    "możesz teraz wracać do mapy świata i dokończyć zadanie");
            getUzytkownik().getZebraneArtykuły().clear();
            for (Przedmiot przedmiot : getPrzedmioty()) {
                if (przedmiot instanceof Kontynet) {
                    getUzytkownik().getZebraneArtykuły().add(przedmiot);
                }
            }
        }
    }

    public boolean czyPosiada() {
        for (Przedmiot przedmiot : getUzytkownik().getZebraneArtykuły()) {
            if (przedmiot.getNazwa().equals("Sznurek")) {
                return true;
            }
        }
        return false;
    }
}