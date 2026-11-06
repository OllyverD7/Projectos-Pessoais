package S_Vendas;

public class Pessoa {
    private String nome;
    private int idade;
    private String senha;
    private int ano_nascimento;
    private int telefone;
    private String email;
    private int estado;
    private int estadoEntrada;

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
    public int getTelefone() {
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

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }else if (!nome.matches("^[A-Za-zÀ-ÿ ]+")){
            throw new IllegalArgumentException("O nome deve ter apenas letras.");
        }
        this.nome = nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setAno_nascimento(int ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public void setEstadoEntrada(int estadoEntrada) {
        this.estadoEntrada = estadoEntrada;
    }

    Pessoa(String nome, int idade, String senha, int ano_nascimento, int telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
        this.ano_nascimento = ano_nascimento;
        this.telefone = telefone;
        this.email = email;
        this.estado = estado;
        this.estadoEntrada = estadoEntrada;
    }

    public void ApresentarPessoa() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Senha: " + this.senha);
        System.out.println("Ano de Nascimento: " + this.ano_nascimento);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Email: " + this.email);
        System.out.println("Estado: " + this.estado);
        System.out.println("Estado de Entrada: " + this.estadoEntrada);
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
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Joã1o", 30, "senha123", 1993, 923592031, "joao@email.com");
        pessoa1.ApresentarPessoa();
        pessoa1.VerificarEstado();
        pessoa1.VerificarEstadoEntrada();
    }
}
