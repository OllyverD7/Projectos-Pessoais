package S_Vendas;
import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;

public class Pessoa {
    Scanner_In scanner = new Scanner_In();

    private String nome;
    private int idade;
    private String senha;
    private int ano_nascimento;
    private int mes_nascimeto;
    private int dia_nascimento;
    private String telefone;
    private String email;
    private int estado;
    private int estadoEntrada;
    InputMismatchException e = new  InputMismatchException();
    int repe = 0;

    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public String getSenha() {
        return senha;
    }
    public int getAno_nascimento() {
        return ano_nascimento;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public int getEstado() {
        return estado;
    }
    public int getEstadoEntrada() {
        return estadoEntrada;
    }

    public int getMes_nascimeto() {
        return mes_nascimeto;
    }

    public int getDia_nascimento() {
        return dia_nascimento;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome não pode estar vazio");
            repe = 1;
        }else if (nome.matches("^[p{L}]+(?:[ '-][p{L}]+)*$")){
            System.out.println("nome nao deve ter números");
        }else {
            System.out.println("So letras");
            this.nome = nome;
            repe = 0;
        }
    }
    public void setIdade(int idade) {
        if (idade < 10){
            System.out.println("Meno de idade!");
            repe = 1;
        } else if (idade > 125) {
            System.out.println("Idade inválida!");
            repe = 1;
        }else {
            this.idade = idade;
            repe = 0;
        }
    }
    public void setSenha(String senha) {
        if (senha.matches("^[0-9]+$")){
            this.senha = senha;
            repe = 0;
        }else {
            System.out.println("Senha só pode conter números");
            repe = 1;
        }
    }
    public void setAno_nascimento(int ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
        repe = 0;
    }
    public void setTelefone(String telefone) {
        if (telefone.matches("^(?:244|00244)?9[1-9][0-9]{7}$")){
            this.telefone = telefone;
            repe = 0;
        }else {
            System.out.println("Números inválidos!");
            repe = 1;
        }
    }

    public void setEmail(String email) {
        if (email.matches("^[a-zA-Z0-9._%+-]+@gmail.com$")){
            this.email = email;
            repe = 0;
        }else {
            System.out.println("Email inválido!!");
            repe = 1;
        }
    }

    public void setMes_nascimeto(int mes_nascimeto) {
        if (mes_nascimeto < 1 || mes_nascimeto > 12){
            System.out.println("Mês inválido!\n");
            repe = 1;
        }else {
            this.mes_nascimeto = mes_nascimeto;
            repe = 0;
        }
    }

    public void setDia_nascimento(int dia_nascimento) {
        if (dia_nascimento < 1 || dia_nascimento > 31){
            System.out.println("Dia inválido!");
            repe = 1;
        }else {
            this.dia_nascimento = dia_nascimento;
            repe = 0;
        }
    }

    public void setEstado(int estado) {
        if (estado == 1){
            this.estado = estado;
        }else {
            this.estado = estado;
        }
    }

    public void setEstadoEntrada(int estadoEntrada) {
        if (estadoEntrada == 1){
            this.estadoEntrada = estadoEntrada;
        }else {
            this.estadoEntrada = estadoEntrada;
        }
    }

    Pessoa(String nome, int ano_nascimento, int mes_nascimeto, int dia_nascimento, String senha, String telefone, String email) {
        this.nome = nome;
        this.ano_nascimento = ano_nascimento;
        this.mes_nascimeto = mes_nascimeto;
        this.dia_nascimento = dia_nascimento;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
    }

    public void VerificarEstado() {
        if (this.estado == 1) {
            System.out.println("A pessoa está ativa.");
        } else {
            System.out.println("A pessoa está inativa.");
        }
    }
    public void VerificarEstadoEntrada() {
        if (this.estadoEntrada == 1) {
            System.out.println("A pessoa está logada.");
        } else {
            System.out.println("A pessoa não está logada.");
        }
    }

    public void Idade(){
        LocalDate nascimento = LocalDate.of(getAno_nascimento(), getMes_nascimeto(), getDia_nascimento());
        setIdade(Period.between(nascimento, LocalDate.now()).getYears());
    }

    public void InsertDados_Pessoa(){
        int anoActual = LocalDate.now().getYear();
        do {
            System.out.print("Nome: ");
            setNome(scanner.in.nextLine());
        }while(repe == 1);

        do {
            System.out.print("Ano Nascimento: ");
            try {
                setAno_nascimento(scanner.in.nextInt());
            }catch (InputMismatchException e){
                System.out.println("Por favor, digite números\n");
                scanner.in.next();
                repe = 1;
            }
            if (anoActual - getAno_nascimento() > 125){
                System.out.println("Idade muita avançada, por favor verifique o ano de nascimento\n");
                repe = 1;
            } else if (anoActual - getAno_nascimento() < 10) {
                System.out.println("Menor de idade!\n");
                repe = 1;
            }else {
                repe = 0;
            }
        }while (repe == 1);

        do {
            System.out.print("Mês Nascimento: ");
            try {
                setMes_nascimeto(scanner.in.nextInt());
            }catch (InputMismatchException e){
                System.out.println("Por favor, digite números\n");
                scanner.in.next();
                repe = 1;
            }
        }while (repe == 1);

        do {
            System.out.print("Dia nascimento: ");
            try {
                setDia_nascimento(scanner.in.nextInt());
            }catch (InputMismatchException e){
                System.out.println("Por favor, digite números\n");
                scanner.in.next();
                repe = 1;
            }
        }while (repe == 1);

        do {
            System.out.print("Senha: ");
            setSenha(scanner.in.next());
        }while (repe == 1);

        do {
            System.out.print("Telefone: ");
            setTelefone(scanner.in.next());
        }while (repe == 1);

        do {
            System.out.print("Email: ");
            setEmail(scanner.in.next());
        }while (repe == 1);
    }

    public void Apresentar() {
        System.out.println("\n*********************************************");
        System.out.println("Nome: " + this.nome);
        System.out.println("Senha: " + this.senha);
        System.out.println("Data de Nascimento: " + this.ano_nascimento + "/" + this.mes_nascimeto + "/" + this.dia_nascimento);
        Idade();
        System.out.println("Idade: " + this.idade);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Email: " + this.email);
        System.out.println("Estado: " + this.estado);
        System.out.println("Estado de Entrada: " + this.estadoEntrada);
        System.out.println("*********************************************");

    }


}
