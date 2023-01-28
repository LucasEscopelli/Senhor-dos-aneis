package personagens;

import funcoes.Guerreiro;
import racas.Anão;

public class Gimli extends Guerreiro implements Anão {
    private int quantBebida;
    boolean taBebado;

    public Gimli() {
        super(9,2,4,60,"Let them come. There is one Dwarf yet in Moria who still draws breath.",true);
    }

    @Override
    public void beber() {
        quantBebida++;
        if (quantBebida>=3){
            this.fala = "What did I say? He can't hold his liquor!";
        }
    }

    @Override
    public String falar() {
        return fala;
    }

    @Override
    public String toString() {
        return "I";
    }
}
