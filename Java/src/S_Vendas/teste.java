package S_Vendas;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Registro_Accoes us = new Registro_Accoes("nome", 2003, 12,12,  "2003", "123456789", "oliveira@email.com","ooo" );
        us.Add_Users();
        us.Mensagem();
        us.Listar_Users();

        us.Remove_Users();
        us.Mensagem();
    }

}
