import java.util.Scanner;
public class Testadora {
    public static void main(String[]args){
        String cpf;
        Scanner tec = new Scanner(System.in);

        while(true){
            System.out.print("\n- CPF: ");
            cpf = tec.nextLine();

            cpf = cpf.replaceAll("[^0-9]", "");

            if(cpf.length() == 8 || cpf.length() == 9 || cpf.length() == 10 || cpf.length() == 11){
                break;
            }
            else{
                System.out.println("\n* Tamanho de CPF Incorreto!");
            }
        }
        CPF c = new CPF(cpf);
        c.verificarTamanho();
    }
}
