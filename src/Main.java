import com.google.category.controller.CategoryController;
import com.google.category.model.repository.CategoryRepository;
import com.google.category.view.CategoryView;
import com.google.product.controller.ProductController;
import com.google.product.model.repository.ProductRepository;
import com.google.product.view.ProductView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductView productView = new ProductView();
        ProductRepository productRepository = new ProductRepository();
        CategoryView categoryView = new CategoryView();
        CategoryRepository categoryRepository = new CategoryRepository();

        ProductController productController = new ProductController(productView, productRepository, categoryView, categoryRepository);
        CategoryController categoryController = new CategoryController(categoryView, categoryRepository);

        menuProduct(productController, categoryController);
    }

    public static void menuProduct(ProductController productController, CategoryController categoryController) {
        Scanner scanner = new Scanner(System.in);


        int op=-1;
        do   {
            System.out.println("0- Add Category");
            System.out.println("1- Add Product");
            System.out.println("2- Delete Product");
            System.out.println("3- UpDate Product");
            System.out.println("4- List Product");
            System.out.println("5- Sign out");

            System.out.println("Ingrese una opción");
            op = scanner.nextInt(); // Leer la entrada como cadena
            switch (op) {
                case 0:
                    categoryController.createCategory();
                    break;
                case 1:
                    productController.agregarProducto();
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
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (op!=5);
        System.out.println("Programa finalizado");
        scanner.close();
    }


}