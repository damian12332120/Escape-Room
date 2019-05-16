package escapeRoom;

import java.util.Scanner;

public class UpgradeScanner {

private Scanner scanner;

    public UpgradeScanner() {
        this.scanner = new Scanner(System.in);
    }

    public String dajTekst(String komunikat){
        System.out.println(komunikat);
        return scanner.nextLine();
    }

    public int dajLiczbe(String komunikat) {
        System.out.println(komunikat);
        String liczba = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : liczba.toCharArray()) {

            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            }

        }
        if (stringBuilder.length() != 0) {
            return Integer.parseInt(stringBuilder.toString());
        } else {
           return  dajLiczbe("Wprowadz poprawna liczbe");
        }

    }

    public boolean potwierdz(String komunikat) {
        System.out.println(komunikat);
        System.out.println("T/N");
        String wynik = scanner.nextLine();
        System.out.println(wynik);
        if (wynik.equalsIgnoreCase("T")) {
            return true;
        } else if (wynik.equalsIgnoreCase("N")) {
            return false;
        } else {
            System.out.println("podaj właściwą wartość");
            potwierdz(komunikat);
            return false;
        }
    }
}
