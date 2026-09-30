package S_Vendas;

import java.util.InputMismatchException;

public class Login {
    Pessoa pessoa  = new Pessoa("oli", "jka1sdsfsdfdfsd", 2000, "Oli@gmail.com");
    Cliente cli = new Cliente("jkldjklddds jjkl", "kjkjklsjkl23425", 2000, "jkdf@gmail.com", 30000);
    Menu menu = new Menu();
    int  tentativas = 3;
    String senha_Digitada;
    int id_digitado;

    public void Logins(){
        menu.Menu_Login();
        if (menu.escolha == 1){
            Cliente achado;

            System.out.println("------------------- CLIENTE LOGIN -------------------");
            do {
                achado = null;
                System.out.print("ID> ");
                id_digitado = menu.in.nextInt();

                for (Cliente cl : Cliente.getCliente()){
                    if (id_digitado == cl.getID_Cliente()){
                        achado = cl;
                        break;
                    }
                }

                if (achado == null){
                    System.out.println("Identificador não associado à nenhuma conta!");

                } else if (achado.getEstado() == 1){
                    System.out.println("Conta bloqueada temporariamente, por favor, tente mais tarde.");
                    //System.out.println("Tempo restante: " + achado.getTempo_restante());
                    break;
                }else {

                    do {
                        System.out.print("Senha> ");
                        senha_Digitada = menu.in.next();
                    } while (pessoa.repe == 1);

                    if (achado.getSenha().equals(senha_Digitada)){
                        achado.setAgora(System.currentTimeMillis());
                        achado.setTempo_restante(achado.getAgora() - achado.getInicio_do_bloqueio());
                        if (achado.getTempo_restante() >= achado.getTempo_Bloqueado()){
                            System.out.println("Login feito com sucesso!");
                            System.out.println("Seja bem-vindo sr(a) " + achado.getNome());
                            System.out.println("Saldo actual: " + achado.getSaldo());
                            menu.Menu_Cliente_Logado();
                            if (menu.escolha == 2) {
                                achado.Infor_Cliente();
                            }
                            tentativas = -1;
                        }
                    }else {
                        tentativas--;
                        System.out.println("ID ou Senha inválida!\n");
                        System.out.println("tentativas: " + tentativas);

                        if (tentativas == 0) {
                            achado.setEstado(1);
                            achado.setInicio_do_bloqueio(System.currentTimeMillis());
                            System.out.println("Conta bloqueada!");
                        }
                    }
                }

            }while(tentativas > 0);


        } else if (menu.escolha == 2) {
            ADM achado;
            System.out.println("------------------- ADM LOGIN -------------------------");

            do {
                achado = null;
                System.out.print("ID> ");
                id_digitado = menu.in.nextInt();

                for (ADM adm : ADM.getAdm()){
                    if (adm.getID_ADM() == id_digitado){
                        achado = adm;
                        break;
                    }
                }

                if (achado == null){
                    System.out.println("Administrador não identificado!");

                }else if (achado.getEstado() == 1){
                    System.out.println("Conta bloqueada temporariamente, por favor, tente mais tarde.");

                }else {
                    do {
                        System.out.print("Senha> ");
                        senha_Digitada = menu.in.next();
                    }while (pessoa.repe == 1);

                    if (achado.getSenha().equals(senha_Digitada)){
                        System.out.println("Login feito com sucesso!");
                        System.out.println("-------------- Seja bem-vindo(a) " + achado.getNome() + " ---------------------------");
                        menu.Menu_ADM_Escolha();
                        if (menu.escolha == 4) {
                            achado.Apresentar_ADM();
                        }
                        tentativas = -1;
                    }else {
                        tentativas--;
                        System.out.println("ID ou senha inválidas!");
                        System.out.println("tentativas: " + tentativas);
                        if (tentativas == 0) {
                            achado.setEstado(1);
                            System.out.println("Conta bloqueada! Por favor, tente mais tarde.");
                        }
                    }
                }
            }while (tentativas > 0);

        }else {
            System.out.println("Digite um valor válido!");
            pessoa.repe = 1;
        }
    }

//-------------------------------------------- CLIENTE -------------------------------------------------------------------------

