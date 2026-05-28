import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileOrganizer {

    public void organizeFiles(String folderPath) {

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path!");
            return;
        }

        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found.");
            return;
        }

        for (File file : files) {

            if (file.isFile()) {

                String fileName = file.getName();

                int dotIndex = fileName.lastIndexOf(".");

                if (dotIndex == -1) {
                    continue;
                }

                String extension = fileName.substring(dotIndex + 1);

                String category = FileCategory.getCategory(extension);

                File categoryFolder = new File(folderPath + File.separator + category);

                if (!categoryFolder.exists()) {
                    categoryFolder.mkdir();
                }

                File destinationFile =
                        new File(categoryFolder + File.separator + file.getName());

                try {

                    Files.move(
                            file.toPath(),
                            destinationFile.toPath(),
                            StandardCopyOption.REPLACE_EXISTING
                    );

                    System.out.println(
                            file.getName() + " moved to " + category
                    );

                } catch (IOException e) {

                    System.out.println(
                            "Error moving file: " + file.getName()
                    );

                    e.printStackTrace();
                }
            }
        }

        System.out.println("\nFiles organized successfully!");
    }
}
