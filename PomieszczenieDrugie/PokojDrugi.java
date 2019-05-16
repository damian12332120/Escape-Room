package escapeRoom.PomieszczenieDrugie;

import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Pokoj;

import java.util.List;

public class PokojDrugi extends Pokoj {

    public PokojDrugi(String nazwa, List<Mebel> wystrojPomieszczenia, Boolean czyDostepny) {
        super(nazwa, wystrojPomieszczenia, czyDostepny);
    }
}
