import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        FilmeDAO fd = new FilmeDAO();

        fd.inserir();
        fd.listar();
    }
}
