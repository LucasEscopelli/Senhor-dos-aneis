package personagens;

import funcoes.Mago;
import mapas.Mapa;
import racas.Maia;

public class Saruman extends Mago implements Maia {
    public Saruman() {
        super(2,2,70,9,"Against the power of Mordor there can be no victory.",false);
    }

    @Override
    public void diminuirConstituicao(int valor, Mapa mapa) {
        int posicao = mapa.getMapa().indexOf(this);
        super.diminuirConstituicao(valor, mapa);
        if (constituicao <= 0) {
            mapa.getMapa().set(posicao, this.ressucitar());
        }
    }

    @Override
    public Mago ressucitar() {
        return null;
    }

    @Override
    public String falar() {
        return fala;
    }

    @Override
    public String toString() {
        return "S";
    }
}
