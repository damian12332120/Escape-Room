package escapeRoom.PomieszczeniePierwsze;


import escapeRoom.ObiektyDziedziczone.Mebel;
import escapeRoom.ObiektyDziedziczone.Pokoj;

import java.util.List;

public class PokojPierwszy extends Pokoj {

    public PokojPierwszy(String nazwa, List<Mebel> wystrojPomieszczenia, Boolean czyDostepny) {
        super(nazwa, wystrojPomieszczenia, czyDostepny);
    }
}
