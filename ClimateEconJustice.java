package climate;

import java.util.ArrayList;

/**
 * This class contains methods which perform various operations on a layered 
 * linked list structure that contains USA communitie's Climate and Economic information.
 * 
 * @author Navya Sharma
 */

public class ClimateEconJustice {

    private StateNode firstState;
    
    /*
    * Constructor
    * 
    * **** DO NOT EDIT *****
    */
    public ClimateEconJustice() {
        firstState = null;
    }

    /*
    * Get method to retrieve instance variable firstState
    * 
    * @return firstState
    * 
    * **** DO NOT EDIT *****
    */ 
    public StateNode getFirstState () {
        // DO NOT EDIT THIS CODE
        return firstState;
    }

    /**
     * Creates 3-layered linked structure consisting of state, county, 
     * and community objects by reading in CSV file provided.
     * 
     * @param inputFile, the file read from the Driver to be used for
     * @return void
     * 
     * **** DO NOT EDIT *****
     */
    public void createLinkedStructure ( String inputFile ) {
        
        // DO NOT EDIT THIS CODE
        StdIn.setFile(inputFile);
        StdIn.readLine();
        
        // Reads the file one line at a time
        while ( StdIn.hasNextLine() ) {
            // Reads a single line from input file
            String line = StdIn.readLine();
            // IMPLEMENT these methods
            addToStateLevel(line);
            addToCountyLevel(line);
            addToCommunityLevel(line);
        }
    }

    /*
    * Adds a state to the first level of the linked structure.
    * Do nothing if the state is already present in the structure.
    * 
    * @param inputLine a line from the input file
    */
    public void addToStateLevel ( String inputLine ) {

        // WRITE YOUR CODE HERE
        String[] splitInput = inputLine.split(",");
        String  stateName = splitInput[2];
        StateNode newState = new StateNode(stateName, null, null);
        if (firstState == null) {
            firstState = newState;
        } else {
            StateNode currNode = firstState;

            while (currNode.getNext() != null) {
                //process the currentNode to go to next
                currNode = currNode.getNext();
                //check the same condition again to see if the above components
                if (currNode.getName().equals(newState.getName())) {
                    return;
                    //inside the if statement 
                }
            }
            if (currNode.getName().equals(newState.getName())) {
                return; //get the new state if the getnae equals the same state 
                //bro its literally the next function smh

            }
            currNode.setNext(newState);
        }//get the next state in the side 


    }

    /*
    * Adds a county to a state's list of counties.
    * 
    * Access the state's list of counties' using the down pointer from the State class.
    * Do nothing if the county is already present in the structure.
    * 
    * @param inputFile a line from the input file
    */
    public void addToCountyLevel ( String inputLine ) {
//LITERALLY THE SAME THING AS THE STATE  LEVEL BUT WITH COUNTIES INSTEAD OF STATES
        // WRITE YOUR CODE HERE
        String[] splitInput = inputLine.split(",");
        String countyName = splitInput[1];
        String stateName = splitInput[2];
        StateNode currNode = firstState;
        while (currNode.getNext() != null) {
            //check the same condition again to see if the above components
            if (currNode.getName().equals(stateName)) {
                break; //same bro
                //inside the if statement 
            }
            //process the currentNode to go to next
            currNode = currNode.getNext();
        }
        if(currNode ==null){ //ceck if the thing is null right cuz if you  are at the end it will be null  like 
            //linked list sort of thing. 
            return;
            
        }
        //country node is defined for you . 
        CountyNode newCounty = new CountyNode(countyName, null,null);
        if(currNode.getDown()==null){
            //LITERALLY MEANS GO DoWN its mad weird
            currNode.setDown(newCounty);
        }else{
            CountyNode currCounty = currNode.getDown();//same concept to the firststate. 
            while (currCounty.getNext() != null) {
                if (currCounty.getName().equals(newCounty.getName())) {
                    return; 
                }
                currCounty = currCounty.getNext();
            }//get the next county 
            // Check for the last county node after exiting the loop
            if (currCounty.getName().equals(newCounty.getName())) {
                return; // County already exists
            }
            currCounty.setNext(newCounty);
            //set it next to the county
        }//again the same exact thing bro 


    }

