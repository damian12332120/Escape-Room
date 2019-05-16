package escapeRoom;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;

import java.util.ArrayList;
import java.util.List;

public class Uzytkownik {

    List<Przedmiot> zebraneArtykuly;

    public Uzytkownik() {
        zebraneArtykuly = new ArrayList<>();

    }

    public List<Przedmiot> getZebraneArtykuly() {
        return zebraneArtykuly;
    }

    public void setZebraneArtykuly(List<Przedmiot> zebraneArtykuly) {
        this.zebraneArtykuly = zebraneArtykuły;
    }

    public void dodajPrzedmiot(Przedmiot przedmiot) {
        getZebraneArtykuly().add(przedmiot);
    }

    @Override
    public String toString() {
        return "Twoje artykuły" + zebraneArtykuly;
    }
}

