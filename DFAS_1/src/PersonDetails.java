import java.util.Objects;
import java.io.Serializable;

public class PersonDetails implements Serializable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String ssn;
    private String dob;   
    private String address;
    private String city;
    private String state;
    private String zip;
    
    
    // Constructors, getters, setters, and other methods as needed.
    
    public int equalscheck(Object o) {
        if (this == o) return 10;
        if (!(o instanceof PersonDetails)) return 11;
        PersonDetails that = (PersonDetails) o;
        if ((isEmpty(that.firstName)) && (isEmpty(that.middleName)) && (isEmpty(that.lastName)) && 
    			(isEmpty(that.ssn)) && (isEmpty(that.dob)) && (isEmpty(that.address)) && (isEmpty(that.city)) &&
    			(isEmpty(that.state)) && (isEmpty(that.zip))) {
        	return 212;
        }
        else {
        	
		if (!(isEmpty(ssn)) && !(isEmpty(that.ssn))) {
			if (Objects.equals(ssn, that.ssn)) {
				if ((!(isEmpty(dob))) && (!(isEmpty(that.dob)))) {
					if (Objects.equals(dob, that.dob)) {
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
			 return checkEachField(this, that);
		}
		
    }
    }
    
    
    	
    
    

    @Override
	public String toString() {
		return "PersonDetails [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", dob=" + dob + ", ssn=" + ssn + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + "]";
	}

	@Override
    public int hashCode() {
        return Objects.hash(ssn, dob);
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public PersonDetails() {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.ssn = ssn;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public int checkEachField(PersonDetails existingPerson, PersonDetails inputPerson) {	//code to check equality when no input SSN or no SSN in data
    	
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
    	
	
	public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
        }
}