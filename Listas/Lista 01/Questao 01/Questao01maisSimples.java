import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Questao01maisSimples {
    public static void main(String[] args) throws IOException {
        String caminho;
        String linha;
        String temp;
        int n1 = 1;
        int n2 = 0;
        InputStream is;
        InputStreamReader isr;
        BufferedReader br;
        Scanner sc = new Scanner(System.in);
        // Leitura.
        caminho = sc.nextLine();

        // Se o caminho não for definido.
        if (caminho.equals("")) {
            System.out.println("Cadê o caminho?");
            return;
        }

        temp = sc.nextLine();

        if (!(temp.equals(""))) {
            try {
                n1 = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("O valor tem que ser inteiro!");
                return;
            }
        }

        temp = sc.nextLine();

        if (!(temp.equals(""))) {
            try {
                n2 = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("O valor tem que ser inteiro!");
                return;
            }
        }

        // Leitura do arquivo.
        is = new FileInputStream(caminho);
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);

        int i = 1;
        while ((linha = br.readLine()) != null) {
            /*
             * Se n2 == 0, significa que o n2 não foi definido, deve-se exibir as linhas do
             * arquivo a partir de n1 até o final do arquivo.
             * 
             * Se n1 não for definido, deve-se exibir as linhas do arquivo a partir da
             * primeira linha até n2.
             */
            if ((i >= n1) && (n2 == 0 || i <= n2))
                System.out.println(linha);
            i++;
        }

        is.close();
    }
}