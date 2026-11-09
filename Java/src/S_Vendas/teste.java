package S_Vendas;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pessoa pessoa = new Pessoa("oli", 20, "1234", 2003, 123456789, "oliveira@email.com");
        pessoa.ApresentarPessoa();

        in.close();

    }

}
