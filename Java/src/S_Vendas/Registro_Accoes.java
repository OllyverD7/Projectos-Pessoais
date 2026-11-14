package S_Vendas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Registro_Accoes extends Users{

    Registro_Accoes (String nome, int ano_nascimento, int mes_nascimeto, int dia_nascimento, String senha, String telefone, String email, String type){
        super(nome, ano_nascimento, mes_nascimeto, dia_nascimento, senha, telefone, email, type);
    }

    public void Mensagem(){
        System.out.println("Nome: " + getNome() + "\tID: " + getID());
        System.out.println("Tipo de User: " + getType());
        System.out.println("Data: " + getData().format(data_formato));
        System.out.println("Hora: " + getHora().format(hora_formato));
        System.out.println("Acção: " + getAccao());
    }
}
