package personagens;

import funcoes.Guerreiro;
import mapas.Mapa;
import racas.Humano;

public class Aragorn extends Guerreiro implements Humano {

    public Aragorn() {
        super(10,7,6,60,"A day may come when the courage of men fails… but it is not THIS day.",true);
    }

    @Override
    public void envelhecer() {
        this.constituicao -= 1;
    }

    @Override
    public String falar() {
        return fala;
    }


    @Override
    public String toString() {
        return "A";
    }
}
