public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int tabuleiro[][]; // = new int[3][3];
    protected int jogador;
    protected int dimensao;

    public JogoDaVelha(int dimensao) { 
        this.dimensao = dimensao;
        tabuleiro = new int[dimensao][dimensao];
        limpaTabuleiro();
    }

    public void limpaTabuleiro() {
        for (int i=0; i<dimensao;i++){
            for (int j=0;j<dimensao;j++){
                tabuleiro[i][j]=VAZIO;
            }
        }
        jogador = X;
    }

    public void poePeca(int i, int j){
        if (i < 0 || i > dimensao-1 || j < 0 || j > dimensao-1) {
            throw new IllegalArgumentException("Posição inválida");
        }
        if ( tabuleiro[i][j] != VAZIO ) {
            throw new IllegalArgumentException("Posição já utilizada");
        }
        tabuleiro[i][j]=jogador;
        jogador = -jogador;

    }

    public int temVencedor(){
        int somaDiagonalD=0;
        for (int linha = 0; linha < dimensao;linha++) {
            int soma_linha = 0;
            for(int coluna = 0; coluna<dimensao;coluna++){
                soma_linha = soma_linha + tabuleiro[linha][coluna];
                int marca = soma_linha == X*dimensao?X:soma_linha==O*dimensao?O:0;
                if(linha == coluna){
                    somaDiagonalD = somaDiagonalD + tabuleiro[linha][coluna];
                }
                if(marca!=0){
                    return marca;
                }
            }
        }

        if(somaDiagonalD == X*dimensao) {
            return X;
        } else if (somaDiagonalD == O*dimensao){
            return O;
        }

        int somaDiagonalE = 0;
        for (int coluna = 0; coluna < dimensao;coluna++) {
            int soma_coluna = 0;
            for(int linha = 0; linha<dimensao;linha++){
                soma_coluna = soma_coluna + tabuleiro[linha][coluna];
                int marca = soma_coluna == X*dimensao?X:soma_coluna==O*dimensao?O:0;
                if (linha+coluna == dimensao-1){
                    somaDiagonalE = somaDiagonalE + tabuleiro[linha][coluna];
                }
                if(marca!=0){
                    return marca;
                }
            }
        }

        if(somaDiagonalE == X*dimensao) {
            return X;
        } else if (somaDiagonalE == O*dimensao){
            return O;
        }
        return 0;
    }
    

    public String toString() {
        String s = "";
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                switch (tabuleiro[i][j]) {
                    case X: s = s + "X"; break;
                    case O: s = s + "O"; break;
                    case VAZIO: s = s + " ";break;
                }
                if (j<dimensao-1) {
                    s = s + "|";
                }
            }
            if (i<dimensao-1) {
                s = s + "\n_____\n"; 
            }
        }
        return s;
    }
}