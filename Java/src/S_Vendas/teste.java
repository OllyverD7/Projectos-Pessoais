package S_Vendas;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        setNome(in.nextLine());
        Pessoa pessoa = new Pessoa(getNome(), 20, "1234", 2003, 123456789, "oliveira@email.com");
        pessoa.ApresentarPessoa();

        in.close();


    }

}
