package S_Vendas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Users extends Pessoa{
    private int ID;
    private int contador = 0;
    private int type;
    private int permissoes;
    private String accao;
    static final List<Users> users = new ArrayList<>();

    Users(String nome, int ano_nascimento, int mes_nascimeto, int dia_nascimento, String senha, String telefone, String email, int type) {
        super(nome, ano_nascimento, mes_nascimeto, dia_nascimento, senha, telefone, email);
        this.type = type;
        contador++;
        this.ID = contador;
        this.accao = accao;
    }

    public int getID() {
        return ID;
    }

    public int getType() {
        return type;
    }

    public int getPermissoes() {
        return permissoes;
    }

    public String getAccao() {
        return accao;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPermissoes(int permissoes) {
        this.permissoes = permissoes;
    }

    public void setType(int type) {
        if (type == 1){
            this.type = type;
            System.out.println("ADM");
        } else if (type == 2) {
            this.type = type;
            System.out.println("Secundário");
        }else {
            this.type = type;
            System.out.println("Analista");
        }
    }

    public void Veri_Type(){
        if (getType() == 1){
            System.out.println("INSERIR (user), ADICIONAR (categoria, produto e user), REMOVER * 3, LISTAR(user, clientes e produtos), ACTUALIZAR");
        } else if (getType() == 2){
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
                setType(scanner.in.nextInt());
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
        InsertDados_User();
        Users novo_user = new Users(getNome(), getAno_nascimento(), getMes_nascimeto(), getDia_nascimento(),getSenha(), getTelefone(), getEmail(), getType());
        users.add(novo_user);
    }

    public void Remove_Users(){
        setPermissoes(1);
        Users user_encontrado;
        System.out.print("ID> ");
        int id = scanner.in.nextInt();

        for (Users user : Users.users){
            if (id == user.getID()){
                user_encontrado = user;
                user_encontrado.Apresentar();
            }
        }

    }

    public void Listar_Users(){
        setPermissoes(1);
        for (Users user : Users.users){
            user.Apresentar();
        }
    }
}
