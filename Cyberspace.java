/**
 * The Cyberspace class contains and maintains a collection of 
 * Webpage objects. 
 *
 * @author Alina Zheng and Leah Teffera
 * @version 3/5/2020
 */  
import java.util.Stack;  

public class Cyberspace 
{
    // declaration and initialization of stack to store a collection of webpages
    private Stack<Webpage> allPages; 

    public Cyberspace(){
        allPages = new Stack<Webpage>(); 
    }
    
    /**
     * Method to store a Webpage into this Cyberspace
     */
    public void storePage(Webpage page) {
        allPages.push(page); 
    }

    /**
     * Prints each webpage in the stack of webpages
     */
    public String toString() {
        Stack<Webpage> tempStack = new Stack<Webpage>(); 
        Webpage page; 
        String s = ""; 
        while (!allPages.isEmpty()) {
            page = allPages.pop(); 
            s = s + page.toString() + "\n"; 
            tempStack.push(page); 
        }
        
        while (!tempStack.isEmpty()) {
            page = tempStack.pop(); 
            allPages.push(page); 
        } 
        return s + "\n"; 
    }

    /**
     * Method to get the webpage with the largest number of lines
     */
    public Webpage getLargestLines() {
        Webpage page; 
        Webpage largest_page = null; 
        int page_max = 0; 
        Stack<Webpage> tempStack2 = new Stack<Webpage>(); 
        while (!allPages.isEmpty()) {
            page = allPages.pop();
            tempStack2.push(page);  
            if (page.getNumLines() > page_max)  
                page_max = page.getNumLines();
            largest_page = page; 
        }
        
        while (!tempStack2.isEmpty()) {
            page = tempStack2.pop(); 
            allPages.push(page); 
        } 
        
        if (largest_page == null) {
            System.out.println("All the webpages have the same number of lines."); 
        }
        
        return largest_page; 
    }

    public Stack<Webpage> getAllPages(){
        return this.allPages;
    }
    

    public static void main(String[] args) {
        Webpage page1 = new Webpage("google.com/get-a-life",59,"qwertyuiopasdfghjklzxcvbnmaaaalllllllll");
        Webpage page2 = new Webpage("microsoft.edu/hewwo",1,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Webpage page3 = new Webpage("youtube.com", 780, "qwertyui"); 
        Cyberspace space = new Cyberspace(); 
        space.storePage(page1); 
        space.storePage(page2);
        space.storePage(page3); 
        System.out.println(space.toString()); 
        System.out.println(space.getLargestLines());
    }
}
