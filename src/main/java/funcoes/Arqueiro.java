package funcoes;

import mapas.Mapa;
import paiDeFuncoes.Personagens;

public abstract class Arqueiro extends Personagens {
    protected Arqueiro(int forca, int agilidade, int inteligencia, int constituicao, String fala, boolean sociedadeDoAnel) {
        super(forca, agilidade, inteligencia, constituicao, fala, sociedadeDoAnel);
    }

    protected void atacarMetodo(Mapa mapa){
        int distancia = 0;
        int maisLonge = -1;
        for(int i = 0; i < 10; i++){
            if(mapa.buscarCasa(i) != null){
                if (mapa.getMapa().get(i).isSociedadeDoAnel() != this.isSociedadeDoAnel()){
                    if(Math.abs(mapa.getMapa().indexOf(this) - i) <= 3){
                        maisLonge = 0;
                        if(Math.abs(mapa.getMapa().indexOf(this) - i) > maisLonge){
                            distancia = Math.abs(mapa.getMapa().indexOf(this) - i);
                            maisLonge = i;
                        }
                    }
                }
            }
        }
        if (maisLonge > -1){

            if(mapa.buscarCasa(maisLonge) != null){
                if(mapa.buscarCasa(maisLonge).isSociedadeDoAnel() != this.isSociedadeDoAnel()){
                    mapa.buscarCasa(maisLonge).diminuirConstituicao(this.agilidade * distancia, mapa);

                    }
            }
            }
        }


    public int moverMetodo(Mapa mapa) {
        int posicao = mapa.getMapa().indexOf(this);
        int posicaoDaFrente = posicao + 1;
        int posicaoDeTras = posicao - 1;


        if (this.isSociedadeDoAnel()) {
            if (posicaoDaFrente < 10) {
                if (mapa.buscarCasa(posicaoDaFrente) == null) {
                    mapa.getMapa().set(posicaoDaFrente, this);
                    mapa.getMapa().set(posicao, null);
                    posicao++;
                    posicaoDaFrente++;
                    if (mapa.buscarCasa(posicaoDaFrente) == null) {
                        mapa.getMapa().set(posicaoDaFrente, this);
                        mapa.getMapa().set(posicao, null);
                    }

                }
            }
            return mapa.buscarPosicao(this);
        }else{
            if (posicaoDeTras >= 0) {
                if (mapa.buscarCasa(posicaoDeTras) == null) {
                    mapa.getMapa().set(posicaoDeTras, this);
                    mapa.getMapa().set(posicao, null);
                    posicao--;
                    posicaoDeTras--;
                    if (mapa.buscarCasa(posicaoDeTras) == null) {
                        mapa.getMapa().set(posicaoDeTras, this);
                        mapa.getMapa().set(posicao, null);
                    }

                }
            }



            return mapa.buscarPosicao(this);
        }
    }

}
