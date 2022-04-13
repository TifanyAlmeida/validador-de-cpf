import java.util.Scanner;

public class CPF {
    String cpf, aux = "", dini = "";
    int cont, contagem, auxint, d1, d2, tmnInicial = 0, op;
    Scanner tec = new Scanner(System.in);

    String[] vet = {"Rio Grande do Sul", "Distrito Federal, Goiás," +
            " Mato Grosso, Mato Grosso do Sul e Tocantins",
            "Amazonas, Pará, Roraima, Amapá, Acre e Rondônia",
            "Ceará, Maranhão e Piauí", "Paraíba, Pernambuco," +
            " Alagoas e Rio Grande do Norte", "Bahia e Sergipe",
            "Minas Gerais", "Rio de Janeiro e Espírito Santo",
            "São Paulo", "Paraná e Santa Catarina"};

    public CPF(String cpf) {
        this.cpf = cpf;
    }

    public void verificarTamanho() {

        tmnInicial = cpf.length();

        if (cpf.length() == 8) {
            pedirUF();
        }
        if (cpf.length() == 10) {
            dini = cpf.substring(9, 10);
            cpf = cpf.substring(0, 9);
            calcularD1();
        } else if (cpf.length() == 11) {
            dini = cpf.substring(9, 11);
            cpf = cpf.substring(0, 9);
            calcularD1();
        } else if (cpf.length() == 9) {
            calcularD1();
        }
    }

    public void pedirUF() {
        System.out.println("\n\t\t#### UF de Registro ####\n");
        for (int b = 0; b < vet.length; b++) {
            System.out.println("\t" + (b + 1) + " - " + vet[b]);
        }
        System.out.println("\nOpção: ");
        op = tec.nextInt();
        op = op - 1;
        cpf += op;
        calcularD1();
    }

    public void calcularD1() {

        cont = cpf.length() + 1;
        for (int y = 0; y < cpf.length(); y++) {

            if (cont >= 2) {
                aux = cpf.substring(y, y + 1);
                auxint = Integer.parseInt(aux);
                contagem += auxint * cont;
                cont--;
            }
        }
        d1 = 11 - (contagem % 11);

        if (d1 > 9) {
            d1 = 0;
        }
        if (tmnInicial == 10) {
            if (!dini.equals(String.valueOf(d1))) {
                System.out.println("\n\nCPF Inválido!");
                System.exit(0);
            } else {
                calcularD2();
            }
        } else if (tmnInicial == 11 || tmnInicial == 9 || tmnInicial == 8) {
            calcularD2();
        }
    }

    public void calcularD2() {
        cont = cpf.length() + 2;
        contagem = 0;
        aux = "";
        auxint = 0;
        cpf += d1;

        for (int y = 0; y < cpf.length(); y++) {

            if (cont >= 2) {

                aux = cpf.substring(y, y + 1);
                auxint = Integer.parseInt(aux);
                contagem += auxint * cont;
                cont--;

            }
        }

        d2 = 11 - (contagem % 11);
        if (d2 > 9) {
            d2 = 0;
        }

        if (tmnInicial == 11) {
            if (!dini.equals(String.valueOf(d1) + (d2))) {
                System.out.println("\n\nCPF Inválido!");
                System.exit(0);
            } else {
                validarCPF();
            }
        } else if (tmnInicial == 10 || tmnInicial == 9 || tmnInicial == 8) {
            validarCPF();
        }

    }

    public void validarCPF() {
        cpf = cpf + d2;
        System.out.println("\n\nCPF: " + cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + (d1) + (d2));
        System.out.println("- CPF validado com Sucesso! -");
        System.exit(0);
    }
}