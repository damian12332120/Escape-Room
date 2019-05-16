package escapeRoom.PomieszczenieTrzecie;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Pokoj;

import java.util.List;

public class PokojTrzeci extends Pokoj {
    public PokojTrzeci(String nazwa, List<Mebel> wystrojPomieszczenia, Boolean czyDostepny) {
        super(nazwa, wystrojPomieszczenia, czyDostepny);
    }
}
