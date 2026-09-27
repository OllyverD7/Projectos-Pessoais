package S_Vendas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {
    Scanner in = new Scanner(System.in);

    private static final List<Produto> produtos = new ArrayList<>();
    Menu menu = new Menu();
    private String nome;
    private int quantidade;
    private double preco;
    Produto produto_achado;
    int repe = 0;

    public Produto (String nome, int quantidade, double preco){
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public static List<Produto> getProdutos() {
        return produtos;
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

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0){
            System.out.println("A quantidade do produto não pode ser menor ou igual à zero!");
            repe = 1;
        }else {
            this.quantidade = quantidade;
            repe = 0;
        }
    }

    public void setPreco(double preco) {
        if (preco < 0){
            System.out.println("O preço não pode ser negativo!");
            repe = 1;
        }else {
            this.preco = preco;
            repe = 0;
        }
    }
    public void Apresentar_Produtos_ADM(){
        System.out.println("1 - Nome: " + getNome());
        System.out.println("    Preço: " + getPreco());
        System.out.println("    Quantidade: " + getQuantidade());
        System.out.println("---------------------------------------------\n");
    }

    public void Apresentar_Produtos_Cliente(){
        System.out.println("1 - Nome: " + getNome());
        System.out.println("    Preço: " + getPreco());

        if (getQuantidade() >= 20){
            System.out.println("    Quantidade: muitas quantidades");
        } else if (getQuantidade() < 20 || getQuantidade() >= 5) {
            System.out.println("    Algumas quantidades restantes ");
        } else if (getQuantidade() < 5 || getQuantidade() > 0) {
            System.out.println("    Quantidade: " + getQuantidade());
        }else {
            System.out.println("Não há mais desse produto!");
        }
        System.out.println("----------------------------------------\n");
    }

    public void Dados_produtos(){

        do {
            System.out.println("Nome do produto: ");
            setNome(in.nextLine());
        }while(repe == 1);

        do {
            System.out.println("Preço: ");
            setPreco(in.nextDouble());
        }while(repe == 1);

        do {
            System.out.println("Quantidade em Stock: ");
            setQuantidade(in.nextInt());
        }while(repe == 1);
    }

    public void Add_produtos(){
        System.out.println("------------------- ADICIONAR PRODUTOS -------------------");
        System.out.println("Por favor, digite as informações dos produtos");

        Dados_produtos();

        Produto novo_produto = new Produto(getNome(), getQuantidade(), getPreco());
        produtos.add(novo_produto);

        System.out.println("Produto adicionado com sucesso!");
    }

    public void Listar_Produtos(){
        System.out.println("------------------- PRODUTOS ----------------------");

        for (Produto produto : Produto.getProdutos()){
            for (int i = 0; i < Produto.getProdutos().size(); i++)
                System.out.println((i + 1) + " - Nome: " + getNome());
            System.out.println("    Preço: " + getPreco());
            System.out.println("    Quantidade: " + getQuantidade());
            System.out.println("---------------------------------------------\n");
        }
    }

    public void Procurar_produtos(){
        produto_achado = null;
        System.out.println("------------------------- PROCURAR PRODUTOS ----------------------------");

        do {
            System.out.println("Nome do produto: ");
            setNome(in.nextLine());
        }while(repe == 1);

        for (Produto produto : Produto.getProdutos()){
            if (getNome().equals(produto.getNome())){
                produto_achado = produto;
                break;
            }
        }

        if (produto_achado == null){
            System.out.println("Produto não encontrado!");
            repe = 1;
        }else {
            produto_achado.Apresentar_Produtos_ADM();
            menu.Menu_prod_opcao();
        }
    }

    public void Remover_produto(){

    }
}
