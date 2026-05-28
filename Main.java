import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      SMART FILE ORGANIZER");
        System.out.println("=================================");

        System.out.print("Enter folder path to organize: ");
        String folderPath = scanner.nextLine();

        FileOrganizer organizer = new FileOrganizer();
        organizer.organizeFiles(folderPath);

        scanner.close();
    }
}
