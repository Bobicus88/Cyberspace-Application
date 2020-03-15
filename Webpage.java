/**
 * The Webpage class represents a single webpage. 
 *
 * @author Alina Zheng and Leah Teffera
 * @version 3/5/20
 */

public class Webpage implements Comparable<Webpage>
{
    // instance variables to store the information of a webpage
    private String url; 
    private int num_lines; 
    private String contents; 

    /**
     * Constructor for objects of class Webpage
     * @param link The URL for the Webpage
     * @param lines The number of lines 
     * @param chars The first thirty characters of the Webpage
     */
    public Webpage(String link, int lines, String chars) {
        url = link; 
        num_lines = lines; 
        contents = chars; 
    }

    /**
     * Implements compareTo() method in Comparable interface
     * Compares the number of lines of this webpage with the number
     * of lines of another webpage
     * 
     * @param page the webpage to compare this webpage to 
     * @return an integer (-1, 1, 0) depending on which webpage 
     * has the greater number of lines (if this is greater, returns 1; if 
     * the other webpage is greater, returns -1, and if the two webpages 
     * have an equal number of lines, returns 0)
     */
    public int compareTo(Webpage page) {
        if (this.num_lines > page.num_lines) {
            return 1; 
        }
        if (this.num_lines < page.num_lines) {
            return -1; 
        }
        return 0;       
    }

    /**
     * Method to get first thirty characters
     */
    public String get_firstThirty() {
        return contents.substring(0, 30);  
    } 

    /**
     * Returns string containing neatly-formatted information of a Webpage
     * @return string containing information of Webpage object
     */
    public String toString() {
        String web_firstChars; 
        if (this.contents.length() < 30) {
            web_firstChars = this.contents; 
        } else {
            web_firstChars = get_firstThirty(); 
        }
        return this.url + " : " + this.num_lines + " : " + web_firstChars; 
    }
    
    /**
     * Returns the current Webpage's url 
     * @return String url
     */
    public String getURL(){
        return this.url;
    }
    /**
     * Returns the current Webpage's number of lines 
     * @return int num_lines
     */
    public int getNumLines(){
        return this.num_lines;
        
    }
    
    /**
     * Returns the current Webpage's contents
     * @return String contents of the Webpage
     */
    public String getContents(){
        return this.contents;
    }

    public static void main(String[] args) {
        Webpage page1 = new Webpage("google.com/get-a-life",59,"qwertyuiopasdfghjklzxcvbnmaaaalllllllll");
        Webpage page2 = new Webpage("microsoft.edu/hewwo",1,"a");
        //tests: compareTo(), toString(),get_firstThirty(), getURL(), getNumLines(), getContents()
        System.out.println("should return 1 because page1 has 59 lines and page 2 has one:" +
        page1.compareTo(page2)); 
        System.out.println("prints the first 30 characters in the webpage: "+
        page1.get_firstThirty());
        System.out.println("prints URL of page1, google.com/get-a-life: "+page1.getURL());
        System.out.println("prints the number of lines in page2, 1: "+page2.getNumLines());
        System.out.println("prints all the characters in page1: "+page1.getContents());
        System.out.print("testing toString() method for page1... " + page1.toString());
    }

}
