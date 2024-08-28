import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        1
        File dir = new File("/Users/user/Documents/Games");
        StringBuilder log = new StringBuilder();

        String[] directories = {"src", "res", "savegames", "temp"};
        for (String directory : directories) {
            File newDir = new File(dir, directory);
            if (newDir.mkdir()) {
                log.append("Directory ").append(directory).append(" created");
            } else {
                log.append("Failed to create directory ").append(directory);
            }
        }

//       2
        String[] srcDir = {"main", "test"};
        for (String directory : srcDir) {

            File newDir = new File(new File(dir, "src"), directory);
            // Проверяем, удалось ли создать директорию
            if (newDir.mkdir()) {
                log.append("Directory 2").append(directory).append(" created");
            } else {
                log.append("Failed to create directory 2").append(directory);
            }
        }


//      3

        File mainDir = new File(new File(dir, "src"), "main");
        String[] files = {"Main.java", "Utils.java"};
        for (String fileName : files) {
            File file = new File(mainDir, fileName);
            try {
                if (file.createNewFile()) {
                    log.append("File ").append(fileName).append(" created in main\n");
                } else {
                    log.append("Failed to create file ").append(fileName).append(" in main\n");
                }
            } catch (IOException e) {
                log.append("Exception while creating file ").append(fileName).append(" in main: ").append(e.getMessage()).append("\n");
            }
        }


//      4
        File newDirFile = new File(dir, "res");
        String[] tu = {"drawables", "vectors", "icons"};
        for (String directory : tu) {
            File newDir = new File(newDirFile, directory);
            if (newDir.mkdir()) {
                log.append("Directory 4 ").append(directory).append(" created");
            } else {
                log.append("Failed to create directory 4 ").append(directory);
            }
        }


//      5


        for (String fileName : files) {
            File tempDir = new File(new File(dir, "temp"), "temp.txt");
            try {
                if (tempDir.createNewFile()) {
                    log.append("File ").append(fileName).append(" created in main\n");
                } else {
                    log.append("Failed to create file ").append(fileName).append(" in main\n");
                }
            } catch (IOException e) {
                log.append("Exception while creating file ").append(fileName).append(" in main: ").append(e.getMessage()).append("\n");
            }
        }


        File logFile = new File(dir, "temp/temp.txt");
        try (FileWriter writer = new FileWriter(logFile)) {
            writer.write(log.toString());
            log.append("Log written to temp.txt\n");
        } catch (IOException e) {
            log.append("Exception while writing log to temp.txt: ").append(e.getMessage()).append("\n");
        }









        System.out.println(log.toString());
    }


}
