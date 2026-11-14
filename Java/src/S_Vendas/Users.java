package S_Vendas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Users extends Pessoa{
    private static int contador = 0;
    private final int ID;
    private String type;
    private int permissoes;
    static final List<Users> users = new ArrayList<>();
    private int escolha_tipo;
    private int escolha_accao;
    private String accao;
    private LocalDate Data = LocalDate.now();
    private LocalTime Hora = LocalTime.now();

    DateTimeFormatter data_formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    DateTimeFormatter hora_formato = DateTimeFormatter.ofPattern("HH:mm:ss");

    Menus menu = new Menus();

    Users(String nome, int ano_nascimento, int mes_nascimeto, int dia_nascimento, String senha, String telefone, String email, String type) {
        super(nome, ano_nascimento, mes_nascimeto, dia_nascimento, senha, telefone, email);
        this.type = type;
        contador++;
        this.ID = contador;
    }

    public int getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public int getPermissoes() {
        return permissoes;
    }

    public int getEscolha_tipo() {
        return escolha_tipo;
    }

    public int getEscolha_accao() {
        return escolha_accao;
    }
    public LocalTime getHora() {
        return Hora;
    }
    public LocalDate getData() {
        return Data;
    }


    public String getAccao() {
        return accao;
    }

    public void setPermissoes(int permissoes) {
        if (permissoes == 1){
            this.permissoes = permissoes;

        } else if (permissoes == 2) {
            this.permissoes = permissoes;

        }else {
            this.permissoes = permissoes;
        }
    }

    public void setEscolha_tipo(int escolha_tipo) {
        if (escolha_tipo == 1){
            this.type = "ADM";
        } else if (escolha_tipo == 2) {
            this.type = "Secundário";
        }else {
            this.type = "Analista";
        }
    }

    public void setEscolha_accao(int escolha_accao) {
        if (escolha_accao == 1){
            this.accao = "ADICIONOU";

        } else if (escolha_accao == 2) {
            this.accao = "REMOVEU";

        } else if (escolha_accao == 3) {
            this.accao = "ACTUALIZOU";

        } else if (escolha_accao == 4) {
            this.accao = "BLOQUEOU";

        }else {
            this.accao = "DESBLOQUEOU";
        }
    }

    public void setData(LocalDate data) {
        Data = data;
    }

    public void setHora(LocalTime hora) {
        Hora = hora;
    }



    public void Veri_Type(){
        if (getType().equals("ADM")){
            System.out.println("ADICIONAR (categoria, produto e user), REMOVER * 3, LISTAR(user, clientes e produtos), ACTUALIZAR");
        } else if (getType().equals("Secundário")){
            System.out.println("LISTAR (produto e cliente) , ANALISAR (cliente e produto), BLOQ/DESBLOQ (cliente e produto)");
        }else {
            System.out.println("ANALISAR (produto e cliente)");
        }
    }

    public void InsertDados_User(){
        InsertDados_Pessoa();
        do {
            System.out.println("Tipo de Utilizador:");
            System.out.println("1 - ADM");
            System.out.println("2 - Secundário");
            System.out.println("3 - Analista");
            System.out.print("[R]: ");
            try {
                setEscolha_tipo(scanner.in.nextInt());
            }catch (InputMismatchException e){
                System.out.println("Por favor, digite números!");
                repe = 1;
            }
        }while(repe == 1);
    }

    @Override
    public void Apresentar(){
        System.out.println("\n*********************************************");
        System.out.println("Nome: " + getNome());
        System.out.println("Senha: " + getSenha());
        System.out.println("Data de Nascimento: " + getAno_nascimento() + "/" + getMes_nascimeto() + "/" + getDia_nascimento());
        Idade();
        System.out.println("Idade: " + getIdade());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Email: " + getEmail());
        System.out.println("Estado: " + getEstado());
        System.out.println("Estado de Entrada: " + getEstadoEntrada());
        System.out.println("Tipo de User: " + this.type);
        System.out.println("ID: " + this.ID);
        System.out.println("*********************************************");
    }
    // PARTE DOS USERS

    public void Add_Users(){
        setPermissoes(1);
        setData(LocalDate.now());

        InsertDados_User();
        Users novo_user = new Users(getNome(), getAno_nascimento(), getMes_nascimeto(), getDia_nascimento(),getSenha(), getTelefone(), getEmail(), getType());
        users.add(novo_user);
        setEscolha_accao(1);
    }

    public void Remove_Users(){
        setPermissoes(1);
        setData(LocalDate.now());

        Users user_encontrado = null;
        System.out.print("ID> ");
        int id = scanner.in.nextInt();

        for (Users user : Users.users){
            if (id == user.getID()){
                user_encontrado = user;
                user_encontrado.Apresentar();
            }
        }
        menu.conf_Eliminar();
        if (menu.escolha == 1){
            users.remove(user_encontrado);
            setEscolha_accao(2);
            System.out.println("User eliminado!");

        }else{
            System.out.println("Operação cancelada!");
        }
    }

    public void Listar_Users(){
        setPermissoes(1);
        for (Users user : Users.users){
            user.Apresentar();
        }
    }
}
