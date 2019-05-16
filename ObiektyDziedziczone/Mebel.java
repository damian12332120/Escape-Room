package escapeRoom.ObiektyDziedziczone;

import escapeRoom.Interfejsy.Reakcja;
import escapeRoom.UpgradeScanner;
import escapeRoom.Uzytkownik;
import java.util.List;

public abstract class Mebel implements Reakcja {

    private String nazwa;
    private List<Przedmiot> przedmioty;
    private Uzytkownik uzytkownik;
    private UpgradeScanner scanner;
    private boolean czyJuzByl;

    public Mebel(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        this.nazwa = nazwa;
        this.przedmioty = przedmioty;
        this.uzytkownik = uzytkownik;
        scanner = new UpgradeScanner();
        czyJuzByl = false;
    }


    public String getNazwa() {
        return nazwa;
    }

    public List<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(List<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
    }


    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public UpgradeScanner getScanner() {
        return scanner;
    }

    public boolean isCzyJuzByl() {
        return czyJuzByl;
    }

    public void setCzyJuzByl(boolean czyJuzByl) {
        this.czyJuzByl = czyJuzByl;
    }

    public void opis() {}

    public void zbierzPrzedmiot(){
        if (!getPrzedmioty().isEmpty()) {
            for (Przedmiot przedmiot : getPrzedmioty()) {
                if (przedmiot.wez()) {
                   uzytkownik.dodajPrzedmiot(przedmiot);
                }
            }
        }
        getPrzedmioty().clear();
    }


    @Override
    public void reakcja() {
    }

    @Override
    public String toString() {
        return nazwa + ",";
    }
}