    /*
    * Adds a community to a county's list of communities.
    * 
    * Access the county through its state
    *      - search for the state first, 
    *      - then search for the county.
    * Use the state name and the county name from the inputLine to search.
    * 
    * Access the state's list of counties using the down pointer from the StateNode class.
    * Access the county's list of communities using the down pointer from the CountyNode class.
    * Do nothing if the community is already present in the structure.
    * 
    * @param inputFile a line from the input file
    */
    public void addToCommunityLevel ( String inputLine ) {
        String[] splitInput = inputLine.split(",");
        //Given a line from the input file, split (string_name.split(“,”)) each line to extract information such as community, county, and state names, along with various attributes. The indices for all the contents required are as follows:
// BRO WHAT HT 
//Community: index 0
// County: index 1
// State: index 2
// Percent African American: index 3
// Percent Native: index 4
// Percent Asian: index 5
// Percent White: index 8
// Percent Hispanic: index 9
// Disadvantaged: index 19
// PM Level: index 49
// Chance of Flood: index 37
// Poverty Line: index 121
// In this method you will ONLY use the states’ name (index 2)
        String communityName = splitInput[0];
        String countyName = splitInput[1];
        String stateName = splitInput[2];
        StateNode currNode = firstState;
        Data data = new Data();
        //bruh wth you have to define the percentges why else would theygive it to you
        //bruh you gotta be kiddling be 
        data.setPrcntAfricanAmerican(Double.parseDouble(splitInput[3]));
        data.setPrcntNative(Double.parseDouble(splitInput[4]));
        data.setPrcntAsian(Double.parseDouble(splitInput[5]));
        data.setPrcntWhite(Double.parseDouble(splitInput[8]));
        data.setPrcntHispanic(Double.parseDouble(splitInput[9]));
        data.setAdvantageStatus(splitInput[19]);
        data.setPMlevel(Double.parseDouble(splitInput[49]));
        data.setChanceOfFlood(Double.parseDouble(splitInput[37]));
        data.setPercentPovertyLine(Double.parseDouble(splitInput[121]));
    //tGO THROUGH THE linked list 
        while (currNode.getNext() != null) {
            //check the same condition again to see if the above components
            if (currNode.getName().equals(stateName)) {
                break;
                //inside the if statement 
            }
            //process the currentNode to go to next
            currNode = currNode.getNext();
        }//again checkif the node ia nezt 
        if(currNode ==null){
            return;
            //return to checking if the  input is valid or not. 
        }
        CountyNode currCounty = currNode.getDown();
        while (currCounty.getNext() != null) {
            //check the same condition again to see if the above components
            if (currCounty.getName().equals(countyName)) {
                break;
                //inside the if statement 
            }
            //process the currentNode to go to next
            currCounty = currCounty.getNext();
        }
        if(currCounty ==null){
            return;
            
        }
    CommunityNode newCommunity = new CommunityNode(communityName, null, data);
    if (currCounty.getDown() == null) {
        currCounty.setDown(newCommunity);
    } else {
        CommunityNode currCommunity = currCounty.getDown();
        while (currCommunity.getNext() != null) {
            if (currCommunity.getName().equals(communityName)) {
                return; // Community already exists
            }
            currCommunity = currCommunity.getNext();
        }
        // Check the last community node after exiting the loop
        if (currCommunity.getName().equals(communityName)) {
            return; // Community already exists
        }
        currCommunity.setNext(newCommunity);
    }

        // WRITE YOUR CODE HERE

    }

