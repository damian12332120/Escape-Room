package escapeRoom;



public class Main {
    public static void main(String[] args) {
        Uzytkownik uzytkownik = new Uzytkownik();
        Kontloler kontloler = new Kontloler(uzytkownik);
        LogikaGry logikaGry = new LogikaGry(uzytkownik,kontloler.rozruch());
        logikaGry.scenariuszGry();

    }
}
