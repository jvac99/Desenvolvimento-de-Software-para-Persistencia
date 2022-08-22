import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Questao01 {
    public static void main(String[] args) {
        String linha;
        int tam = 3;
        int n1 = 1;
        int n2 = 0;
        String[] valores = new String[tam];
        InputStream is;
        InputStreamReader isr;
        BufferedReader br;
        Scanner sc = new Scanner(System.in);

        // leitura
        for (int i = 0; i < tam; i++) {
            valores[i] = sc.nextLine();
        }

        // Se o caminho não for definido.
        if (valores[0].equals("")) {
            System.out.println("Cadê o caminho ou nome do arquivo?");
            return;
        }

        try {
            is = new FileInputStream(valores[0]);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            if (!(valores[1].equals(""))) {
                try {
                    n1 = Integer.parseInt(valores[1]);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    System.out.println("O valor tem que ser inteiro!");
                    return;
                }
            }

            if (!(valores[2].equals(""))) {
                try {
                    n2 = Integer.parseInt(valores[2]);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    System.out.println("O valor tem que ser inteiro!");
                    return;
                }
            }

            for (int i = 1; (linha = br.readLine()) != null; i++) {
                /*
                 * Se n2 == 0, significa que o n2 não foi definido, deve-se exibir as linhas do
                 * arquivo a partir de n1 até o final do arquivo.
                 * 
                 * Se n1 não for definido, deve-se exibir as linhas do arquivo a partir da
                 * primeira linha até n2.
                 */
                if ((i >= n1) && (n2 == 0 || i <= n2))
                    System.out.println(linha);
            }
            is.close();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}