    /**
     * Given a certain percentage and racial group inputted by user, returns
     * the number of communities that have that said percentage or more of racial group  
     * and are identified as disadvantaged
     * 
     * Percentages should be passed in as integers for this method.
     * 
     * @param userPrcntage the percentage which will be compared with the racial groups
     * @param race the race which will be returned
     * @return the amount of communities that contain the same or higher percentage of the given race
     */
    public int disadvantagedCommunities ( double userPrcntage, String race ) {
        //Start by traversing the linked list structure layer by layer
        int isDisadvantaged = 0;

        StateNode currentState = firstState;
        //initialzing the head of the list
        while(currentState !=null){
            //initialzie the county 
            CountyNode currentCounty=currentState.getDown();
            while(currentCounty!=null){
                
                //initlaize the community node
                CommunityNode currentCommunity=currentCounty.getDown();
                while(currentCommunity!=null){
                    //step one
                    //count the number of communities that have said percentage or higher of the 
                    //racial demographic and are also identified as disadvantaged.

                    double percentage = 0.0;

                    switch (race) {
                        case "African American":
                            percentage = currentCommunity.getInfo().getPrcntAfricanAmerican()*100;
                            break;
                           //FOLLOW THIS METHOD 
                        case "Native American":
                            percentage = currentCommunity.getInfo().getPrcntNative()*100;
                            break;
                            //DO THE SAME EZACT THING
                        case "Asian American":
                            percentage = currentCommunity.getInfo().getPrcntAsian()*100;
                            break;
                            
                        case "White American":
                            percentage = currentCommunity.getInfo().getPrcntWhite()*100;
                            break;
                        case "Hispanic American":
                            percentage = currentCommunity.getInfo().getPrcntHispanic()*100;
                            break;
                    }
 //USE THE SWITCH CASE CuZ IT"S BETTER TO UNDERSTAND BRO
                    if(percentage >= userPrcntage){
                        if(currentCommunity.getInfo().getAdvantageStatus().equals("True")){
                            isDisadvantaged++;
                        }
                    }
                    //get the race
                    //initlaizing the percentage counter
                        //go through all the races and see if the user input is greaterthan or equal 
                        currentCommunity = currentCommunity.getNext();
                    }
                    currentCounty = currentCounty.getNext();
                }//Community bracket. 
                currentState = currentState.getNext();
            }//Country bracket
        
            return isDisadvantaged; 

        }//CurrState Bracket.
 // replace this line
        
//ending Bracket, incase u forget


    /**
     * Given a certain percentage and racial group inputted by user, returns
     * the number of communities that have that said percentage or more of racial group  
     * and are identified as non disadvantaged
     * 
     * Percentages should be passed in as integers for this method.
     * 
     * @param userPrcntage the percentage which will be compared with the racial groups
     * @param race the race which will be returned
     * @return the amount of communities that contain the same or higher percentage of the given race
     */
    public int nonDisadvantagedCommunities ( double userPrcntage, String race ) {
        int isNonDisadvantaged = 0;

        StateNode currentState = firstState;
        //initialzing the head of the list
        while(currentState !=null){
            //initialzie the county 
            CountyNode currentCounty=currentState.getDown();
            while(currentCounty!=null){
                
                //initlaize the community node
                CommunityNode currentCommunity=currentCounty.getDown();
                while(currentCommunity!=null){
                    //step one
                    //count the number of communities that have said percentage or higher of the 
                    //racial demographic and are also identified as disadvantaged.

                    double percentage = 0.0;

                    switch (race) {
                        case "African American":
                            percentage = currentCommunity.getInfo().getPrcntAfricanAmerican()*100;
                            break;
                           //MULTIPY BY HUNDREd
                        case "Native American":
                            percentage = currentCommunity.getInfo().getPrcntNative()*100;
                            break;
                            
                        case "Asian American":
                            percentage = currentCommunity.getInfo().getPrcntAsian()*100;
                            break;
                            
                        case "White American":
                            percentage = currentCommunity.getInfo().getPrcntWhite()*100;
                            break;
                        case "Hispanic American":
                            percentage = currentCommunity.getInfo().getPrcntHispanic()*100;
                            break;
                    }

                    if(percentage >= userPrcntage){
                        if(currentCommunity.getInfo().getAdvantageStatus().equals("False")){
                            isNonDisadvantaged++;
                        }
                    }
                    //get the race
                    //initlaizing the percentage counter
                        //go through all the races and see if the user input is greaterthan or equal 
                        currentCommunity = currentCommunity.getNext();
                    }
                    currentCounty = currentCounty.getNext();
                }//Community bracket. 
                currentState = currentState.getNext();
            }//Country bracket
        
            return isNonDisadvantaged; 

        }//CurrState Bracket.
    
