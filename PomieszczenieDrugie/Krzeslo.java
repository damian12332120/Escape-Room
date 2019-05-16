package escapeRoom.PomieszczenieDrugie;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Przedmiot;
import escapeRoom.Uzytkownik;

import java.util.List;

public class Krzeslo extends Mebel {

    public Krzeslo(String nazwa, List<Przedmiot> przedmioty, Uzytkownik uzytkownik) {
        super(nazwa, przedmioty, uzytkownik);
    }

    @Override
    public void reakcja( ) {
        opis();
    }

    @Override
    public void opis() {
        System.out.println("Krzesło jak krzesło, możesz na nim usiaść. ");
        if (getScanner().potwierdz("Czy chcesz usiaść i się zastanowić?")) {
            australia();
        }
    }

    public void australia() {
        if (!isCzyJuzByl()) {
            System.out.println("Patrzysz w sufit, a na nim przyklejony kolejny przedmiot->Autralia, chyba uda Ci się" +
                    " po niego siegnać jak staniesz na krzesło...");
            if (getScanner().potwierdz("Próbujemy!?")) {
                try {
                    System.out.println("No to do dzieła!");
                    Thread.sleep(6000);
                    System.out.println("Tak udało Ci się dostać, masz kolejny przedmiot spostrzegawczy człowieku;D ");
                    zbierzPrzedmiot();
                    setCzyJuzByl(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Możesz sobie usiaść i zastanowić, ale nic wiecej;)");
        }
    }
}
