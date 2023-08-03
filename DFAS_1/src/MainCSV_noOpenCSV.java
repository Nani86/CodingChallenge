import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class MainCSV_noOpenCSV {

		
	public static  List<PersonDetails> persons = new ArrayList<>();
	private static final String CSV_FILE_PATH = "C:\\Users\\NaniG\\eclipse-workspace\\DFAS_test\\files\\persons.csv";
	
	public static void main(String[] args ) {
		
		// Read data from the CSV file if it exists
		readFromCSV();
		

		
		 
	    
         Scanner scanner = new Scanner(System.in); 
			String Exit = "a";
			
			while (!(Exit.equals("exit")) && !(Exit.equals("close")))  {
				PersonDetails inputPerson = new PersonDetails();
				System.out.print("Enter First Name: ");
				inputPerson.setFirstName(scanner.nextLine());
				System.out.print("Enter Middle Name: ");
				inputPerson.setMiddleName(scanner.nextLine());
				System.out.print("Enter Last Name: ");
				inputPerson.setLastName(scanner.nextLine());
				
				// Code for SSN
				int q = 1;
				while (q  == 1) {
					
				
				System.out.print("Enter SSN (XXX-XX-XXXX) without spaces or symbols in between : ");
			
				String x = (scanner.nextLine());
				
					if (!(PersonDetails.isEmpty(x))) {
						try {
					int x1 = Integer.parseInt(x);
					if ((x.length() == 9)) {
						
						q = 2;
						inputPerson.setSsn(x);
						break;
					}
					
					else {
						System.out.println("Error: Please enter 9 digits for your SSN.");
						break;
					}}
					
						
					
					
					
				
				catch(Exception e) {
					System.out.print("Error:the entered data is not valid. Please make sure it is all numbers."
							+ " ");
					
				} 
						} else {
					
					q = 2;
					inputPerson.setSsn(x);
					}}
				
				
				//code for DOB
				q = 1;
				while (q  == 1) {
				
				
				System.out.print("Enter DOB (YYYY-MM-DD) without spaces or symbols in between : ");
				 String x = (scanner.nextLine());
				 if (!(PersonDetails.isEmpty(x))) {
				 try {
					int x1 = Integer.parseInt(x);
					if ((x.length() == 8) || (x.length() == 0)) {
						q = 2;	
						inputPerson.setDob(x);
						break;
					}
					else {
						System.out.println("Error: Please enter 8 digits for your DOB.");
						break;
					}
				
				
				}
				catch(Exception e) {
				System.out.print("Error:the entered data is not valid. Please make sure it is all numbers."
						+ " ");
				
				}
				}else {
					q = 2;
					inputPerson.setDob(x);
				}}
				 System.out.print("Enter address: ");
			     inputPerson.setDob(scanner.nextLine());
			     System.out.print("Enter City: ");
			     inputPerson.setDob(scanner.nextLine());
			     System.out.print("Enter State: ");
			     inputPerson.setDob(scanner.nextLine());
			     
			     //code for Zip
			     q = 1;
			     while (q  == 1) {
					
					
				System.out.print("Enter Zip (xxx xxx) without spaces or symbols in between : ");
				 String x = (scanner.nextLine());
				 if (!(PersonDetails.isEmpty(x))) {
				 try {
					int x1 = Integer.parseInt(x);
					if ((x.length() == 6)  || (x.length() == 0)) {
						q = 2;	
						inputPerson.setZip(x);
					}
					else {
						System.out.println("Error: Please enter 6 digits for your Zip.");
					}
					
					
				}
				catch(Exception e) {
					System.out.print("Error:the entered data is not valid. Please make sure it is all numbers."
							+ " ");
					
				}
				} else {
					q = 2;
					inputPerson.setZip(x);
				}}
				
				
				int dataSize = persons.size();
				int checkNo = 0;

			    boolean personUpdated = false;
			    
			    
			    List<PersonDetails> updatedPersons = new ArrayList<>();
				for (PersonDetails existingPerson : persons) {
			            int v = existingPerson.equalscheck(inputPerson); 
		            switch (v) {
		            case 10 :

		            	PersonService.updateFields(existingPerson, inputPerson);
		            	System.out.println("Match found for the input data and the updated data is  " + existingPerson);

		            	break;
		            case 211 :
		            	checkNo++;
		            	if (checkNo == dataSize) {
		            	
			            	updatedPersons.add(inputPerson); // Add the updated inputPerson
			            	System.out.println("No match found. New info added.");
		            	personUpdated = true;
		            	}		            	
		            	break;
		            case 212://class mismatch
		            	checkNo++;
		            	if (checkNo == dataSize) {
		            	System.out.println("All Fields are empty. Please enter SOME data to search or add data.");
		            	}break;
		            case 12://Dob mismatch
		            	System.out.println("SSN and DOB mismatch. Please verify your data");
		            	break;

		            	
		            }
		            updatedPersons.add(existingPerson); // Add the existingPerson to the updated list
		       }
				

				persons = updatedPersons; // Replace the original list with the updated one
				System.out.println("Hit Enter to continue or enter 'exit' or 'close' to close the program");
				Exit = (scanner.nextLine());
				
				
				
				}

			
			persons.forEach(System.out::println);
			writeToCSV();
			
			scanner.close();}
			
	


	// Method to read data from the CSV file and populate the persons list
    private static void readFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 9) {
                    PersonDetails person = new PersonDetails();
                    person.setFirstName(data[0]);
                    person.setMiddleName(data[1]);
                    person.setLastName(data[2]);
                    person.setSsn(data[3]);
                    person.setDob(data[4]);
                    person.setAddress(data[5]);
                    person.setCity(data[6]);
                    person.setState(data[7]);
                    person.setZip(data[8]);
                    persons.add(person);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the CSV file: " + e.getMessage());
        }
    }

    // Method to write data from the persons list to the CSV file
    private static void writeToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (PersonDetails person : persons) {
                bw.write(person.getFirstName() + "," +
                         person.getMiddleName() + "," +
                         person.getLastName() + "," +
                         person.getSsn() + "," +
                         person.getDob() + "," +
                         person.getAddress() + "," +
                         person.getCity() + "," +
                         person.getState() + "," +
                         person.getZip());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing data to the CSV file: " + e.getMessage());
        }
    }
}



        
		
			

				
	

