import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Filme;

public class Serializa {

    public static void main(String[] args) {
        List<Filme> filmes = new ArrayList<Filme>();
        String condition = "nao";
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        String titulo;
        String sinopse;
        String diretor;
        FileOutputStream fos;
        ObjectOutputStream oos;

        do {
            id++;
            System.out.println("Digite o titulo: ");
            titulo = scanner.nextLine();
            System.out.println("Digite a sinopse: ");
            sinopse = scanner.nextLine();
            System.out.println("Digite o diretor: ");
            diretor = scanner.nextLine();
            filmes.add(new Filme(id, titulo, sinopse, diretor));
            System.out.println("Deseja adicionar outro filme? (Digite sim para continuar e nao para sair)");
            condition = scanner.nextLine();
        } while (condition.equals("sim"));

        try {
            fos = new FileOutputStream("arq.txt");
            oos = new ObjectOutputStream(fos);
            for (Filme filme : filmes) {
                oos.writeObject(filme);
                oos.flush();
            }
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
