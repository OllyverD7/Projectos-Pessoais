package S_Vendas;

import java.io.IOException;

public class Pessoa {
    private String nome;
    private String senha;
    private int anoNascimento;
    private String email;
    private int estado;
    int repe = 0;
    int v = 0;

    public Pessoa(String nome, String senha, int anoNascimento, String email){
        this.nome = nome;
        this.senha = senha;
        this.anoNascimento = anoNascimento;
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public String getEmail() {
        return email;
    }

    public int getEstado() {
        return estado;
    }


    public void setSenha(String senha) {
        if (senha.trim().isEmpty()){
            System.out.println("Por favor, preencha o campo de senha.");
            repe = 1;

        } else if ( senha.matches("\\s")) {
            System.out.println("Senha não pode conter espaços.");
            repe = 1;

        } else if (!senha.matches("^(?=.*[A-Za-z])(?=.*\\d).{8,}$")) {
            System.out.println("A senha deve ter pelo menos 8 caracteres e conter letras e números.");
            repe = 1;

        } else {
            this.senha = senha;
            repe = 0;
        }
    }

    public void setNome(String nome) {
        if (nome.trim().isEmpty()){
            System.out.println("Por favor, digite o campo do nome.");
            repe = 1;

        } else if (!nome.matches("[\\p{L} ]+")) {
            System.out.println("Nome não pode conter caracteres especiais e numeros.");
            repe = 1;

        }else {
            this.nome = nome;
            repe = 0;
        }
    }

    public void setAnoNascimento(int anoNascimento) {
        int idade = 0;
        idade = 2026 - anoNascimento;
        if (idade < 16){
            System.out.println("Ano de nascimento inválido, menor de idade!");
            repe = 1;

        }else if (idade > 120){
            System.out.println("Ano de nascimento inválido, idade muito avançada!");
            repe = 1;

        }else {
            this.anoNascimento = anoNascimento;
            repe = 0;
        }

    }

    public void setEmail(String email) {
        if (email.trim().isEmpty()){
            System.out.println("Por favor, preencha o campo do email.");
            repe = 1;

        } else if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            System.out.println("Por favor, digite um email válido!");
            repe = 1;

        } else if (email.matches("\\s")) {
            System.out.println("Email não pode conter espaços!");
            repe = 1;

        }else {
            this.email = email;
            repe = 0;
        }
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
