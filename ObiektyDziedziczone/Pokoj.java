package escapeRoom.ObiektyDziedziczone;


import java.util.List;

public abstract class Pokoj {

    private List<Mebel> wystrojPomieszczenia;
    private String nazwa;
    private boolean czyDostepny;

    public Pokoj(String nazwa, List<Mebel> wystrojPomieszczenia, Boolean czyDostepny) {
        this.nazwa = nazwa;
        this.czyDostepny =czyDostepny;
        this.wystrojPomieszczenia = wystrojPomieszczenia;
    }

    public boolean isCzyDostepny() {
        return czyDostepny;
    }

    public void setCzyDostepny(boolean czyDostepny) {
        this.czyDostepny = czyDostepny;
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Mebel> getWystrojPomieszczenia() {
        return wystrojPomieszczenia;
    }

    public void setWystrojPomieszczenia(List<Mebel> wystrojPomieszczenia) {
        this.wystrojPomieszczenia = wystrojPomieszczenia;
    }

    @Override
    public String toString() {
        return nazwa ;
    }
}
