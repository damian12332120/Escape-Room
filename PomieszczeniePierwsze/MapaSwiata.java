package escapeRoom.PomieszczeniePierwsze;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;
import escapeRoom.UpgradeScanner;
import escapeRoom.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

public class MapaSwiata extends Mebel {

    public MapaSwiata(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        super(nazwa, przedmioty, uzytkownik);

    }

    @Override
    public void reakcja() {
        opis();
    }

    @Override
    public void opis() {
        List<Przedmiot>przedmioty = new ArrayList<>();
        System.out.println("Podchodzisz do mapy i zauważasz, że jest zrobiona z drewna i brakuje w niej kontynentów...");
        if (getScanner().potwierdz("Czy masz brakujące kontynenty i chcesz je zamieścić na mapie? ")) {
            for (Przedmiot przedmiot : getUzytkownik().getZebraneArtykuły()) {
               if(!przedmiot.getNazwa().equals("Sznurek")){
                   getPrzedmioty().add(przedmiot);
               }else{
                   przedmioty.add(przedmiot);
               }
            }
            getUzytkownik().getZebraneArtykuły().clear();
            getUzytkownik().getZebraneArtykuły().addAll(przedmioty);
        }
    }
}
