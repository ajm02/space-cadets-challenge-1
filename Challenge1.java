import java.io.BufferedReader;  // Imports the classes necessary for the program
import java.io.InputStreamReader;
import java.net.URL;

public class Challenge1 {

    public static void main(String[] args) throws Exception{

        System.out.print("Please enter an email ID: ");

        BufferedReader emailReader = new BufferedReader(new InputStreamReader(System.in)); // Prompts user to enter the email ID
        String emailID = new String(emailReader.readLine());

        String webAddress = new String("https://www.ecs.soton.ac.uk/people/" + emailID); // ID is concatenated with the first part of the link

        URL url = new URL(webAddress); // Creates a URL object
        BufferedReader urlReader = new BufferedReader(new InputStreamReader(url.openStream()));

        while (urlReader.readLine() != null) {  // while loop cycles through every line of the html

            String line = new String(urlReader.readLine());

            if (line.contains("<title>")){ // If the line contains <"tittle"> which is the line where the name is stored, the following code executes

                int endPart = line.indexOf("|"); // This is the index of where the name ends

                // Creates a String object of the name by getting the correct substring of the line, the name always begins with the 11th character of the line
                String name = new String(line.substring(11, endPart));

                System.out.println(name); // Prints the name
                break; // Exits for loop
           }

        }

    }
}


