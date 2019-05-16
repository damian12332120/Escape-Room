package escapeRoom;

import escapeRoom.ObiektyDziedziczone.*;
import escapeRoom.PomieszczenieDrugie.*;
import escapeRoom.PomieszczeniePierwsze.*;
import escapeRoom.PomieszczenieTrzecie.Gablota;
import escapeRoom.PomieszczenieTrzecie.PokojTrzeci;

import java.util.ArrayList;
import java.util.List;

public class Kontloler {
    private Uzytkownik uzytkownik;

    public Kontloler(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public List<Pokoj> rozruch() {
        List<Pokoj> listapokoi = new ArrayList<>();
        listapokoi.add(pokojPierwszy());
        listapokoi.add(pokojDrugi());
        listapokoi.add(pokojTrzeci());
        return listapokoi;
    }

    public Pokoj pokojPierwszy() {
        List<Mebel> listaMebli = meblePierwszegoPokoju();
        return pierwszyPokoj(listaMebli);

    }

    public Pokoj pokojDrugi() {
        List<Mebel> listaMebli = mebleDrugiegoPokoju();
        return drugiPokoj(listaMebli);

    }

    public Pokoj pokojTrzeci() {
        List<Mebel> listaMebli = mebleTrzeciegoPokoju();
        return trzeciPokoj(listaMebli);
    }

    public Pokoj pierwszyPokoj(List<Mebel> meble) {
        return new PokojPierwszy("Pokoj dzienny", meble, true);
    }

    public List<Mebel> meblePierwszegoPokoju() {
        Mebel szafa = szafa();
        Mebel komoda = komoda();
        Mebel ekran = ekranDotykowy();
        Mebel mapa = mapa();
        List<Mebel> meblePierwszegoPokoju = new ArrayList<>();
        meblePierwszegoPokoju.add(szafa);
        meblePierwszegoPokoju.add(komoda);
        meblePierwszegoPokoju.add(ekran);
        meblePierwszegoPokoju.add(mapa);
        return meblePierwszegoPokoju;
    }

    public Pokoj drugiPokoj(List<Mebel> meble) {
        return new PokojDrugi("Kuchnia", meble, false);
    }

    public List<Mebel> mebleDrugiegoPokoju() {
        Mebel krzeslo = krzeslo();
        Mebel lodowka = lodowka();
        Mebel szafkaPierwsza = szafkaPierwsza();
        Mebel szafkaDruga = szafkaDruga();
        Mebel szafkaTrzecia = szafkaTrzecia();
        List<Mebel> meblePokojDrugiego = new ArrayList<>();
        meblePokojDrugiego.add(krzeslo);
        meblePokojDrugiego.add(lodowka);
        meblePokojDrugiego.add(szafkaPierwsza);
        meblePokojDrugiego.add(szafkaDruga);
        meblePokojDrugiego.add(szafkaTrzecia);
        return meblePokojDrugiego;
    }

    public Pokoj trzeciPokoj(List<Mebel> meble) {
        return new PokojTrzeci("Salon", meble, false);
    }

    public List<Mebel> mebleTrzeciegoPokoju() {
        Mebel gablota = gablota();
        List<Mebel> meblePokojTrzeci = new ArrayList<>();
        meblePokojTrzeci.add(gablota);
        return meblePokojTrzeci;
    }

    public Mebel szafa() {
        List<Przedmiot> przedmiotySzafy = new ArrayList<>();
        Kontynet azja = new Kontynet("Azja");
        Kontynet afryka = new Kontynet("Afryka");
        przedmiotySzafy.add(azja);
        przedmiotySzafy.add(afryka);
        return new Szafa("Szafa", przedmiotySzafy, uzytkownik);
    }

    public Mebel komoda() {
        List<Przedmiot> przedmiotyKomody = new ArrayList<>();
        Kontynet amerykaPoludniowa = new Kontynet("Ameryka Południowa");
        przedmiotyKomody.add(amerykaPoludniowa);
        return new Komoda("Komoda", przedmiotyKomody, uzytkownik);
    }

    public Mebel ekranDotykowy() {
        List<Przedmiot> przedmiotyEkranu = new ArrayList<>();
        Kontynet amerykaPolnocna = new Kontynet("Ameryka Północna");
        przedmiotyEkranu.add(amerykaPolnocna);
        return new EkranDotykowy("Ekran dotykowy", przedmiotyEkranu, uzytkownik);
    }

    public Mebel mapa() {
        List<Przedmiot> przedmiotyMapy = new ArrayList<>();
        return new MapaSwiata("Mapa świata", przedmiotyMapy, uzytkownik);
    }

    public Mebel krzeslo() {
        List<Przedmiot> przedmiotyKrzesla = new ArrayList<>();
        Kontynet australia = new Kontynet("Austalia");
        przedmiotyKrzesla.add(australia);
        return new Krzeslo("Krzesło", przedmiotyKrzesla, uzytkownik);

    }

    public Mebel lodowka() {
        List<Przedmiot> przedmiotyLodowki = new ArrayList<>();
        Kontynet antarktyda = new Kontynet("Antarktyda");
        przedmiotyLodowki.add(antarktyda);
        return new Lodowka("Lodowka", przedmiotyLodowki, uzytkownik);
    }

    public Mebel szafkaPierwsza() {

        List<Przedmiot> przedmiotySzafkiJeden = new ArrayList<>();
        PrzedmiotPoboczny kluczykDoSzafkiTrzy = new PrzedmiotPoboczny("Klucz");
        przedmiotySzafkiJeden.add(kluczykDoSzafkiTrzy);
        return new KuchennaSzafkaJeden("Szafka narożna", przedmiotySzafkiJeden, uzytkownik);
    }

    public Mebel szafkaDruga() {


        List<Przedmiot> przedmiotySzafkiDwa = new ArrayList<>();
        PrzedmiotPoboczny sznurekOdBielizny = new PrzedmiotPoboczny("Sznurek");
        przedmiotySzafkiDwa.add(sznurekOdBielizny);
        return new KuchennaSzafkaDwa("Szafka ścienna", przedmiotySzafkiDwa, uzytkownik);
    }

    public Mebel szafkaTrzecia() {


        List<Przedmiot> przedmiotySzafkiTrzy = new ArrayList<>();
        PrzedmiotPoboczny kluczykDoLodowki = new PrzedmiotPoboczny("Klucz lodowka");
        przedmiotySzafkiTrzy.add(kluczykDoLodowki);
        return new KuchennaSzafkaTrzy("Szafka wolnostojąca", przedmiotySzafkiTrzy, uzytkownik);
    }

    public Mebel gablota() {
        List<Przedmiot> przedmiotyGabloty = new ArrayList<>();
        Kontynet europa = new Kontynet("Europa");
        przedmiotyGabloty.add(europa);
        return new Gablota("Gablota", przedmiotyGabloty, uzytkownik);
    }
}
