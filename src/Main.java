import com.google.product.controler.ProductController;
import com.google.product.model.repository.ProductRepository;
import com.google.product.view.ProductView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductView productView = new ProductView();
        ProductRepository productRepository = new ProductRepository();
        ProductController productController = new ProductController(productView, productRepository);

        menuProduct(productController);
    }

    public static void menuProduct(ProductController productController) {
        Scanner scanner = new Scanner(System.in);


        int op=-1;
        do   {
            System.out.println("1- Ingrese Product");
            System.out.println("2- Elimine Product");
            System.out.println("3- Actualice Product");
            System.out.println("4- Liste Product");
            System.out.println("0- Salir");

            System.out.println("Ingrese una opción");
            op = scanner.nextInt(); // Leer la entrada como cadena
            switch (op) {
                case 1:
                    productController.createProduct();
                    break;
                case 2:
                    productController.removeProduct();
                    break;
                case 3:
                    productController.updateProduct();
                    break;
                case 4:
                    productController.listProducts();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (op!=0);
        System.out.println("Programa finalizado");
        scanner.close();
    }


}