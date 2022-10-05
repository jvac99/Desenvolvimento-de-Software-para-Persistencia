package br.ufc.qxd;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import br.ufc.qxd.connection.ConnectionFactory;
import br.ufc.qxd.dao.AlunoDAO;
import br.ufc.qxd.model.Aluno;

public class App {
    public static void main(String[] args) {
        int id;
        int key;
        String nome;
        String cpf;
        String telefone;
        String matricula;
        InputStream is = System.in;
        Scanner scanner = new Scanner(is);
        ConnectionFactory factory = new ConnectionFactory();
        Aluno aluno;
        List<Aluno> alunos;
        AlunoDAO alunoDAO = new AlunoDAO();

        do {
            System.out.println("----------------------------------");
            System.out.println("Cadastro de alunos");
            System.out.println("----------------------------------");
            System.out.println("0 para sair");
            System.out.println("1 para adicionar um novo aluno");
            System.out.println("2 para atualizar um aluno");
            System.out.println("3 para selecionar um aluno");
            System.out.println("4 para selecionar todos os alunos");
            System.out.println("5 para deletar");
            System.out.println("----------------------------------");
            System.out.println("Digite qual você deseja: ");
            key = Integer.parseInt(scanner.nextLine());

            switch (key) {
                case 0:
                    break;
                case 1:
                    System.out.println("Digite o id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite o nome: ");
                    nome = scanner.nextLine();
                    System.out.println("Digite o cpf: ");
                    cpf = scanner.nextLine();
                    System.out.println("Digite o telefone: ");
                    telefone = scanner.nextLine();
                    System.out.println("Digite a matricula ");
                    matricula = scanner.nextLine();
                    alunoDAO.insertAluno(new Aluno(id, nome, cpf, telefone, matricula));
                    break;
                case 2:
                    System.out.println("Digite o id do aluno que você deseja atualizar: ");
                    id = Integer.parseInt(scanner.nextLine());
                    aluno = alunoDAO.selectAluno(id);
                    if (aluno != null) {
                        System.out.println("Digite o nome: ");
                        aluno.setNome(scanner.nextLine());
                        System.out.println("Digite o cpf: ");
                        aluno.setCpf(scanner.nextLine());
                        System.out.println("Digite o telefone: ");
                        aluno.setTelefone(scanner.nextLine());
                        System.out.println("Digite a matricula ");
                        aluno.setMatricula(scanner.nextLine());
                        alunoDAO.updateAluno(aluno);
                    }
                    break;
                case 3:
                    System.out.println("Digite o id do aluno que você deseja selecionar: ");
                    id = Integer.parseInt(scanner.nextLine());
                    aluno = alunoDAO.selectAluno(id);
                    System.out.println(aluno);
                    break;
                case 4:
                    alunos = alunoDAO.selectAlunos();
                    for (Aluno aluno_ : alunos) {
                        System.out.println(aluno_);
                    }
                    break;
                case 5:
                    System.out.println("Digite o id do aluno que você deseja deletar: ");
                    id = Integer.parseInt(scanner.nextLine());
                    alunoDAO.deleteAluno(id);
                    break;
                default:
                    System.out.println("Error: número inválido!");
                    break;
            }
        } while (key != 0);
    }
}
