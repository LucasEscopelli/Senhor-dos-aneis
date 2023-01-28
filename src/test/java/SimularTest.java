import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import excecoes.SauronDominaOMundoException;
import mapas.Mapa;
import org.junit.Assert;
import org.junit.Test;
import personagens.*;
import simulacao.Simulador;

public class SimularTest {
    @Test
    public void deveVencerSociedadeQuandoAragornELegolasBatalharemContraOrcEGoblim(){
        // Início:  "|A|L| | | | | |O| |M|"
        String resultadoEsperado = "| | | | |A| | | | |L|";

        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();
        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(7, orc);
        mapa.inserir(9, goblim);

        Simulador simular = new Simulador(mapa);
        simular.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());

    }
    @Test(expected = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoInimigosDerrotaremMembrosDaSociedade()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início: "|A| |I| | | | |U|O|G|"
        // Fim:    "| | | | | | |O|M| | |"

        Aragorn aragorn = new Aragorn();
        Gimli gimli = new Gimli();
        Urukhai urukhai = new Urukhai();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();

        mapa.inserir(0, aragorn);
        mapa.inserir(2, gimli);
        mapa.inserir(7, urukhai);
        mapa.inserir(8, orc);
        mapa.inserir(9, goblim);
        Simulador simular = new Simulador(mapa);
        simular.simular();
    }

    @Test
    public void deveVencerSociedadeQuandoGandalfBatalharSozinhoContraSaruman()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|G| | | | | | | | |S|"
        String resultadoEsperado = "| | | | | | | | | |G|";

        Gandalf gandalf = new Gandalf();
        Saruman saruman = new Saruman();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, gandalf);
        mapa.inserir(9, saruman);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test(expected = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoLegolasBatalharSozinhoContraOrcEUrukhai()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|L| | | | | | | |U|O|"
        // Fim:     "| | | | | |U| | | | |";

        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Urukhai urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, legolas);
        mapa.inserir(8, urukhai);
        mapa.inserir(9, orc);
        simulador.simular();
        mapa.exibir();
    }

    @Test(expected = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoBoromirBatalharSozinhoContraUrukhai()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|B| | | | | | | | |U|"
        // Fim:     "| | | | |U| | | | | |";

        Boromir boromir = new Boromir();
        Urukhai urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, boromir);
        mapa.inserir(9, urukhai);
        simulador.simular();
    }

    @Test
    public void testandoTodasAsFalasGrunidosFalasElficasEBebadas(){
        Aragorn aragorn = new Aragorn();
        Boromir boromir = new Boromir();
        Gandalf gandalf = new Gandalf();
        Gimli gimli = new Gimli();
        Goblim goblim = new Goblim();
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Saruman saruman = new Saruman();
        Urukhai urukhai = new Urukhai();

        String falaEsperadaAragorn = "A day may come when the courage of men fails… but it is not THIS day.";
        String falaEsperadaBoromir = "One does not simply walk into Mordor.";
        String falaEsperadaGandalf = "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
        String falaEsperadaGimli = "Let them come. There is one Dwarf yet in Moria who still draws breath.";
        String falaEsperadaGimliBebado = "What did I say? He can't hold his liquor!";
        String falaEsperadaLegolas = "They're taking the Hobbits to Isengard!";
        String falaElficaEsperadaLegolas = "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";
        String falaEsperadaSaruman = "Against the power of Mordor there can be no victory.";
        String falaEsperadaUrukhai = "Looks like meat's back on the menu boys!";
        String grunidoEsperadoGoblim = "Iiisshhhh";
        String grunidoEsperadoOrc = "Arrrggghhh";
        String grunidoEsperadoUrukhai = "Uuurrrrrr";





        Assert.assertEquals(falaEsperadaAragorn, aragorn.falar());
        Assert.assertEquals(falaEsperadaBoromir, boromir.falar());
        Assert.assertEquals(falaEsperadaGandalf, gandalf.falar());
        Assert.assertEquals(falaEsperadaSaruman, saruman.falar());
        Assert.assertEquals(falaEsperadaGimli, gimli.falar());
        gimli.beber();
        gimli.beber();
        gimli.beber();
        Assert.assertEquals(falaEsperadaGimliBebado, gimli.falar());
        Assert.assertEquals(falaEsperadaLegolas, legolas.falar());
        Assert.assertEquals(falaElficaEsperadaLegolas, legolas.falarElfico());
        Assert.assertEquals(falaEsperadaUrukhai, urukhai.falar());
        Assert.assertEquals(grunidoEsperadoGoblim, goblim.grunir());
        Assert.assertEquals(grunidoEsperadoOrc, orc.grunir());
        Assert.assertEquals(grunidoEsperadoUrukhai, urukhai.grunir());
    }

    @Test
    public void gandalfTemQueGanharERessucitar(){
            // Início:  "|G| | | | | | | | |S|"
            String resultadoEsperado = "| | | | | | | | | |G|";

            Gandalf gandalf = new Gandalf();
            Saruman saruman = new Saruman();
            Urukhai urukhai = new Urukhai();
            Orc orc = new Orc();
            Mapa mapa = new Mapa();
            Simulador simulador = new Simulador(mapa);

            mapa.inserir(0, gandalf);
            mapa.inserir(9, saruman);
            mapa.inserir(1, urukhai);
            mapa.inserir(2, orc);
            simulador.simular();

            Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test
    public void guerreirosEmCadaPonta(){
        String resultadoEsperado = "| | | | | | | | | |A|";

        Aragorn aragorn = new Aragorn();
        Orc orc = new Orc();

        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);


        mapa.inserir(0, aragorn);
        mapa.inserir(9, orc);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test
    public void humanosEnvelhecem(){
        Aragorn aragorn = new Aragorn();
        Boromir boromir = new Boromir();
        Urukhai urukhai = new Urukhai();

        aragorn.envelhecer();
        boromir.envelhecer();
        urukhai.envelhecer();
        int aragornConstituicaoEsperada = 59;
        int boromirConstituicaoEsperada = 38;
        int urukhaiConstituicaoEsperada = 43;

        Assert.assertEquals(aragornConstituicaoEsperada, aragorn.getConstituicao());
        Assert.assertEquals(boromirConstituicaoEsperada, boromir.getConstituicao());
        Assert.assertEquals(urukhaiConstituicaoEsperada, urukhai.getConstituicao());
    }

}
