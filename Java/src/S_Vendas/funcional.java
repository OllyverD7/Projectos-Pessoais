package S_Vendas;

public class funcional {
    static void main() {
        Login log = new Login();
        ADM ad = new ADM("ADM Supremo", "123qwe123qwe", 1977, "efdf");
        Cliente cli = new Cliente("jkldjklddds jjkl", "kjkjklsjkl23425", 2000, "jkdf@gmail.com", 30000);
        Menu menu = new Menu();

        System.out.println(ad.getNome());

        do {

            ad.Verif_ADM();
            if (ad.v == 1){
                System.out.println("Não há administrador no sistema pra podermos iniciar o programa.\nPor favor, cadastre um para começarmos. ");
                do {
                    menu.Menu_Add();
                    if (menu.escolha == 1){
                        ad.Add_ADM();
                        ad.repe = 1;

                    }else if (menu.escolha == 2){
                        System.out.println("Lamentamos, não vai dar para avançarmos com o programa.\nPROGRAMA ENCERRADO!");
                        ad.repe = 1000;

                    }else {
                        System.out.println("Por favor, digite um número válido!");
                        ad.repe = 2;
                    }
                }while(ad.repe == 2);

            }else {

                do {
                    menu.Menu_Login();

                    if (menu.escolha == 1){

                        do {
                            menu.Menu_Cliente();

                            switch (menu.escolha){
                                case 1:
                                    cli.Cadastro_Cliente();
                                    ad.repe = 2;
                                    break;

                                case 2:
                                    log.Login_Cliente();
                                    ad.repe = 2;
                                    break;

                                case 3:
                                    ad.repe = 1;
                                    break;

                                default:
                                    System.out.println("Por favor, digite um número válido!");
                                    ad.repe = 2;
                                    break;
                            }
                        }while(ad.repe == 2);

                    }else if (menu.escolha == 2){
                        log.Login_ADM();

                        do {

                            menu.Menu_ADM_Escolha();
                            switch (menu.escolha) {
                                case 1:
                                    do {
                                        menu.Menu_Produtos();
                                        switch (menu.escolha) {
                                            case 1:
                                                System.out.println("Aqui lista os produtos");
                                                ad.repe = 3;
                                                break;

                                            case 2:
                                                System.out.println("Aqui adiciono produto");
                                                ad.repe = 3;
                                                break;
                                            case 3:
                                                System.out.println("Aqui remove produtos");
                                                ad.repe = 3;
                                                break;
                                            case 4:
                                                System.out.println("Aqui acesso Produto");
                                                ad.repe = 3;
                                                break;
                                            case 5:
                                                ad.repe = 2;
                                                break;
                                            default:
                                                System.out.println("Por favor, digite um número válido!");
                                                ad.repe = 3;
                                                break;
                                        }

                                    } while (ad.repe == 3);
                                    break;

                                case 2:
                                    do {
                                        menu.Menu_ADM();

                                        switch (menu.escolha) {
                                            case 1:
                                                ad.Add_ADM();
                                                ad.repe = 3;
                                                break;
                                            case 2:
                                                ad.Listar_ADM();
                                                ad.repe = 3;
                                                break;
                                            case 3:
                                                ad.Remover_ADM();
                                                ad.repe = 3;
                                                break;
                                            case 4:
                                                ad.Editar_ADM();
                                                ad.repe = 3;
                                                break;
                                            case 5:
                                                ad.repe = 2;
                                                break;
                                            default:
                                                System.out.println("Por favor, digite um número válido!");
                                                ad.repe = 3;
                                        }
                                    } while (ad.repe == 3);
                                    break;

                                case 3:
                                    do {
                                        menu.Menu_ADM_Cliente();
                                        switch (menu.escolha){
                                            case 1:
                                                ad.Listar_Cliente();
                                                ad.repe = 3;
                                                break;

                                            case 2:
                                                ad.Remover_Cliente();
                                                ad.repe = 3;
                                                break;

                                            case 3:
                                                ad.Bloquear_Desbloquear();
                                                ad.repe = 3;
                                                break;
                                            case 4:
                                                ad.repe = 2;
                                                break;
                                            default:
                                                System.out.println("Por favor, digite um número válido!");
                                                ad.repe = 3;
                                                break;
                                        }
                                    }while(ad.repe == 3);
                                    break;

                                case 4:
                                    ad.Apresentar_ADM();
                                    ad.repe = 2;
                                    break;

                                case 5:
                                    ad.repe = 1;
                                    break;

                                default:
                                    System.out.println("Por favor, digite um número válido!");
                                    ad.repe = 2;
                                    break;
                            }

                        }while (ad.repe == 2);

                    } else {
                        System.out.println("OBRIGADO POR TESTAR O NOSSO PROGRAMA!!");
                        System.out.println("Programa encerrado!");
                        ad.repe = 1000;
                    }
                }while (ad.repe == 1);
            }
        }while(ad.repe == 1);
    }
}
