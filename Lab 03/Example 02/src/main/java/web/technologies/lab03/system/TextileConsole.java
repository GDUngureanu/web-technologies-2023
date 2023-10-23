package web.technologies.lab03.system;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.technologies.lab03.model.fashion.Design;
import web.technologies.lab03.model.textile.Product;
import web.technologies.lab03.service.fashion.FashionCompany;
import web.technologies.lab03.service.textile.TextileFactory;
import web.technologies.lab03.service.textile.TextileStorage;

@Component
@RequiredArgsConstructor
public class TextileConsole {

    @Autowired
    private FashionCompany fashionCompany;

    private final TextileFactory textileFactory = new TextileFactory();

    private final TextileStorage textileStorage = new TextileStorage();

    public void display(final Scanner scanner) {
        while (true) {
            displayMenu();
            final var choice = scanner.next();
            scanner.nextLine();

            try {
                switch (Integer.parseInt(choice)) {
                    case 1 -> manufactureProducts(scanner);
                    case 2 -> displayAllProducts();
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }

            } catch (NumberFormatException exception) {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void displayAllProducts() {
        System.out.println();
        System.out.println("Available clothing: ");

        for (Product product : textileStorage.getStoredProducts()) {
            System.out.println(product);
        }
    }

    private void manufactureProducts(Scanner scanner) {
        displayClothingDesigns();
        System.out.print("Select a design patent to manufacture: ");
        var input = scanner.nextLine();

        Design selectedDesign = fashionCompany.getDesign(UUID.fromString(input));

        if (selectedDesign == null) {
            System.out.println("Design not found.");
            return;
        }

        do {
            System.out.println("Selected Design: " + selectedDesign);

            System.out.print("Enter material (e.g., Cotton, Linen, Silk): ");
            String material = scanner.nextLine();

            System.out.print("Enter size (e.g., S, M, L): ");
            String size = scanner.nextLine();

            System.out.print("Enter quantity to produce: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  // consume newline

            List<Product> products = textileFactory.manufactureProducts(selectedDesign, quantity, material, size);
            System.out.println(products.size() + " products manufactured successfully!");

            System.out.print("Do you want to manufacture more of the same design? (yes/no) ");
            input = scanner.nextLine();
        } while ("yes".equalsIgnoreCase(input));
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("Textile company: ");
        System.out.println("1. Manufacture products");
        System.out.println("2. See all products");
        System.out.println("0. Exit company");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    private void displayClothingDesigns() {
        System.out.println();
        System.out.println("Available clothing designs: ");

        Map<UUID, Design> designs = fashionCompany.getAllDesigns();
        for (Design concept : designs.values()) {
            System.out.println(concept);
        }

        System.out.println();
    }
}

