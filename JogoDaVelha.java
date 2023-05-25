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

    public boolean eVencedor(){
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
                    return true;
                }
            }
        }

        if(somaDiagonalD == X*dimensao) {
            return true;
        } else if (somaDiagonalD == O*dimensao){
            return true;
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
                    return true;
                }
            }
        }

        if(somaDiagonalE == X*dimensao) {
            return true;
        } else if (somaDiagonalE == O*dimensao){
            return true;
        }


        return false;
    }
    
    public int vencedor() {
        if (eVencedor(X)){
            return X;
        }
        else if (eVencedor(O)){
            return O;
        } else {
            return 0;
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (tabuleiro[i][j]) {
                    case X: s = s + "X"; break;
                    case O: s = s + "O"; break;
                    case VAZIO: s = s + "0";break;
                }
                if (j<2) {
                    s = s + "|";
                }
            }
            if (i<2) {
                s = s + "\n_____\n"; 
            }
        }
        return s;
    }
}