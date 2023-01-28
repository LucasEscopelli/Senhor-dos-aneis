package personagens;

import funcoes.Arqueiro;
import racas.Monstro;

public class Goblim extends Arqueiro implements Monstro {
    public Goblim() {
        super(3, 6, 1, 20, "Iiisshhhh", false);
    }

    @Override
    public String grunir() {
        return super.falar();
    }

    @Override
    public String toString() {
        return "M";
    }
}
