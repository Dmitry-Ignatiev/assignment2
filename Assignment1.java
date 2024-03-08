import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args) throws IOException {
        Scanner scan1 = new Scanner(new File("Input1.txt"));
        Scanner scan2 = new Scanner(new File("input2.txt"));

        try {
            FileWriter myWriter = new FileWriter("report.txt");

            // Loop through each line in the second input file
            while (scan2.hasNextLine()) {
                String lineFile2 = scan2.nextLine();
                String[] file2Parts = lineFile2.split(" ");
                if (file2Parts.length == 3) {
                    String id2 = file2Parts[0];
                    double mark1 = Double.parseDouble(file2Parts[1]);
                    double mark2 = Double.parseDouble(file2Parts[2]);
                    double average = (mark1 + mark2) / 2.0;

                    // Reset scan1 to the beginning for each line in scan2
                    scan1 = new Scanner(new File("Input1.txt"));

                    // Loop through each line in the first input file
                    while (scan1.hasNextLine()) {
                        String lineFile1 = scan1.nextLine();
                        String[] file1Parts = lineFile1.split(" ");
                        if (file1Parts.length >= 3 && id2.equals(file1Parts[file1Parts.length - 1])) {
                            String name = file1Parts[0] + " " + file1Parts[1];

                            // Write the result to the output file
                            myWriter.write(id2 + " " + name + " " + average + "\r\n");
                            break;
                        }
                    }
                }
            }

            // Close the FileWriter to save changes to the output file
            myWriter.close();

        } catch (Exception e) {
            exceptionSwitch(e);

        } finally {
            scan1.close();
            scan2.close();
        }
    }

    private static void exceptionSwitch(Exception e) {
        if (e instanceof IOException) {//if the input is Wrong
            System.out.println("Handling IOException: " + e.getMessage());
        } else if (e instanceof NullPointerException) {//if the input is empty
            System.out.println("Handling NullPointerException: Empty input");
        }
   
    }
}
