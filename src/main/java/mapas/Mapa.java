package mapas;

import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import paiDeFuncoes.Personagens;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    public ArrayList<Personagens> mapa = new ArrayList<>(10);

    public Mapa() {
        for(int i = 0; i < 10; i++ ){
            mapa.add(i,null);
        }
    }

    public String exibir(){
        StringBuilder mapaString = new StringBuilder("");
        for(int i = 0; i < 10; i++){
            mapaString.append("|");
            if(mapa.get(i) == null){
                mapaString.append(" ");
            }else {
                mapaString.append(mapa.get(i).toString());
            }
        }
        mapaString.append("|");
        return mapaString.toString();
    }

    public void inserir(int posicao, Personagens personagem){
        if (mapa.get(posicao) == null){
            if (mapa.toString().contains(personagem.toString())){
                throw new PersonagemJaEstaNoMapaException();
            }else {
                mapa.set(posicao, personagem);
            }
        }else {
            throw new PosicaoOcupadaException();
        }
    }

    public int buscarPosicao(Personagens personagem){
        if (mapa.contains(personagem)){
            return mapa.indexOf(personagem);
        }else {
            throw new PersonagemNaoEncontradoNoMapaException();
        }
    }

    public ArrayList<Personagens> getMapa() {
        return mapa;
    }

    public void setMapa(ArrayList<Personagens> mapa) {
        this.mapa = mapa;
    }

    public Personagens buscarCasa(int posicao){
        return mapa.get(posicao);
    }

}
