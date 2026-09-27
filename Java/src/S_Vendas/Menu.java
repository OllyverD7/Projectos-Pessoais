package S_Vendas;

import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    int escolha = 0;

    //------------------------------- MENU De CONFIRMAÇÃO -------------------------------------
    public void Menu_Certeza(){
        do {
            System.out.println("Deseja remover?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();
            if (escolha < 1 || escolha > 2) {
                System.out.println("Por favor, digite um número válido!");
            }
        }while (escolha < 1 || escolha > 2);
    }

    public void Menu_Saldo(){
        do {
            System.out.println("Deseja aumentar?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();
            if (escolha < 1 || escolha > 2)
                System.out.println("Por favor, digite um número válido!");
        }while(escolha < 1 || escolha > 2);
    }

    public void Menu_Add(){
        do {
            System.out.println("Deseja Cadastrar?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();
            if (escolha < 1 || escolha > 2){
                System.out.println("Por favor, digite um número válido!");
            }
        }while (escolha < 1 || escolha > 2);
    }

    public void Menu_Bloq(){
        do {
            System.out.println("O que deseja?");
            System.out.println("1 - Bloquear");
            System.out.println("2 - Desbloquear");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();
            if (escolha < 1 || escolha > 2){
                System.out.println("Por favor, digite um número válido!!");
            }
        }while (escolha < 1 || escolha > 2);
    }

    public void Menu_prod_opcao(){
        do {
            System.out.println("O que deseja?");
            System.out.println("1 - Alterar preço");
            System.out.println("2 - Alterar quantidade");
            System.out.println("3 - Remover");
            System.out.println("4 - Voltar");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();
            if (escolha < 1 || escolha > 2){
                System.out.println("Por favor, digite um número válido!!");
            }
        }while (escolha < 1 || escolha > 2);
    }


    //------------------------------- MENU LOGIN -------------------------------------
    public void Menu_Login(){
        System.out.println("--------------------- PRIMEIRA TELA -----------------------");
        do {
            System.out.println("1 - Cliente");
            System.out.println("2 - Administrador");
            System.out.println("3 - Sair");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();
            if (escolha < 1 || escolha > 3) {
                System.out.println("Por favor, digite um número válido!");
            }
        }while (escolha < 1 || escolha > 3);
    }


    //-------------------------------- MENUS ADM --------------------------------
    public void Menu_ADM_Escolha(){
        System.out.println("----------------- BEM-VINDO ADMINISTRADOR --------------------");
        do {
            System.out.println("1 - Menu Produtos");
            System.out.println("2 - Menu ADM");
            System.out.println("3 - Menu Cliente");
            System.out.println("4 - Minhas informações");
            System.out.println("5 - Sair");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();

            if (escolha < 1 || escolha > 5){
                System.out.println("Por favor, digite um número válido!");
            }
        }while (escolha < 1 || escolha > 5);
    }

    public void Menu_ADM(){
        System.out.println("----------------- TELA DO ADMINISTRADOR --------------------");

        do {
            System.out.println("1 - Adicionar Administrador");
            System.out.println("2 - Listar Administrador");
            System.out.println("3 - Remover Administrador");
            System.out.println("4 - Editar Administrador");
            System.out.println("5 - Voltar");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();

            if (escolha < 1 || escolha > 5){
                System.out.println("Por favor, digite um número válido!");
            }
        }while(escolha < 1 || escolha > 5);
    }



    //---------------------------------- MENUs PRODUTOS ------------------------------------
    public void Menu_Produtos(){
        do {
            System.out.println("----------------- MENU DOS PRODUTOS --------------------");
            System.out.println("1 - Listar todos os produtos");
            System.out.println("2 - Adicionar Produto");
            System.out.println("3 - Remover Produto");
            System.out.println("4 - Acessar Produto");
            System.out.println("5 - Sair");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();

            if (escolha < 1 || escolha > 5){
                System.out.println("Por favor, digite um número válido!");
            }
        }while(escolha < 1 || escolha > 5);
    }


    //---------------------------------- MENUs CLIENTES ----------------------------------
    public void Menu_Cliente(){
        do {
            System.out.println("-------------------------- MENU CLIENTE -------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Login");
            System.out.println("3 - Voltar");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();

            if (escolha < 1 || escolha > 3)
                System.out.println("Por favor, digite um número válido!");
        }while (escolha < 1 || escolha > 3);
    }


    public void Menu_Cliente_Logado(){
        do {
            System.out.println("1 - Ver produtos");
            System.out.println("2 - Minhas informações");
            System.out.println("3 - Meu Saldo");
            System.out.println("4 - Voltar");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();
            if (escolha < 1 || escolha > 4)
                System.out.println("Por favor, digite um número válido!");
        }while (escolha < 1 || escolha > 4);
    }

    public void Menu_ADM_Cliente(){
        do {
            System.out.println("1 - Listar Cliente");
            System.out.println("2 - Remover Cliente");
            System.out.println("3 - Bloquear/desbloquear Cliente");
            System.out.println("4 - Voltar");
            System.out.print("[R]: ");
            escolha = in.nextInt();
            System.out.println();

            if (escolha < 1 || escolha > 4){
                System.out.println("Por favor, digite um número válido!");
            }
        }while(escolha < 1 || escolha > 4);
    }
}
