package br.com.zup;

import java.util.Scanner;

public class Sistema {

    private static Scanner capturarDados(String menssagem) {
        System.out.println(menssagem);
        return new Scanner(System.in);
    }


    //Menus
    private static void menu() {
        System.out.println("\nBem vinde à nossa auto escola" +
                "\nDigite 1 para gerênciar os funcionários." +
                "\nDigite 2 para gerênciar os alunos." +
                "\nDigite 3 para gerênciar a frota de veículos." +
                "\nDigite 4 para sair.");
    }

    private static void menuAluno() {
        System.out.println("\nSelecione qual função você deseja realizar: " +
                "\n1 - Para cadastrar um novo aluno." +
                "\n2 - Para remover um aluno cadastrado." +
                "\n3 - Para exibir a lista de alunos cadastrados" +
                "\n4 - Para voltar ao menu inicial.");
    }

    private static void menuFuncionario() {
        System.out.println("\nSelecione qual função você deseja realizar: " +
                "\n1 - Para cadastrar um novo funcionário." +
                "\n2 - Para remover um funcionário." +
                "\n3 - Para exibir a lista de funcionários cadastrados." +
                "\n4 - Para voltar ao menu inicial.");
    }

    private static void menuVeiculo() {
        System.out.println("\nSelecione qual função você deseja realizar: " +
                "\n1 - Para cadastrar um novo veiculo." +
                "\n2 - Para remover um veículo." +
                "\n3 - Para exibir a lista de veículos cadastrados" +
                "\n4 - Para voltar ao menu inicial.");
    }


    //Método Funcionarios
    public static Funcionario cadastrarFuncionario() {

        String nome = capturarDados("Digite o nome do funcionário: ").nextLine();
        String cpf = capturarDados("Digite o cpf do funcionário: ").nextLine();
        int idade = capturarDados("Digite a idade do funcionário: ").nextInt();
        String telefone = capturarDados("Digite o telefone do funcionário: ").nextLine();
        String endereco = capturarDados("Digite o endereço do funcionário: ").nextLine();
        String funcao = capturarDados("Digite a função do funcionário: ").nextLine();

        Funcionario funcionario = new Funcionario(nome, cpf, idade, telefone, endereco, funcao);
        return funcionario;

    }


    //Método Alunos
    public static Aluno cadastrarAluno() {

        String nome = capturarDados("Digite o nome do Aluno: ").nextLine();
        String cpf = capturarDados("Digite o CPF do Aluno: ").nextLine();
        int idade = capturarDados("Digite a idade do Aluno: ").nextInt();
        String telefone = capturarDados("Digite o telefone do Aluno: ").nextLine();
        String endereco = capturarDados("Digite o endereço do Aluno: ").nextLine();
        String categoria = capturarDados("Digite a categoria desejada do Aluno: ").nextLine();

        Aluno aluno = new Aluno(nome, cpf, idade, telefone, endereco, categoria);
        return aluno;

    }


    //Método Veiculos
    public static Veiculo cadastrarVeiculo(){

        String tipo = capturarDados("Digite qual o tipo do veiculo: ").nextLine();
        String marca = capturarDados("Digite a marca do veículo: ").nextLine();
        String modelo = capturarDados("Digite o modelo do veículo: ").nextLine();
        String ano = capturarDados("Digite o ano do veículo: ").nextLine();
        String placa = capturarDados("Digite a placa do veículo: ").nextLine();

        Veiculo veiculo = new Veiculo(tipo,marca,modelo,ano,placa);
        return veiculo;

    }


    //Execução
    public static void executar() {

        AutoEscola autoEscola = new AutoEscola("Pé No Freio", "Esquina da 25 Março", "40028922");

        boolean loop = true;


        while (loop) {

            menu();

            boolean loopFuncionario = true;
            boolean loopAluno = true;
            boolean loopFrota = true;

            int opcao = capturarDados("Digite a opção desejada:").nextInt();

            if (opcao == 1) {

                while (loopFuncionario) {

                    menuFuncionario();
                    int opcaoFuncionario = capturarDados("Digite a opção desejada: ").nextInt();

                    if (opcaoFuncionario == 1) {
                        Funcionario funcionario = cadastrarFuncionario();
                        autoEscola.adicionarFuncionario(funcionario);

                    } else if (opcaoFuncionario == 2) {
                        autoEscola.removerFuncionario(capturarDados("Digite o cpf do funcionário a ser removido").nextLine());

                    } else if (opcaoFuncionario == 3) {
                        autoEscola.exibirListaFuncionario();

                    } else if (opcaoFuncionario == 4) {
                        loopFuncionario = false;

                    } else {
                        System.out.println("Opção selecionada inválida, digite novamente!");
                    }

                }

            } else if (opcao == 2) {

                while (loopAluno) {

                    menuAluno();
                    int opcaoAluno = capturarDados("Digite a opção desejada: ").nextInt();

                    if (opcaoAluno == 1) {
                        Aluno aluno = cadastrarAluno();
                        autoEscola.adicionarAlunos(aluno);

                    } else if (opcaoAluno == 2) {
                        autoEscola.removerAluno(capturarDados("Digite o cpf do aluno  a ser removido").nextLine());

                    } else if (opcaoAluno == 3) {
                        autoEscola.exibirListaAlunos();

                    } else if (opcaoAluno == 4) {
                        loopAluno = false;

                    } else {
                        System.out.println("Opção selecionada inválida, digite novamente!");
                    }

                }

            } else if (opcao == 3) {

                while (loopFrota) {

                    menuVeiculo();
                    int opcaoFrota = capturarDados("Digite a opção desejada: ").nextInt();

                    if (opcaoFrota == 1) {
                        Veiculo veiculo = cadastrarVeiculo();
                        autoEscola.adicionarVeiculo(veiculo);

                    } else if (opcaoFrota == 2) {
                        autoEscola.removerVeiculo(capturarDados("Digite a placa do veículo  a ser removido").nextLine());

                    } else if (opcaoFrota == 3) {
                        autoEscola.exibirListaVeiculos();

                    } else if (opcaoFrota == 4) {
                        loopFrota = false;

                    } else {
                        System.out.println("Opção selecionada inválida, digite novamente!");
                    }

                }

            }else if (opcao == 4){
                loop = false;
                System.out.println("Até a proxima!");
            }
            else {
                System.out.println("Opção selecionada inválida, digite novamente!");
            }

        }

    }

}