import java.util.concurrent.ThreadLocalRandom;

public class JogoDaVelhaAuto extends JogoDaVelha {

    public JogoDaVelhaAuto(int dimensao) {
        super(dimensao);
    }

    public boolean jogar() {
        int casasOcupadas = 0;
        int totalCasas = dimensao*dimensao;
        for (int i = 0; i<dimensao;i++) {
            for (int j=0; j< dimensao; j++) {
                casasOcupadas += tabuleiro[i][j]==0?0:1;
            }
        }
        if (casasOcupadas < totalCasas) {
            return poePeca();
        } else{
            if (temVencedor()==0) {
                System.out.println("Não há vencedor");
            } else {
                System.out.println("Vencedor: " + temVencedor());
            }
        }
        return false; 
    }

    public boolean poePeca() {
        boolean colocou = false;
        while (colocou!=true) {
            int i = ThreadLocalRandom.current().nextInt(0,dimensao);
            int j = ThreadLocalRandom.current().nextInt(0,dimensao);
            try {
                super.poePeca(i, j);
                colocou = true;
            } catch (Exception e) {
                System.out.println("Tentando com outro valor pois i=" + i + " e j=" + j + " já estão ocupados");
                colocou=false;
            }
        }
        return colocou;
    }


}
