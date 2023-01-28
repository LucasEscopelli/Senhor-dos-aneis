package personagens;

import funcoes.Guerreiro;
import mapas.Mapa;
import racas.Humano;

public class Boromir extends Guerreiro implements Humano {
    public Boromir() {
        super(7,6,3,40,"One does not simply walk into Mordor.",true);
    }


    @Override
    public String falar() {
        return fala;
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public void envelhecer() {
        this.constituicao -= 2;
    }
}
