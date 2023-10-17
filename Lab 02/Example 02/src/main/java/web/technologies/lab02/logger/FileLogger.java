package web.technologies.lab02.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogger implements ActionLogger {

    private final String filePath;

    public FileLogger() throws IOException {
        // "user.dir" gives the project root folder in most IDE setups.
        this.filePath = System.getProperty("user.dir") + "/Lab 02/Example 02/src/main/resources/log.txt";

        // Reset file content.
        Files.write(Paths.get(filePath), new byte[0]);
    }

    @Override
    public void log(String message) {
        try (final PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(message);
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

}
