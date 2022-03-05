import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String mensagem;

            int contadorDivertido = 0;
            int contadorChateado = 0;

            System.out.println("Insira sua mensagem: ");
            mensagem = sc.nextLine();

            if (mensagem.contains(":-)")) {
                contadorDivertido++;
            }
            if (mensagem.contains(":-(")) {
                contadorChateado++;
            }

            if (contadorDivertido > contadorChateado) {
                System.out.println("Divertido");
            } else if (contadorChateado > contadorDivertido) {
                System.out.println("Chateado");
            } else {
                System.out.println("Neutro");
            }

        }
}


