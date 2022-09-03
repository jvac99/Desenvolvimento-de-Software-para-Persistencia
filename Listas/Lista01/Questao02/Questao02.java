import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Questao02 {
    public static void main(String[] args) throws IOException {
        String origem;
        String destino;
        String linha;
        InputStream is;
        InputStreamReader isr;
        BufferedReader br;
        BufferedWriter bw;
        OutputStream os;
        OutputStreamWriter osw;

        if (args.length < 2) {
            System.err.println("Sem argumentos");
            System.out.println("É necessário passar dois argumentos: origem e destino.");
        } else {
            origem = args[0];
            destino = args[1];
            // Leitura do arquivo de origem.
            is = new FileInputStream(origem);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            // Leitura do arquivo de destino.
            os = new FileOutputStream(destino);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            while ((linha = br.readLine()) != null) {
                bw.write(linha);
                bw.newLine();
                /*
                 * O bw só vai escrever no arquivo quando ele dar o flush, isso geralmente
                 * ocorre automaticamente quando ele enche o seu buffer, ou seja, se voce
                 * colocar uma mensagem pequena, é possível que o flush não esteja ocorrendo.
                 */
                bw.flush();
            }

            is.close();
            os.close();
        }
    }
}