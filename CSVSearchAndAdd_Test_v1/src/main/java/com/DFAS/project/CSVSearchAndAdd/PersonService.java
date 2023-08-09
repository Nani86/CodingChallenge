package com.DFAS.project.CSVSearchAndAdd;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonService {

	
	
	private static List<PersonDetails> persons = new ArrayList<>();
	  

//    public boolean personExists(PersonDetails inputPerson) {
//        return persons.contains(inputPerson);
//    }
//    public static void printVertical() {
//    	persons.forEach(System.out::println);
//	}
    
    public static int equalscheck(PersonDetails p, PersonDetails o) {
        if (p == o) return 10;
        if (!(o instanceof PersonDetails)) return 11;
//        PersonDetails that = (PersonDetails) o;
        if ((isEmpty(o.getFirstName())) && (isEmpty(o.getMiddleName())) && (isEmpty(o.getLastName())) && 
    			(isEmpty(o.getSsn())) && (isEmpty(o.getDob())) && (isEmpty(o.getAddress())) && (isEmpty(o.getCity())) &&
    			(isEmpty(o.getState())) && (isEmpty(o.getZip()))) {
        	return 212;
        }
        else {
        	
		if (!(isEmpty(p.getSsn())) && !(isEmpty(o.getSsn()))) {
			if (Objects.equals(p.getSsn(), o.getSsn())) {
				if ((!(isEmpty(p.getDob()))) && (!(isEmpty(o.getDob())))) {
					if (Objects.equals(p.getDob(), o.getDob())) {
						return 10;
					}else {
						return 12;
					}
				}else {
					return 10;
				}

			}else{
				return 211;//ssn mismatch
			}
		}else {
			int g = checkEachField(p, o);
			 return g;
		}
		
    }
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
    
    public static int checkEachField(PersonDetails existingPerson, PersonDetails inputPerson) {	//code to check equality when no input SSN or no SSN in data
    	
		if (!(isEmpty(existingPerson.getFirstName())) && (!(isEmpty(inputPerson.getFirstName())))) {
		
			if (!(existingPerson.getFirstName().equals(inputPerson.getFirstName()))) {
			
				return 211;
			}
		}
		if (!(isEmpty(existingPerson.getMiddleName())) && (!(isEmpty(inputPerson.getMiddleName())))) {
			
			if((!(existingPerson.getMiddleName().equals(inputPerson.getMiddleName())))) {
			
				return 211;
			}
		} if (!(isEmpty(existingPerson.getLastName())) && (!(isEmpty(inputPerson.getLastName())))) {
			
			if((!(existingPerson.getLastName().equals(inputPerson.getLastName())))) {
				
				return 211;
			}
		} if (!(isEmpty(existingPerson.getDob())) && (!(isEmpty(inputPerson.getDob())))) {
			
			if((!(existingPerson.getDob().equals(inputPerson.getDob())))) {
				
				return 211;
			}

		} if (!(isEmpty(existingPerson.getAddress())) && (!(isEmpty(inputPerson.getAddress())))) {
			
			if ((!(existingPerson.getAddress().equals(inputPerson.getAddress())))) {
				
				return 211;
			}
		} if (!(isEmpty(existingPerson.getCity())) && (!(isEmpty(inputPerson.getCity())))) {
			
			if ((!(existingPerson.getCity().equals(inputPerson.getCity())))) {
				
				return 211;
			}
		} if (!(isEmpty(existingPerson.getState())) && (!(isEmpty(inputPerson.getState())))) {
			
			if ((!(existingPerson.getState().equals(inputPerson.getState())))) {
				
				return 211;
			}
		} if (!(isEmpty(existingPerson.getZip())) && (!(isEmpty(inputPerson.getZip())))) {
			
			if ((!(existingPerson.getZip().equals(inputPerson.getZip())))) {
				
				return 211;
			}
		}
			
		return 10;

		
		
	
	
}

}

	
		
	

