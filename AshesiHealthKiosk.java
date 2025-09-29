import java.util.Scanner;
import java.util.Random;

public class AshesiHealthKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        Random rand = new Random();

        String chosenService = null;
        double patientBMI = 0;
        char baseCode = 0;

        System.out.println("Welcome to the Ashesi Health Kiosk");

        System.out.println(); 

        System.out.println("Services on offer");
        System.out.println("Pharmacy - P");
        System.out.println("Lab - L");
        System.out.println("Triage - T");
        System.out.println("Counseling - C");

        System.out.println();

        System.out.print("Enter service code (P/L/T/C): ");
        char hospitalService = input.next().charAt(0);

        System.out.println(); 

        // Service Router
        switch (hospitalService) {
            case 'P','p': System.out.println("Go to Pharmacy Desk");
            chosenService = "Pharmacy Desk"; break;
            case 'L','l': System.out.println("Go to Lab Desk"); 
            chosenService = "Lab Desk"; break;
            case 'T','t': System.out.println("Go to Triage Desk");
            chosenService = "Triage Desk"; break;
            case 'C','c': System.out.println("Go to Counseling Desk"); 
            chosenService = "Counseling Desk"; break;

            default: System.out.println("Invalid service code"); break;
        } 
        
        System.out.println();
        
            System.out.print("Patient's weight in kg: ");
            double patientWeight = input.nextDouble();

            System.out.print("Patient's height in meters: ");
            double patientHeight = input.nextDouble();

            patientBMI = Math.round(patientWeight / (patientHeight*patientHeight));
            int roundBMI = (int) Math.round(patientBMI * 10) / 10;

            System.out.println(); 

        // Mini Health Metric
        if (chosenService == "Triage Desk"){
            System.out.println("Kindly enter the preferred health metric: ");
            System.out.println("1 - BMI");
            System.out.println("2 - Dosage round-up");
            System.out.println("3 - Simple trig helper");

            System.out.println();

            System.out.print("Your choice (number): ");
            int metricChoice = input.nextInt();

            switch (metricChoice) {
                case 1: 
                if (patientBMI < 18.5) {
                System.out.println("BMI: " + patientBMI + " | Patient is Underweight"); 
            } else if (patientBMI > 18.5 && patientBMI < 24.9){
                System.out.println("BMI: " + patientBMI + " | Patient is Normal"); 
            } else if (patientBMI > 25.0 && patientBMI < 29.9){
                System.out.println("BMI: " + patientBMI + " | Patient is Overweight"); 
            } else {
                System.out.println("BMI: " + patientBMI + " | Patient is Obese"); 
            }; break;

                case 2: System.out.print("Enter the required dosage in mg: "); 
            double requiredDosage = input.nextDouble();

            int numberOfTablets = (int) Math.ceil(requiredDosage/250);

            System.out.println("Patient's required number of tablets is " + numberOfTablets); ; break;

                case 3: System.out.print("Enter an angle in degrees: "); 
            double degrees = input.nextDouble();

            double radians = Math.toRadians(degrees);
            double sineDegrees = Math.round(Math.sin(radians) * 1000) / 1000.0;
            double cosineDegrees = Math.round(Math.cos(radians) * 1000) / 1000.0;

            System.out.println();
            
            System.out.println("The sine of " + degrees + " degrees is " + sineDegrees + " radians");
            System.out.println("The cosine of " + degrees + " degrees is " + cosineDegrees + " radians");; break;
            
                default: System.out.println("Error! Invalid option");
            }
        }
        System.out.println();

        // ID Sanity Check
        char randomCharacter = (char) ('A' + rand.nextInt(26));

        String patientCode = "" + randomCharacter;

        int randomNumber1 = rand.nextInt((9-3) + 1) + 3;
        int randomNumber2 = rand.nextInt((9-3) + 1) + 3;
        int randomNumber3 = rand.nextInt((9-3) + 1) + 3;
        int randomNumber4 = rand.nextInt((9-3) + 1) + 3;
        
        patientCode += "" + randomNumber1 + randomNumber2 + randomNumber3 + randomNumber4;

        if (patientCode.length() == 5 && Character.isLetter(patientCode.charAt(0)) && (randomNumber1 >= 0 && randomNumber1 <= 9) && (randomNumber2 >= 0 && randomNumber2 <= 9) 
        && (randomNumber3 >= 0 && randomNumber3 <= 9) && (randomNumber4 >= 0 && randomNumber4 <= 9)) {  
            System.out.println();
            System.out.println("ID is okay: " + patientCode);
        } else if (patientCode.length() != 5) {
            System.out.println("Invalid length");
        } else if (!(Character.isLetter(patientCode.charAt(0)))){
            System.out.println("Invalid: First char must be a letter");
        } else {
            System.out.println("Invalid: Code must contain digits");
        }


        System.out.println();
        
        // "Secure" Display Code
        System.out.print("Enter your first name: ");
        input.nextLine();
        String studentFirstName = input.nextLine().toUpperCase();

        if (!studentFirstName.isEmpty()){
            baseCode = studentFirstName.charAt(0);

            char shiftedLetter = (char) ('A' + (baseCode - 'A' + 2) % 26);

            String lastTwoChars = patientCode.substring(3);

            String studentCode = "" + shiftedLetter + lastTwoChars + "-" + roundBMI;

            System.out.println("Code: " + studentCode);

            System.out.println();

        if (chosenService == "Pharmacy Desk"){
            System.out.println("PHARMACY | ID = " + patientCode + " | Code = " + studentCode);
        } else if (chosenService == "Triage Desk") {
            System.out.println("TRIAGE | ID = " + patientCode + " | BMI = " + patientBMI + " | Code = " + studentCode);
        } else if (chosenService == "Lab Desk"){
            System.out.println("LAB | ID = " + patientCode + " | Code = " + studentCode);
        } else if (chosenService == "Counseling Desk"){
            System.out.println("COUNSELING | ID = " + patientCode + " | Code = " + studentCode);
            }
        } else {
            System.out.println("You must enter a valid name");
        }
    }     
}
