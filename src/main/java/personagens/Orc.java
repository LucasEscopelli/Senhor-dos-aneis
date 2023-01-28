package personagens;

import funcoes.Guerreiro;
import racas.Monstro;

public class Orc extends Guerreiro implements Monstro {
    public Orc() {
        super(7,4,1,30,"Arrrggghhh",false);
    }

    @Override
    public String grunir() {
        return fala;
    }

    @Override
    public String toString() {
        return "O";
    }
}