    public void Login_Cliente(){
        cli.Verif_Cliente();
        if (cli.v == 1){
            System.out.println("Ainda não há clientes no programa, por favor, cadastre-se primeiro. ");
            menu.Menu_Add();
            if (menu.escolha == 1){
                System.out.println("Será reencaminhado à página anterior para se cadastrar.");
                cli.repe = 2;
            }else if (menu.escolha == 2){
                cli.repe = 2;
            }else {
                System.out.println("Por favor, digite um número válido!");
            }

        } else {
            Cliente achado;
            System.out.println("------------------- CLIENTE LOGIN -------------------");

            do {
                achado = null;
                System.out.print("ID> ");
                try {
                    id_digitado = menu.in.nextInt();
                }catch (InputMismatchException erroIn){
                    System.out.println("Por favor, digite um número válido!");
                    menu.in.next();
                }


                for (Cliente cliente : Cliente.getCliente()){
                    if (cliente.getID_Cliente() == id_digitado){
                        achado = cliente;
                        break;
                    }
                }
                if (achado == null){
                    System.out.println("Identificador não está associado à nenhuma conta!");
                } else if (achado.getEstado() == 1) {
                    System.out.println("Conta bloqueada temporáriamente");
                }

                if (achado != null){
                    System.out.print("Senha> ");
                    senha_Digitada = menu.in.next();

                    if (achado.getSenha().equals(senha_Digitada)){
                        tentativas = -1;
                        System.out.println("Login feito com sucesso!");

                        do {
                            System.out.println("-------------------------- BEM-VINDO " + achado.getNome() + " -------------------------------");
                            System.out.println("Saldo actual: " + achado.getSaldo() + "kz");
                            menu.Menu_Cliente_Logado();
                            if (menu.escolha == 1) {
                                System.out.println("Aqui vai ver os produtos...");
                                cli.repe = 3;

                            } else if (menu.escolha == 2) {
                                achado.Infor_Cliente();
                                cli.repe = 3;

                            } else if (menu.escolha == 3) {
                                System.out.println("Saldo actual: " + achado.getSaldo());
                                achado.P_Saldo();
                                cli.repe = 3;

                            } else if (menu.escolha == 4) {
                                cli.repe = 2;

                            } else {
                                System.out.println("Por favor, digite um valor válido");
                                cli.repe = 3;
                            }
                        } while (cli.repe == 3);

                    }else {
                        tentativas--;
                        System.out.println("Senha inválida!\n");
                        System.out.println("tentativas: " + tentativas);

                        if (tentativas == 0) {
                            achado.setEstado(1);
                            System.out.println("Conta bloqueada!");
                        }
                    }
                }

            }while(tentativas > 0);

        }
    }

    //------------------------------------ ADMINISTRADOR ------------------------------------

    public void Login_ADM(){
        ADM achado;
        System.out.println("------------------- ADM LOGIN -------------------------");
        System.out.println("Por favor, faça o login preenchendo com seus dados.");

        do {
            achado = null;
            System.out.print("ID> ");
            try {
                id_digitado = menu.in.nextInt();
            }catch (InputMismatchException erroIn){
                System.out.println("Por favor, digite um número válido!");
                erroIn.getStackTrace();
                menu.in.next();
            }

            for (ADM adm : ADM.getAdm()){
                if (adm.getID_ADM() == id_digitado){
                    achado = adm;
                    break;
                }
            }

            if (achado == null){
                    System.out.println("Administrador não identificado!");
            }else if (achado.getEstado() == 1){
                System.out.println("Conta bloqueada temporariamente, por favor, tente mais tarde.");
            }else {
                do {
                    System.out.print("Senha> ");
                    senha_Digitada = menu.in.next();
                }while (pessoa.repe == 1);

                if (achado.getSenha().equals(senha_Digitada)){
                    System.out.println("Login feito com sucesso!\n");
                    System.out.println("-------------- Seja bem-vindo(a) " + achado.getNome() + " ---------------------------");
                    menu.Menu_ADM_Escolha();
                    if (menu.escolha == 4) {
                        achado.Apresentar_ADM();
                    }
                    tentativas = -1;
                }else {
                    tentativas--;
                    System.out.println("ID ou senha inválidas!");
                    System.out.println("tentativas: " + tentativas + "\n");
                    if (tentativas == 0) {
                        achado.setEstado(1);
                        System.out.println("Conta bloqueada! Por favor, tente mais tarde.");
                    }
                }
            }
        }while (tentativas > 0);
    }
}
