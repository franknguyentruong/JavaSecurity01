import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
SDEV 425
Homework 01
Fix your first Java Data Input issues
Frank Truong

 */
public class Fix_JavaSecurity01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        //Fix vulnerabiltiy, for no args
        if (args.length < 1) {
            // Handle error
            throw new Exception("No args");
            //System.out.println("No args");
        }

        // Read the filename from the command line argument
        String filename = args[0];

        Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
        Matcher matcher = pattern.matcher(filename);

        //Fix vulnerabiltiy, for file names containing unsafe characters
        if (matcher.find()) {
          // File name contains bad chars; handle error
          throw new Exception("File name contains bad chars; handle error");
        }       


        BufferedReader inputStream = null;

        String fileLine;
        try {
            inputStream = new BufferedReader(new FileReader(filename));

            System.out.println("Email Addresses:");
            // Read one Line using BufferedReader
            while ((fileLine = inputStream.readLine()) != null) {
                System.out.println(fileLine);
            }
        } catch (IOException io) {
            System.out.println("File IO exception" + io.getMessage());
        } finally {
            // Need another catch for closing 
            // the streams          
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException io) {
                System.out.println("Issue closing the Files" + io.getMessage());
            }

        }// end try catch finally
    }// end main

}// end Fix_JavaSecurity01
