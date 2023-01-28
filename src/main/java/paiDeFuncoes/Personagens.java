package paiDeFuncoes;

import mapas.Mapa;

public abstract class Personagens {
    protected int forca;
    protected int agilidade;
    protected int inteligencia;
    protected int constituicao;
    protected String fala;
    protected boolean sociedadeDoAnel;


    public Personagens(int forca, int agilidade, int inteligencia, int constituicao, String fala, boolean sociedadeDoAnel) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicao = constituicao;
        this.fala = fala;
        this.sociedadeDoAnel = sociedadeDoAnel;
    }

    protected String falar(){
        return this.fala;
    }
    public void diminuirConstituicao(int valor, Mapa mapa){
        int posicao = mapa.getMapa().indexOf(this);
        this.constituicao -= valor;
        if(this.constituicao <= 0){
            mapa.getMapa().set(posicao, null);
        }

    }

    public void atacar(Mapa mapa){
        this.atacarMetodo(mapa);
    }
    protected void atacarMetodo(Mapa mapa){

    }

    public int mover(Mapa mapa){
        return this.moverMetodo(mapa);
    }

    protected int moverMetodo(Mapa mapa){
        return 0;
    }


    public int getForca() {
        return forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public boolean isSociedadeDoAnel() {
        return sociedadeDoAnel;
    }
}
