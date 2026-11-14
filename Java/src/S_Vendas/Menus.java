package S_Vendas;

import java.util.InputMismatchException;

public class Menus {
    Scanner_In scanner = new Scanner_In();
    int escolha;

    public void conf_Eliminar(){

        do {
            System.out.println("1 - Eliminar");
            System.out.println("2 - Não");
            System.out.print("[R]: ");
            try {
                escolha = scanner.in.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Por favor, digite um número!");
                scanner.in.next();
            }
            if (escolha < 1 || escolha > 2){
                System.out.println("por favor, selecione uma das opções!");
            }
        }while(escolha < 1 || escolha > 2);
    }
}
