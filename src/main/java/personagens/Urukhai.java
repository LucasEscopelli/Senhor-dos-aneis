package personagens;

import funcoes.Guerreiro;
import mapas.Mapa;
import racas.Humano;
import racas.Monstro;

public class Urukhai extends Guerreiro implements Monstro, Humano {
    public Urukhai() {
        super(8,6,3,45,"Looks like meat's back on the menu boys!", false);
    }

    @Override
    public void envelhecer() {
        this.constituicao -= 2;
    }

    @Override
    public String falar() {
        return fala;
    }

    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }

    @Override
    public String toString() {
        return "U";
    }
}