    /** 
     * Returns a list of states that have a PM (particulate matter) level
     * equal to or higher than value inputted by user.
     * 
     * @param PMlevel the level of particulate matter
     * @return the States which have or exceed that level
     */ 
    public ArrayList<StateNode> statesPMLevels ( double PMlevel ) {
        ArrayList<StateNode> statesPMLevels= new ArrayList<>();
        StateNode currState = firstState;
        while (currState != null) {
                CountyNode currCounty= currState.getDown();
                while(currCounty != null){
                    CommunityNode currComm = currCounty.getDown();
                   
                    while (currComm != null){
                        Data communityPMLData = currComm.getInfo();
                        double pollutionLevel = communityPMLData.getPMlevel();
                        //basically step 2
                        if(pollutionLevel >= PMlevel && !statesPMLevels.contains(currState)){
                            statesPMLevels.add(currState);
                        }
                        
                        //Once you reach the community layer, check if each community has a recorded pollution
                        // level equal to or higher than the pollution level entered.
                        currComm = currComm.getNext();
                    }
                    currCounty = currCounty.getNext();
                }
                currState = currState.getNext();
            }
        // WRITE YOUR METHOD HERE
        return statesPMLevels; // replace this line
    }

    /**
     * Given a percentage inputted by user, returns the number of communities 
     * that have a chance equal to or higher than said percentage of
     * experiencing a flood in the next 30 years.
     * 
     * @param userPercntage the percentage of interest/comparison
     * @return the amount of communities at risk of flooding
     */
    public int chanceOfFlood ( double userPercntage ) {
        int count = 0;
        // WRITE YOUR METHOD HERE
       // Traverse the linked list structure.
       StateNode currState = firstState;
        while (currState != null) {
                CountyNode currCounty= currState.getDown();
                while(currCounty != null){
                    CommunityNode currComm = currCounty.getDown();
                   
                    while (currComm != null){
                        //Once you reach the community layer, check if each community has a recorded p
                        //pollution level equal to or higher than the pollution level entered.
                        Data communityCFData = currComm.getInfo(); 
                        double chanceOfFlooding = communityCFData.getChanceOfFlood();
                        if(chanceOfFlooding >= userPercntage){
                            count++;
                        }
                        currComm = currComm.getNext();
                        }
                        currCounty = currCounty.getNext();
                        
                        //Once you reach the community layer, check if each community has a recorded pollution
                        // level equal to or higher than the pollution level entered.
                        
                    }
                    currState = currState.getNext();
                }
                
            
        // WRITE YOUR METHOD HERE
        return count; // replace this line
    }

    /** 
     * Given a state inputted by user, returns the communities with 
     * the 10 lowest incomes within said state.
     * 
     *  @param stateName the State to be analyzed
     *  @return the top 10 lowest income communities in the State, with no particular order
    */
    public ArrayList<CommunityNode> lowestIncomeCommunities ( String stateName ) {

        //WRITE YOUR METHOD HEe
        //Traverse through a linked list
        ArrayList<CommunityNode> low = new ArrayList<>();
            StateNode currState = firstState;
            while(currState !=null&&!currState.getName().equals(stateName)){
                currState= currState.getNext();
        }
            CountyNode currCounty = currState.getDown();
            while(currCounty!=null){
                CommunityNode currCommunity = currCounty.getDown();
                while(currCommunity != null){
                    if(low.size() < 10){ //if the array list is less than 10 add the community node ot the nwwf
                        //add to low
                        low.add(currCommunity);
                    } //add to commynty 
                    else{
                        int index = 0;
                        for(int i=0; i<low.size(); i++){
                            if(low.get(i).getInfo().getPercentPovertyLine()<currCommunity.getInfo().getPercentPovertyLine()&&(low.get(i).getInfo().getPercentPovertyLine()<low.get(index).getInfo().getPercentPovertyLine()) ){
                                index = i;
                            }//get the percent pwervey line 
                        }
                        if(low.get(index).getInfo().getPercentPovertyLine()<currCommunity.getInfo().getPercentPovertyLine()){
                            low.set(index, currCommunity);


                        }
                    }
                    currCommunity = currCommunity.getNext();

            }
            currCounty = currCounty.getNext();
        } //Return low her bro smh 

        return low;
    }
    
}


    
