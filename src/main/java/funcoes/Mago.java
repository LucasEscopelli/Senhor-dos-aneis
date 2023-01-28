package funcoes;

import mapas.Mapa;
import paiDeFuncoes.Personagens;

import java.util.ArrayList;
import java.util.List;

public abstract class Mago extends Personagens {


    protected Mago(int forca, int agilidade, int inteligencia, int constituicao, String fala, boolean sociedadeDoAnel) {
        super(forca, agilidade, inteligencia, constituicao, fala, sociedadeDoAnel);
    }

    protected void atacarMetodo(Mapa mapa){
        for(int i = 0; i < 10; i++){
            if(mapa.buscarCasa(i) != null) {
                if ((this.isSociedadeDoAnel() != mapa.buscarCasa(i).isSociedadeDoAnel())) {
                    mapa.buscarCasa(i).diminuirConstituicao(this.inteligencia, mapa);
                }
            }
        }
    }

    protected int moverMetodo(Mapa mapa){
        int posicaoMago = mapa.mapa.indexOf(this);
        int contagem = 0;

        for(int i = 0; i < 10; i++){
            if(!(mapa.buscarCasa(i) == null)){
                contagem++;
            }
        }
        if(this.isSociedadeDoAnel()) {
            if (mapa.getMapa().indexOf(this) + 1 < 10) {
                if (contagem == 1) {
                    mapa.getMapa().set(posicaoMago, null);
                    mapa.inserir(posicaoMago + 1, this);
                }
            }
            return mapa.buscarPosicao(this);
        }else{
            if (mapa.getMapa().indexOf(this) - 1 >= 0) {
                if (contagem == 1) {
                    mapa.getMapa().set(posicaoMago, null);
                    mapa.inserir(posicaoMago - 1, this);
                }
            }
            return mapa.buscarPosicao(this);
        }
    }

}
