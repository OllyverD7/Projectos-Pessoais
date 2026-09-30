package S_Vendas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ADM extends Pessoa{
    private static int contador = 0;
    private static final List<ADM> adm = new ArrayList<>();
    Menu menu = new Menu();
    Cliente cliente = new Cliente("jkldjklddds jjkl", "kjkjklsjkl23425", 2000, "jkdf@gmail.com", 30000);
    int id_digitado;
    ADM achado = null;

    private int ID_ADM;

    public ADM(String nome, String senha, int anoNascimento, String email) {
        super(nome, senha, anoNascimento, email);
        contador++;
        this.ID_ADM = contador;
    }

    public static List<ADM> getAdm() {
        return adm;
    }

    public int getID_ADM() {
        return ID_ADM;
    }

    public void setID_ADM(int ID_ADM) {
        this.ID_ADM = ID_ADM;
    }

    public void Verif_ADM() {
        if (adm.isEmpty()) {
            v = 1;
        } else {
            v = 2;
        }
    }

    public void Apresentar_ADM() {
        System.out.println("---------------------------------------------");
        System.out.println("Nome: " + getNome());
        System.out.println("Senha: " + getSenha());
        System.out.println("Ano de Nascimento: " + getAnoNascimento());
        System.out.println("Email: " + getEmail());
        System.out.println("ID: " + getID_ADM());
        if (getEstado() == 1) {
            System.out.println("Estado: Bloqueada!");
        } else {
            System.out.println("Estado: Desbloqueada!");
        }
        System.out.println("---------------------------------------------\n");
    }

    public void Dados_Cadastro_ADM() {

        do {
            System.out.print("Nome: ");
            setNome(menu.in.nextLine());
        } while (repe == 1);

        do {
            System.out.print("Senha: ");
            setSenha(menu.in.next());
        } while (repe == 1);

        do {
            System.out.print("Ano Nascimento: ");
            try {
                setAnoNascimento(menu.in.nextInt());
            }catch (InputMismatchException erroIn){
                System.out.println("Por favor, digite um valor válido para data!");
                erroIn.getStackTrace();
                menu.in.next();
                repe = 1;
            }
        } while (repe == 1);

        do {
            System.out.print("Email: ");
            setEmail(menu.in.next());
        } while (repe == 1);
    }

    public void Add_ADM() {

        System.out.println("------------------- ADICIONAR ADMINISTRADOR ----------------------");
        System.out.println("Por favor, digite as informações abaixo");

        Dados_Cadastro_ADM();

        ADM novo_adm = new ADM(getNome(), getSenha(), getAnoNascimento(), getEmail());
        adm.add(novo_adm);
        System.out.println("Seu ID: " + novo_adm.getID_ADM());
        System.out.println("Administrador adicionado com sucesso!");

    }

    //------------------------- PARTE DO ADM ---------------------------

    public void Acessar_ADM() {
        System.out.println("------------------- ACESSAR ADMINISTRADOR ----------------------");
        System.out.println("Digite o ID do Administrador.");

        do {
            do {
                System.out.print("ID> ");
                try {
                    id_digitado = menu.in.nextInt();
                }catch (InputMismatchException erroIn){
                    erroIn.getStackTrace();
                    menu.in.next();
                }
            } while (repe == 1);

            for (ADM ad : ADM.getAdm()) {
                if (ad.getID_ADM() == id_digitado) {
                    achado = ad;
                    break;
                }

                if (achado == null) {
                    System.out.println("Administrador não encontrado!");
                    repe = 1;
                } else {
                    System.out.println("---------------------------- ADM -------------------------");
                    System.out.println("Administrador acessado com sucesso!");
                    achado.Apresentar_ADM();
                    break;
                }
            }
        } while (repe == 1);
    }

    public void Remover_ADM() {

        System.out.println("------------------- REMOVER ADMINISTRADOR ----------------------");
        System.out.println("Digite o ID do Administrador");

        do {
            System.out.print("ID> ");
            try {
                id_digitado = menu.in.nextInt();
            }catch (InputMismatchException erroIn){
                erroIn.getStackTrace();
                menu.in.next();
            }
        } while (repe == 1);

        for (ADM ad : ADM.getAdm()) {
            if (id_digitado == ad.getID_ADM()) {
                achado = ad;
                achado.Apresentar_ADM();
                break;
            }
        }
        if (achado == null) {
            System.out.println("ID não associado à nenhum administrador");
        } else {
            menu.Menu_Certeza();
            if (menu.escolha == 1) {
                ADM.getAdm().remove(achado);
                System.out.println("Administrador Eliminado!");
            } else {
                System.out.println("Operação cancelada!");
            }
        }
    }

    public void Listar_ADM() {
        System.out.println("------------------- LISTAR ADMINISTRADOR ----------------------");

        System.out.println("Adminitradores: " + ADM.getAdm().size());
        System.out.println("\n");

        Verif_ADM();
        if (v == 1) {
            System.out.println("Não há administrador no sistema, por favor, adicione um.");
        } else {
            for (ADM ad : ADM.getAdm()) {
                ad.Apresentar_ADM();
            }
        }
    }

    public void Editar_ADM() {
        System.out.println("------------------- EDITAR ADMINISTRADOR ----------------------");
        System.out.println("Por favor, digite o ID do Adminstrador que deseja editar.");

        System.out.print("ID> ");
        try {
            id_digitado = menu.in.nextInt();
        }catch (InputMismatchException erroIn){
            erroIn.getStackTrace();
            menu.in.next();
        }

        for (ADM ad : ADM.getAdm()) {
            if (ad.getID_ADM() == id_digitado) {
                achado = ad;
                break;
            }
        }
        if (achado == null) {
            System.out.println("Administrador não encontrado!");
        } else {
            System.out.println();
            achado.Apresentar_ADM();
            achado.Dados_Cadastro_ADM();
        }
    }


    //------------------------- PARTE DO CLIENTE ---------------------------
    public void Listar_Cliente() {
        System.out.println("------------------------- CLIENTES ---------------------------");

        cliente.Verif_Cliente();
        if (cliente.v == 1) {
            System.out.println("Não há clientes no sistema!.");
        } else {
            for (Cliente cl : Cliente.getCliente()) {
                cl.Apresentar_Cliente();
                System.out.println("----------------------------------------\n");
            }
        }
    }


    public void Bloquear_Desbloquear(){
        Cliente achado = null;

        cliente.Verif_Cliente();
        if (cliente.v == 1){
            System.out.println("Não há clientes no sistema!");
        }else {
            System.out.println("------------------------- BLOQUEAR/DESBLOQUEAR ---------------------------");
            System.out.println("Por favor, digite o ID do clinte.");
            System.out.print("ID> ");
            try {
                id_digitado = menu.in.nextInt();
            }catch (InputMismatchException erroIn){
                erroIn.getStackTrace();
                menu.in.next();
            }

            for (Cliente cl : Cliente.getCliente()) {
                if (cl.getID_Cliente() == id_digitado) {
                    achado = cl;
                    break;
                }
            }

            if (achado == null){
                System.out.println("Cliente não encontrado!");
            }else {
                achado.Infor_Cliente();
                menu.Menu_Bloq();
                if (menu.escolha == 1){
                    achado.setEstado(1);
                    System.out.println("Cliente Bloqueado!");
                } else if (menu.escolha == 2) {
                    achado.setEstado(2);
                    System.out.println("Cliente Desbloqueado!");
                }else {
                    System.out.println("Por favor, digite um valor válido!");
                    menu.escolha = 3;
                }
            }

        }

    }


    public void Remover_Cliente() {
        Cliente achado = null;

        cliente.Verif_Cliente();
        if (cliente.v == 1){
            System.out.println("Não há clientes no sistema!");
        }else{
            System.out.println("------------------------- REMOVER CLIENTE ---------------------------");

            System.out.println("Por favor, digite o ID do clinte.");
            System.out.print("ID> ");
            try {
                id_digitado = menu.in.nextInt();
            }catch (InputMismatchException erroIn){
                erroIn.getStackTrace();
                menu.in.next();
            }

            for (Cliente cl : Cliente.getCliente()) {
                if (cl.getID_Cliente() == id_digitado) {
                    achado = cl;
                    break;
                }
            }

            if (achado == null) {
                System.out.println("Cliente não encontrado!");
            } else {
                achado.Apresentar_Cliente();
                menu.Menu_Certeza();
                if (menu.escolha == 1) {
                    Cliente.getCliente().remove(achado);
                    System.out.println("Cliente Removido!");
                } else {
                    System.out.println("Operação cancelada!");
                }
            }

        }
    }
}
