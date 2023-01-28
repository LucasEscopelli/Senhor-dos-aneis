package simulacao;

import excecoes.SauronDominaOMundoException;
import mapas.Mapa;
import paiDeFuncoes.Personagens;

public class Simulador {
    Mapa mapa;
    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public void simular(){
        boolean vitoriaSociedadeAnel = false;
        int contagem;
        int casaDoI;
        while(!vitoriaSociedadeAnel){
            contagem = 0;

            for(int i = 0; i < mapa.getMapa().size(); i++){
                if(mapa.getMapa().get(i) != null) {
                    mapa.getMapa().get(i).atacar(mapa);
                    casaDoI = mapa.buscarCasa(i).mover(mapa);
                    if(mapa.buscarCasa(i) != null){
                        mapa.buscarCasa(i).mover(mapa);
                    }
                    i = casaDoI;

                }
            }

            if(mapa.getMapa().get(9) != null){
                if(mapa.getMapa().get(9).isSociedadeDoAnel()){
                    vitoriaSociedadeAnel = true;
                }
            }

            for(Personagens personagem: mapa.getMapa()){
                if(personagem != null){
                    if(personagem.isSociedadeDoAnel()){
                        ++contagem;
                        break;
                    }
                }
            }
            if(contagem == 0){
            throw new SauronDominaOMundoException();
        }
        }

    }
}
