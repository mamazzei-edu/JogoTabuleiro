public class TesteJogoDaVelha {
    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha(3);
        jogo.poePeca(0, 0);
        jogo.poePeca(1, 1);
        System.out.println(jogo);

        JogoDaVelha jogo2 = new JogoDaVelha(10);
        jogo2.poePeca(0, 0);
        jogo2.poePeca(1, 1);
        System.out.println(jogo2);

    }
}
