package web.technologies.lab03.system;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import web.technologies.lab03.model.fashion.Design;
import web.technologies.lab03.service.fashion.FashionCompany;

@Component
@RequiredArgsConstructor
public class FashionConsole {

    private final FashionCompany fashionCompany;

    public void display(final Scanner scanner) {
        while (true) {
            displayMenu();
            final var choice = scanner.next();
            scanner.nextLine();

            try {
                switch (Integer.parseInt(choice)) {
                    case 1 -> createClothingDesign(scanner);
                    case 2 -> changeClothingDesign(scanner);
                    case 3 -> displayAllDesigns();
                    case 4 -> scrapClothingDesign(scanner);
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

    private void displayMenu() {
        System.out.println();
        System.out.println("Fashion company: ");
        System.out.println("1. Create new clothing design");
        System.out.println("2. Change clothing design");
        System.out.println("3. See all clothing designs");
        System.out.println("4. Scrap clothing design");
        System.out.println("0. Exit company");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    private void changeClothingDesign(Scanner scanner) {
        System.out.print("Enter clothing design patent to change: ");
        UUID changeId = UUID.fromString(scanner.nextLine());

        System.out.print("Change design to: ");
        String newDesign = scanner.nextLine();

        Design concept = fashionCompany.updateDesign(changeId, newDesign);
        System.out.println("Changed " + concept);
    }

    private void createClothingDesign(Scanner scanner) {
        System.out.print("Enter clothing type (e.g., Shirt, Pants): ");
        String type = scanner.nextLine();
        System.out.print("Enter clothing design (e.g., Plain, Floral): ");
        String design = scanner.nextLine();

        Design concept = fashionCompany.createDesign(type, design);
        System.out.println("Introducing " + concept);
    }

    private void displayAllDesigns() {
        System.out.println();
        System.out.println("Available clothing designs:");

        Map<UUID, Design> designs = fashionCompany.getAllDesigns();
        for (Design concept : designs.values()) {
            System.out.println(concept);
        }
    }

    private void scrapClothingDesign(Scanner scanner) {
        System.out.print("Enter clothing design patent to scrap: ");
        UUID scrapId = UUID.fromString(scanner.nextLine());

        Design concept = fashionCompany.scrapDesign(scrapId);
        System.out.println("Scraped " + concept);
    }

}
