package escapeRoom;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;

import java.util.ArrayList;
import java.util.List;

public class Uzytkownik {

    List<Przedmiot> zebraneArtykuły;

    public Uzytkownik() {
        zebraneArtykuły = new ArrayList<>();

    }

    public List<Przedmiot> getZebraneArtykuły() {
        return zebraneArtykuły;
    }

    public void setZebraneArtykuły(List<Przedmiot> zebraneArtykuły) {
        this.zebraneArtykuły = zebraneArtykuły;
    }

    public void dodajPrzedmiot(Przedmiot przedmiot) {
        getZebraneArtykuły().add(przedmiot);
    }

    @Override
    public String toString() {
        return "Twoje artykuły" + zebraneArtykuły;
    }
}

