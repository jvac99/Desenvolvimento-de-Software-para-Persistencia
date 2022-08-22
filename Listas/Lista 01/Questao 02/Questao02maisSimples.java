import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Questao02maisSimples {
    public static void main(String[] args) throws IOException {
        String origem;
        String destino;
        InputStream is;
        Scanner sc;
        PrintStream ps;

        if (args.length < 2) {
            System.err.println("Sem argumentos");
            System.out.println("É necessário passar dois argumentos: origem e destino.");
        } else {
            origem = args[0];
            destino = args[1];
            // Leitura do arquivo de origem.
            is = new FileInputStream(origem);
            sc = new Scanner(is);
            // Leitura do arquivo de destino.
            ps = new PrintStream(destino);

            while (sc.hasNextLine()) {
                ps.println(sc.nextLine());
            }

            is.close();
            ps.close();
        }
    }
}