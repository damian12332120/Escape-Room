package escapeRoom.PomieszczeniePierwsze;


import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;
import escapeRoom.Uzytkownik;

import java.util.List;

public class Szafa extends Mebel {


    public Szafa(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        super(nazwa, przedmioty, uzytkownik);
    }

    @Override
    public void reakcja() {
        azja();
        opis();
    }

    @Override
    public void opis() {
        if (getScanner().potwierdz("Podchodzisz do szafy, jest to kawał solidnego drewna. Próbujesz ją otworzyć i nic," +
                "lecz na szafie jest napisane działanie matematyne, chcesz je rozwiazać?")) {
            if (getScanner().dajLiczbe("Treść zadania brzmi: '2+2*2',jeśli znasz odpowiedz to wprowadz ja do " +
                    "kłódki!") == 6) {
                if (!isCzyJuzByl()) {
                    System.out.println("Gratulacje, dobra odpowiedz. W szafie znajduje się kolejny przedmiot, a jest nim..." +
                            "Afryka!!!");
                    setCzyJuzByl(true);
                    zbierzPrzedmiot();
                } else {
                    System.out.println("Udało Ci się po raz kolejny rozwiązać dobrze zadanie, lecz nic wiecej nie dostaniesz;)");
                }
            }
        }
    }

    public void azja() {
        if (!getPrzedmioty().isEmpty()) {
            System.out.println("Ups! Idąc do szafy spotkałeś po drodzę Azję! Tak, drewnianą miniaturkę kontynentu!");
            for (Przedmiot przedmiot : getPrzedmioty()) {
                if (przedmiot.getNazwa().equals("Azja")) {
                    if (przedmiot.wez()) {
                        getUzytkownik().dodajPrzedmiot(przedmiot);
                        getPrzedmioty().remove(przedmiot);
                    }
                }
            }
        }

    }
}
