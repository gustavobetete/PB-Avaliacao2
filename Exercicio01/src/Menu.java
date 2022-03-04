import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws SQLException {

        ProdutoDAO pd = new ProdutoDAO();

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a opção: ");

        pd.listar();
        pd.inserir();
    }

}
