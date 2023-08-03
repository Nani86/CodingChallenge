import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonService {

	
	
	private static List<PersonDetails> persons = new ArrayList<>();
	  

    public boolean personExists(PersonDetails inputPerson) {
        return persons.contains(inputPerson);
    }
    public static void printVertical() {
    	persons.forEach(System.out::println);
	}
    
    
    

    

    public static void updateFields(PersonDetails existingPerson, PersonDetails inputPerson) {
        
    	if (!isEmpty(inputPerson.getFirstName())) {
    	existingPerson.setFirstName(inputPerson.getFirstName());
    	}
    	if (!isEmpty(inputPerson.getMiddleName())) {
            existingPerson.setMiddleName(inputPerson.getMiddleName());
    	}
    	if (!isEmpty(inputPerson.getLastName())) {
        existingPerson.setLastName(inputPerson.getLastName());
    	}
    	if (!isEmpty(inputPerson.getDob())) {
         existingPerson.setDob(inputPerson.getDob());
    	}
    	if (!isEmpty(inputPerson.getSsn())) {
          existingPerson.setSsn(inputPerson.getSsn());
    	}
    	if (!isEmpty(inputPerson.getAddress())) {
        existingPerson.setAddress(inputPerson.getAddress());
    	}
    	if (!isEmpty(inputPerson.getCity())) {
            existingPerson.setCity(inputPerson.getCity());
    	}
    	if (!isEmpty(inputPerson.getState())) {
            existingPerson.setState(inputPerson.getState());
    	}
    	if (!isEmpty(inputPerson.getZip())) {
            existingPerson.setZip(inputPerson.getZip());
        }
    }

        
    

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    

}

	
		
	

