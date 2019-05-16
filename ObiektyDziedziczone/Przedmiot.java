package escapeRoom.ObiektyDziedziczone;


import escapeRoom.Interfejsy.Wez;


public abstract class Przedmiot implements Wez {
    private String nazwa;

    public Przedmiot(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    @Override
    public boolean wez() {
        System.out.println("Przedmiot został dodany do twojego plecaka.");
        return true;
    }
}
