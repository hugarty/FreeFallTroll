
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
 TUTORIAL BASICO DA VIDA


 pow = 2^r	pow-1

r0 = 1		r0 = 0
r1 = 2		r1 = 1
r2 = 4		r2 = 3
r3 = 8		r3 = 7
r4 = 16		r4 = 15

R2

contador = -2
i = 5;

if i >= 1

if contador < -1
	cont = 3

if contador > 0 {
	sub =  hamming.charAt(i)
}

conta --;

rr1r234r56789


r3   r56789
r2   r23489 
r1   r13467 
r0   r124579 

*/


/**
 *
 * @author RA21450285
 */
public class HammingGIT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner l = new Scanner(System.in);
        System.out.print("Digite sua mensagem\n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String entrada = in.readLine();

        emissor(entrada);
    }

    public static String emissor(String hamming) {
        int r;
        int[] rs;

        r = descobrirQuantidadeR(hamming.length());
        hamming = adicionaRs(r, hamming);
        rs = valorDeCadaR(r, hamming);
        //mensagemComRedundancia = posicionaRs(hamming, rs);

        return hamming;
    }

    //Descobre a quantidade de R que a mensagem deve ter
    public static int descobrirQuantidadeR(int tamanho) {
        int r = 0;
        do {
            r++;
        } while (Math.pow(2, r) < tamanho + r + 1);
        return r;
    }
    
    
    /* 
        Gira a mensagem para adicionar os Rs na parte de inicial da mensagem
        Cria o Array char addR com tamanho de msg + quantidad de Rs
        Primeiro 'for' Joga a mensagem dentro do Array
        Segundo 'for' adiciona os Rs nas posições deles dentro do Array
        Terceiro 'for' joga os valores do Array dentro da String
    */
    private static String adicionaRs(int r, String hamming) {
        hamming = giraString(hamming);
        char[] addR = new char[hamming.length() + r];
        int cont = 0;
        for (int i = 0; i < hamming.length(); i++) {
            addR[i] = hamming.charAt(i);
        }
        for (int i = 0; i < r; i++) {
            for (int o = 0; o < addR.length; o++) {
                if (o == Math.pow(2, cont) - 1) {
                    //add valor a posição
                    addR = jogaParaFrenteValores(addR, o);
                    addR[o] = 'r';
                    if (cont < r) {
                        cont++;
                    }
                }
            }
        }
        hamming = "";
        for (int i = 0; i < addR.length; i++) {
            hamming += addR[i];
        }
        //hamming = giraString(hamming);
        System.out.println("--------------\nR's foram adicionados: "+hamming+"\n--------------\n");
        return hamming;
    }
    /*
        Cria um Array int 'R' com tamanho da quantidade de r's
        Cria Contador que vai ser usado para pular os negocios
        Cria uma subString auxiliar
        While que vai executar na quantidade de Rs presentes no sistema do maior para o menor
        Inicializa o contador antes do for com a quantidade de casas que ele pula
        For irá passar por todos os elementos da String
        Primeiro if pra definir o primeiro valor da subString;
        Segundo if Verifica se o intervalo de não pega dos itens foi completo
        Terceiro if é para atribuir o valor a substring;
        Depois do for você tem que atribuir o valor do determinado R;
        
        
        TA FUNCIONANDO 
        SÓ CONTAR OS 1 GG
    
    */
    public static int[] valorDeCadaR(int r, String hamming) {
        int[] R = new int[r];
        int contador;
        String subString ="";
        while(r > 0)
        {
            r --;
            contador = (int)Math.pow(2, r);
            for (int i = 0; i < hamming.length(); i++) {
                if(i >= Math.pow(2,r) -1)
                {
                    if(contador < (Math.pow(2, r)-1) * -1)
                    {
                        contador = (int)Math.pow(2, r);
                    }
                    if(contador > 0)
                    {
                        subString += hamming.charAt(i);
                    }
                    contador --;
                }
            }
            System.out.println("R"+r +"   "+subString);
            subString = "";
        }
        
        return R;
    }

    public static int contaUns(String stringAuxiliar) {
        int contador = 0;
        for (int i = 0; i < stringAuxiliar.length(); i++) {
            if ('1' == stringAuxiliar.charAt(i)) {
                contador++;
            }
        }
        System.out.println("\ncontador " + contador + " subString " + stringAuxiliar);
        if (contador % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    private static String giraString(String hamming) {
        int cont = 0;
        String auxiliar = "";
        while (cont < hamming.length()) {
            auxiliar += hamming.charAt(cont);
            cont++;
        }
        hamming = "";
        cont += -1;
        while (cont >= 0) {
            hamming += auxiliar.charAt(cont);
            cont--;
        }
        return hamming;
    }

    private static char[] jogaParaFrenteValores(char[] addR, int o) {
        for (int i = addR.length; i >= o; i--) {
            if (i + 1 < addR.length) {
                addR[i + 1] = addR[i];
            }
        }
        return addR;
    }
}

    
    

