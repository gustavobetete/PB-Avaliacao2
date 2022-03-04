import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws SQLException {

        ProdutoDAO pd = new ProdutoDAO();

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a opção: ");

        int opcao = 0;

        while (opcao != 5){

            System.out.println("- - - - - - - - - - - - ");
            System.out.println("1- Cadastrar produtos");
            System.out.println("2- Atualizar produto");
            System.out.println("3- Excluir segundo produto");
            System.out.println("4- Listar produtos!");
            System.out.println("5- Sair!");
            System.out.println("- - - - - - - - - - - - ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrando produtos...");
                    pd.inserir();
                    System.out.println("Produtos cadastrados com sucesso!!!");
                    break;

                case 2:
                    System.out.println("Atualizando o primeiro produto...");
                    pd.atualizar();
                    System.out.println("Produto atualizado!!!");
                    break;

                case 3:
                    System.out.println("Excluido o produto 2...");
                    pd.remocao();
                    System.out.println("Produto excluido com sucesso!!!");
                    break;

                case 4:
                    System.out.println("Listando produtos cadastrados:");
                    pd.listar();
                    break;
                case 5:
                    System.out.println("Você esta saindo... XAU");
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }

}
