package escapeRoom;


import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Pokoj;
import escapeRoom.ObiektyDziedziczone.Przedmiot;

import java.util.List;

public class LogikaGry {

    private static String pokojZListy;
    private static boolean koniecGry = false;
    private UpgradeScanner scanner;
    private Uzytkownik uzytkownik;
    private List<Pokoj> listaPokoi;


    public LogikaGry(Uzytkownik uzytkownik, List<Pokoj> listaPokoi) {

        scanner = new UpgradeScanner();
        this.uzytkownik = uzytkownik;
        this.listaPokoi = listaPokoi;
    }

    public void scenariuszGry() {
        wprowadzenie();
        logika();
    }

    public void wprowadzenie() {
        System.out.println("Witaj!\nWchodzisz do naszego Escape Room'a, gra ma kilka pomieszczeń które musisz przejść, " +
                "by się wydostać, mam nadzieje, że dasz radę! Powodzenia!");
    }

    public void logika() {
        pokojZListy = wybierzPokojZListy();
        do {
            String mebel = przegladPokoju(docelowyPokoj(pokojZListy));
            wybor(docelowyPokoj(pokojZListy), mebel);
            przedmiotyUzytkownika();
            if (scanner.potwierdz("Czy chcesz zmienić pokoj?")) {
                pokojZListy = wybierzPokojZListy();
            }

        } while (!koniecGry);

    }

    public String wybierzPokojZListy() {
        System.out.println("Możesz wejść do pokojów:");
        for (Pokoj pokoj : listaPokoi) {
            if (pokoj.isCzyDostepny()) {
                System.out.print(pokoj + ", ");
            }
        }
        return scanner.dajTekst("\nGdzie chciałbyś wejść?");
    }

    public String przegladPokoju(Pokoj pokoj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("W pokoju zauważasz kilka mebli:\n");
        try {
            for (Mebel mebel : pokoj.getWystrojPomieszczenia()) {
                stringBuilder.append(mebel + " ");
            }
        } catch (NullPointerException e) {
            System.out.println("Podaj właściwą nazwę pokoju");
            logika();
        }
        System.out.println(stringBuilder);
        return scanner.dajTekst("\nDo czego chciałbyś podejść?");
    }

    public Pokoj docelowyPokoj(String nazwaPokoju) {
        for (Pokoj pokoj : listaPokoi) {
            if (pokoj.getNazwa().toLowerCase().equals(nazwaPokoju.toLowerCase().trim())) {
                return pokoj;
            }
        }
        return null;
    }

    public void wybor(Pokoj pokoj, String obiekt) {
        for (Mebel mebel : pokoj.getWystrojPomieszczenia()) {
            if (mebel.getNazwa().toLowerCase().trim().equals(obiekt.toLowerCase())) {
                mebel.reakcja();
                int dostepDoPokoju = mebel.getPrzedmioty().size();
                switch (dostepDoPokoju) {
                    case 4:
                        przejscieDoDugiegoPokoju();
                        break;
                    case 6:
                        przejscieDoTrzeciegoPokoju();
                        break;
                    case 7:
                        wyscieZGry();
                }
                if (licznikKontynentowPokojuDrugiego() == 2) {
                    System.out.println("Jeśli chcesz to mozesz podejść do mapy");
                    pokojZListy = wybierzPokojZListy();
                }
                if (licznikKontynentowPokojuTrzeciego() == 1) {
                    System.out.println("Jeśli chcesz to mozesz podejść do mapy");
                    pokojZListy = wybierzPokojZListy();
                }
            }
        }
    }

    public void przejscieDoDugiegoPokoju() {
        System.out.println("Słyszysz szczęk zamka! Drzwi obok mapy się otwierają, sprawdz co jest za nimi!");
        for (Pokoj pokoj : listaPokoi) {
            if (pokoj.getNazwa().equals("Kuchnia")) {
                pokoj.setCzyDostepny(true);
                pokojZListy = wybierzPokojZListy();
            }
        }
    }

    public int licznikKontynentowPokojuDrugiego() {
        int licznik = 0;
        for (Przedmiot przedmiot : uzytkownik.getZebraneArtykuły()) {
            if (przedmiot.getNazwa().equals("Antarktyda") || przedmiot.getNazwa().equals("Austalia")) {
                licznik++;
            }
        }
        return licznik;
    }

    public int licznikKontynentowPokojuTrzeciego() {
        int licznik = 0;
        for (Przedmiot przedmiot : uzytkownik.getZebraneArtykuły()) {
            if (przedmiot.getNazwa().equals("Europa")) {
                licznik++;
            }
        }
        return licznik;
    }

    public void przejscieDoTrzeciegoPokoju() {
        System.out.println("Kolejne drzwi stoją przed Tobą otworem, zapraszam!");
        for (Pokoj pokoj : listaPokoi) {
            if (pokoj.getNazwa().equals("Salon")) {
                pokoj.setCzyDostepny(true);
                pokojZListy = wybierzPokojZListy();
            }
        }
    }

    public void wyscieZGry() {
        System.out.println("Gratuluje gra została skończona!;)");
        koniecGry = true;
    }

    public void przedmiotyUzytkownika() {
        System.out.println("Lista twoich przedmiotów:");
        int licznik = 1;
        for (Przedmiot przedmiot : uzytkownik.getZebraneArtykuły()) {
            System.out.println(licznik + ". " + przedmiot);
            licznik++;
        }
    }
}