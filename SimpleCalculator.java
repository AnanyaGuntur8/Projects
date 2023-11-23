public class Calculator {
    public static void main(String[] args){
        //creating a calculator as a beginner. 
        //Using the standard classes 
        StdOut.println("Enter the first number");
        int a = StdIn.readInt();
        StdOut.println("Enter the second number");
        int b = StdIn.readInt();
        StdOut.println("Choose the operation: +, -, *, /");
        String operation = StdIn.readString();

        switch(operation){
            case "+":
                int resultAdd = a + b; 
                System.out.println(a + " + " + b + " = " + resultAdd);
                break;
            case "-": 
                int resultSub = a - b; 
                System.out.println(a + " - " + b + " = " + resultSub);
                break;
            case "*":
                int resultMult = a*b; 
                System.out.println(a + " * " + b + " = " + resultMult);
                break;
            case "/":
                int resultDiv1 = a/b;
                int resultDiv2 = ((a%b));
                if (resultDiv1 == 0){
                    System.out.println( "( " +resultDiv2+"/"+b+" )");
                }else {
                System.out.println(a + " / " + b + " = " + resultDiv1+ " " + "( " +resultDiv2+"/"+b+" )");
                }
                break;
            case " ":
                System.out.println("Invalid.");
        }


    }
}
