import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Questao01 {
    public static void main(String[] args) throws IOException {
        InputStream is;
        Scanner sc;
        String line;
        String original;
        String s;

        if (args.length < 2) {
            System.err.println("Sem argumentos");
            System.out.println("É necessário passar dois argumentos: o nome do arquivo texto e uma string s.");
        } else {
            // Leitura do arquivo de origem.
            is = new FileInputStream(args[0]);
            sc = new Scanner(is);

            s = (args[1]).toLowerCase();

            while (sc.hasNextLine()) {
                original = sc.nextLine();
                line = (original).toLowerCase();
                if (line.contains(s)) {
                    System.out.println(original);
                }
            }
            is.close();
        }
    }
}