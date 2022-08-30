import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Questao02 {
    public static void main(String[] args) throws IOException {
        InputStream is;
        Scanner sc;
        PrintStream ps;

        if (args.length < 3) {
            System.err.println("Sem argumentos");
            System.out.println("É necessário passar três argumentos.");
        } else {

            // Leitura do arquivo de destino.
            ps = new PrintStream(args[2]);

            for (int i = 0; i < (args.length - 1); i++) {

                // Leitura do arquivo de origem.
                is = new FileInputStream(args[i]);
                sc = new Scanner(is);

                while (sc.hasNextLine()) {
                    ps.println(sc.nextLine());
                }

                is.close();
            }
            ps.close();
        }
    }
}