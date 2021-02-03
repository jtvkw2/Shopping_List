/**
 * Shopping List Class to generate a shopping list with actions to edit it
 * @author Jacob Voyles
 * @class CPTS 132
 * @level Challenge
 */
public class ShoppingList {
    private final java.util.Scanner scan;
    public LinkedList list; //global array used for shopping list
    boolean firstRun = true; //Makes welcome message only happen at the beginning

    /**
     * Shopping list constructor
     */
    public ShoppingList() {
        scan = new java.util.Scanner(System.in);
        scan.useDelimiter("\n");
        list = new LinkedList();
    }

    /**
     * PrintList
     * Renders current list on screen
     */
    public void printList() {
        System.out.println("Your shopping list:");
        String[] getList = list.get();
        if(list.isEmpty()){
            System.out.println("* No items on list.");
        }
        else{
            for(int i = 0; i < list.get().length; i++){
                System.out.println(i+1 +". "+ getList[i]);
            }
        }
        go();
    }

    /**
     * addToList
     * Adds user input element to list
     *
     * @param item - takes string to add to list
     */
    public void addToList(String item) {
        if(findDuplicate(item)){
            System.out.println("Duplicate item apple not added to list.");
        }
        else {
            if(list.add(item) != true){
                System.out.println("Error Adding to List");
            }
        }
        go();
    }

    /**
     * emptyList
     * This method is used to clear the array and empty the list
     */
    public void emptyList() {
        list = new LinkedList();
        go();
    }

    /**
     * removeItem
     * This method takes user input and removes item from list
     *
     * @param item - takes a string, checks to see if string is in list
     *               if it is it removes from array and reorders
     */
    public void removeItem(String item){
        String word = item.substring(3);
        if(list.contains(word) == false){
            System.out.println("No item in List");
        }else{
            list.remove(word);
        }
        go();
    }

    /**
     * getInput
     * Takes user input and returns it for use
     *
     * @return user input
     */
    public String getInput() {
        System.out.print("Enter your item or command: ");
        return scan.next().trim();
    }

    /**
     * printWelcome()
     * This prints the fist line of the program
     */
    public void printWelcome() {
        System.out.println("Welcome to the XYZ Shopping List Program.");
    }

    /**
     * printThankYou
     * This method prints the final line when the user is finished with the list
     */
    public void printThankYou() {
        System.out.println("Thank you for using the XYZ Shopping List Program.");
    }


    /**
     * printHelp
     * This method prints the commands that can be used
     */
    public void printHelp() {
        System.out.println("Here are the list of commands:");
        System.out.println("  -p : Print the list");
        System.out.println("  -e : Empty the list");
        System.out.println("  -r Xxx : Remove item Xxx from the list");
        System.out.println("  -x : Exit the application");
        System.out.println("  -h : Print this command list");
    }

    /**
     * go
     * This method is used to take user input and commands and directs to appropriate function
     */
    public void go() {
        String input;
        if(firstRun) {
            printWelcome();
            printHelp();
            firstRun = false;
        }
        input = getInput();
        while( ! input.equals("-x")) {
            switch(input) {
                case "-h":
                    printHelp();
                    break;
                case "-p":
                    printList();
                    break;
                case "-x":
                    break;
                case "-e":
                    emptyList();
                    break;
                default:
                    if(input.charAt(0) == '-'){
                        if(input.charAt(1) =='r'){
                            removeItem(input);
                        }else {
                            System.out.println("Unrecognized command: " + input);
                            printHelp();
                        }
                    }
                    else {
                        addToList(input);
                    }
            }
            input = getInput();
        }
        printThankYou();
        System.exit(0);
    }

    /**
     * findDuplicate()
     * Takes a string to determine if it exists in list
     *
     * @param input - checks to see if input exists in list
     * @return false if no duplicate
     *         true for a duplicate
     */
    public boolean findDuplicate(String input){
        return list.contains(input);
    }

    /**
     * Main method
     * @param args - Command line arguments
     */
    public static void main(String[] args) {
        ShoppingList list;

        list = new ShoppingList();
        list.go();
    }
}
