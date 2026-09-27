package S_Vendas;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private double saldo;
    private double adic_saldo;
    private int ID_Cliente;
    private long agora;
    private long inicio_do_bloqueio;
    private long tempo_restante;
    private static int contador;
    private static List<Cliente> cliente = new ArrayList<>();
    Menu menu = new Menu();

    public Cliente (String nome, String senha, int anoNascimento, String email, double saldo){
        super(nome, senha, anoNascimento, email);
        contador++;
        this.ID_Cliente = contador;
        this.saldo = saldo;
        this.adic_saldo = adic_saldo;
    }

    public double getAdic_saldo() {
        return adic_saldo;
    }


    public int getID_Cliente() {
        return ID_Cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public static List<Cliente> getCliente() {
        return cliente;
    }

    public long getAgora() {
        return agora;
    }

    public long getInicio_do_bloqueio() {
        return inicio_do_bloqueio;
    }

    public long getTempo_Bloqueado() {
        return 10000;
    }

    public long getTempo_restante() {
        return tempo_restante;
    }

    public void setSaldo(double saldo_Actual) {
        if (saldo_Actual < 0){
            System.out.println("Saldo inicial não pode ser menor que zero!");
            repe = 1;
        }else {
            this.saldo = saldo_Actual;
        }
    }

    public void setAdic_saldo(double adic_saldo) {
        if (adic_saldo <= 0){
            System.out.println("Saldo de acréscimo deve ser maior que zero!");
            repe = 1;
        }else {
            this.adic_saldo = adic_saldo;
        }
    }

    public void setInicio_do_bloqueio(long inicio_do_bloqueio) {
        this.inicio_do_bloqueio = inicio_do_bloqueio;
    }

    public void setAgora(long agora) {
        this.agora = agora;
    }

    public void setTempo_restante(long tempo_restante) {
        this.tempo_restante = tempo_restante;
    }

    public void Apresentar_Cliente(){
        System.out.println("---------------------------------------------------------");
        System.out.println("Nome: " + getNome());
        System.out.println("Ano Nascimento: " + getAnoNascimento());
        System.out.println("Email: " + getEmail());
        System.out.println("Saldo: " + getSaldo() + "kz");
        System.out.println("ID: " + getID_Cliente());
        System.out.println("Senha: ********");
        if (getEstado() == 1){
            System.out.println("Estado: Bloqueada!");
        }else {
            System.out.println("Estado: Desbloqueada!");
        }
        System.out.println("---------------------------------------------------------\n");
    }

    public void Dados_Cliente(){
        System.out.println("Nome: " + getNome());
        System.out.println("Ano Nascimento: " + getAnoNascimento());
        System.out.println("Email: " + getEmail());
        System.out.println("Saldo: " + getSaldo() + "kz");
        System.out.println("ID: " + getID_Cliente());
        System.out.println("Senha: " + getSenha());
    }

    public void Dados_Cadastro_Cliente(){
        do {
            System.out.print("Nome: ");
            setNome(menu.in.nextLine());
        }while (repe == 1);

        do {
            System.out.print("Senha: ");
            setSenha(menu.in.next());
        }while (repe == 1);

        do {
            System.out.print("Ano Nascimento: ");
            setAnoNascimento(menu.in.nextInt());
        }while (repe == 1);

        do {
            System.out.print("Email: ");
            setEmail(menu.in.next());
        }while (repe == 1);

        do {
            System.out.print("Saldo inicial: ");
            setSaldo(menu.in.nextDouble());
        }while (repe == 1);
    }

    public void Verif_Cliente(){
        if (cliente.isEmpty()){
            v = 1;
        }else{
            v = 2;
        }
    }

    public void Cadastro_Cliente(){
        System.out.println("------------------- TELA DE CADASTRO ----------------------");

        System.out.println("Digite as suas informações abaixo");
        Dados_Cadastro_Cliente();

        Cliente novo_cliente = new Cliente(getNome(), getSenha(), getAnoNascimento(), getEmail(), getSaldo());
        cliente.add(novo_cliente);
        System.out.println("Cadastro feito com sucesso!");
        System.out.println("Seu ID: " + novo_cliente.getID_Cliente());
    }

    public void Infor_Cliente(){
        System.out.println("------------------------- MINHAS INFORMAÇÕES -----------------------------");
        Dados_Cliente();
    }

    public void P_Saldo(){
        do {
            System.out.println("Quanto deseja aumentar?");
            System.out.print("[R]: ");
            setAdic_saldo(menu.in.nextDouble());
        }while(repe == 1);

        setSaldo(getSaldo() + getAdic_saldo());
        System.out.println("Saldo aumentou +" + getAdic_saldo() + "kz");
    }

}
