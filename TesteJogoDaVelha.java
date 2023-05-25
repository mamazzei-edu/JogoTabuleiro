public class TesteJogoDaVelha {
    public static void main(String[] args) {
        /* 
        JogoDaVelha jogo = new JogoDaVelha(3);
        jogo.poePeca(0, 0);
        jogo.poePeca(1, 1);
        System.out.println(jogo.temVencedor());
        jogo.poePeca(0, 1);
        jogo.poePeca(1, 2);
        System.out.println(jogo.temVencedor());
        jogo.poePeca(0, 2);
        jogo.poePeca(2, 2);
        System.out.println(jogo.temVencedor());
        System.out.println(jogo);
        */
        System.out.println("Jogando auto");
        JogoDaVelhaAuto auto = new JogoDaVelhaAuto(3);
        while(auto.jogar() == true) {
            System.out.println(auto);
        }

        /*
        JogoDaVelha jogo2 = new JogoDaVelha(10);
        jogo2.poePeca(0, 0);
        jogo2.poePeca(1, 1);
        System.out.println(jogo2);
        */

    }
}
