import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Questao01 {
    public static void main(String[] args) throws IOException {
        String caminho;
        int tam = 3;
        String[] valores = new String[tam];
        InputStream is;
        InputStreamReader isr;
        BufferedReader br;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < tam; i++) {
            valores[i] = sc.nextLine();
        }

        if (valores[0].equals("")) {
            System.out.println("Cadê o caminho?");
            return;
        }

        if (valores[1].equals("")) {

        }

        if (valores[2].equals("")) {

        }

        is = new FileInputStream(valores[0]);
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);

        // n1 = Integer.parseInt(temp);

    }
}