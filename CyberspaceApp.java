/**
 * The CyperspaceApp program fetches pages from the Web, counts the 
 * lines of their html code and reports to the user information on 
 * those pages
 *
 * @author (Alina Zheng and Leah Teffera)
 * @version (3/5/20)
 */
import java.util.Scanner; 
import javafoundations.*; 
import java.io.IOException; 
import java.net.URL; 
import java.io.File; 
import java.io.FileNotFoundException; 

public class CyberspaceApp 
{   
    /**
     * Helper method, reads from URL and finds the line count and the 
     * first thirty characters of a webpage
     * @return a Webpage. 
     */
    public static Webpage readFromURL(String url) {
        int line_count = 0; 
        String content = ""; 
        Webpage page = null; 
        try {
            Scanner scan = new Scanner(new URL(url).openStream());
            while (scan.hasNext()){
                String line = scan.nextLine();
                line_count++;
                content += line; 
            }
            scan.close();
            page = new Webpage(url, line_count, content); 
        }
        catch (IOException e) {
            System.out.println(e); 
            System.out.println("The program terminates."); 
            System.exit(0); 
        }
        return page; 
    }

    /**
     * Method to get the number of lines in a file
     * @return the number of lines
     */
    public static int numLinesFile(File file){
        int count = 0;
        try{
            Scanner scan = new Scanner(file); 
            while (scan.hasNext()){
                count++; 
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e); 
            System.out.println("The program terminates."); 
            System.exit(0); 
        }
        return count; 
    }

    /**
     * Method to read from a file 
     */
    public static Webpage[] readFromFile(String file_name) {
        Webpage[] webpages = null; 
        int ar_index = 0; 
        try {
            File file = new File(file_name); 
            int ar_count = numLinesFile(file); 
            webpages = new Webpage[ar_count]; 
            Scanner scan = new Scanner(file);
            String line; 
            while (scan.hasNext()) {
                line = scan.next(); 
                webpages[ar_index] = readFromURL(line); 
                ar_index++; 
            }
            scan.close(); 
        }
        catch (FileNotFoundException e) {
            System.out.println(e); 
            System.out.println("The program terminates."); 
            System.exit(0); 
        }
        return webpages; 
    }

    public static void main (String[] args) {
        Cyberspace space = new Cyberspace(); 
        Scanner scan = new Scanner(System.in);
        if (args.length==0) { 
            System.out.print("Please enter a URL. Press CTRL-D to quit.\n");
            do { 
                String url = scan.nextLine(); 
                Webpage page_to_push = readFromURL(url); 
                space.storePage(page_to_push); 
            } while (scan.hasNext()); 

        }
        else {
            Webpage[] array = readFromFile(args[0]); 
            for (int i = 0; i < array.length; i++) {
                space.storePage(array[i]); 
            }
        }
        System.out.println(space.toString()); 
        System.out.println("The largest Webpage was: " + space.getLargestLines() + "\n");
        
        
    }

}
