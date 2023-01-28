package personagens;

import funcoes.Mago;
import mapas.Mapa;
import racas.Maia;

public class Gandalf extends Mago implements Maia {

    public Gandalf() {
        super(2,3,10,80,"A Wizard is never late, nor is he early. He arrives precisely when he means to.", true);
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
            return new Gandalf();
        }

        @Override
        public String falar() {
            return fala;
        }

        @Override
        public String toString() {
            return "G";
        }
    }
