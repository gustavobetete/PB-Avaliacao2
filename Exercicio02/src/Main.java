import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        FilmeDAO fd = new FilmeDAO();

        Integer qtdDeFilmes = null;
        Integer paginaAcessada = null;

        System.out.println("Digite a quantidade de filmes por pagina: ");
        qtdDeFilmes = sc.nextInt();

        System.out.println("Digite a pagina a ser acessada: ");
        paginaAcessada = sc.nextInt();

        fd.construcaoDePaginacao(qtdDeFilmes, paginaAcessada);

    }
}
