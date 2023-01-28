package funcoes;

import mapas.Mapa;
import paiDeFuncoes.Personagens;

public abstract class Guerreiro extends Personagens {


    protected Guerreiro(int forca, int agilidade, int inteligencia, int constituicao, String fala, boolean sociedadeDoAnel) {
        super(forca, agilidade, inteligencia, constituicao, fala, sociedadeDoAnel);
    }

    protected void atacarMetodo(Mapa mapa) {
        int indexDoPersonagemDaFrente = mapa.getMapa().indexOf(this) + 1;
        int indexDoPersonagemDeTras = mapa.getMapa().indexOf(this) - 1;
        Personagens personagemDaFrente = null;
        Personagens personagemDeTras = null;

        if (mapa.getMapa().indexOf(this) > 0 && mapa.getMapa().indexOf(this) < 9) {
            personagemDaFrente = (mapa.buscarCasa(indexDoPersonagemDaFrente));
            personagemDeTras = (mapa.buscarCasa(indexDoPersonagemDeTras));
        } else if (mapa.getMapa().indexOf(this) == 0) {
            personagemDaFrente = (mapa.buscarCasa(indexDoPersonagemDaFrente));
        }else if (mapa.getMapa().indexOf(this) == 9) {
            personagemDeTras = (mapa.buscarCasa(indexDoPersonagemDeTras));
        }

        if (personagemDeTras != null) {
            if (personagemDeTras.isSociedadeDoAnel() != this.isSociedadeDoAnel()) {
                mapa.buscarCasa(indexDoPersonagemDeTras).diminuirConstituicao(this.forca * 2, mapa);
            }
        }
        if (personagemDaFrente != null) {
            if (personagemDaFrente.isSociedadeDoAnel() != this.isSociedadeDoAnel()) {
                mapa.buscarCasa(indexDoPersonagemDaFrente).diminuirConstituicao(this.forca * 2, mapa);
            }
        }


    }


    public int moverMetodo (Mapa mapa){
        if(this.isSociedadeDoAnel()){
            if (mapa.getMapa().indexOf(this) + 1 < 10) {
                Personagens personagemDaFrente = (mapa.buscarCasa((mapa.getMapa().indexOf(this) + 1)));
                int posicaoGuerreiro = mapa.getMapa().indexOf(this);
                if (personagemDaFrente == null) {
                    mapa.getMapa().set(posicaoGuerreiro, null);
                    mapa.inserir(posicaoGuerreiro + 1, this);
                }
            }
            return mapa.buscarPosicao(this);
        }else {
            if (mapa.getMapa().indexOf(this) - 1 >= 0) {
                Personagens personagemDeTras = (mapa.buscarCasa((mapa.getMapa().indexOf(this) - 1)));
                int posicaoGuerreiro = mapa.getMapa().indexOf(this);
                if(personagemDeTras == null){
                    mapa.getMapa().set(posicaoGuerreiro, null);
                    mapa.inserir(posicaoGuerreiro - 1, this);
                }
            }
            return mapa.buscarPosicao(this);
        }
    }
}
