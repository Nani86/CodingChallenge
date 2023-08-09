package com.DFAS.project.CSVSearchAndAdd;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class PersonServiceTest {

	@InjectMocks
    private PersonService personService;

    @Mock
    private PersonDetails personDetailsMock;

    @Test
    public void testEqualsCheck() {
        // Prepare test data
//        PersonDetails existingPerson = new PersonDetails();
   	 List<PersonDetails> persons = new ArrayList<>();

        PersonDetails person1 = new PersonDetails(); //Reference data
        person1.setFirstName("a");
        person1.setMiddleName("a");
        person1.setLastName("a");
        person1.setSsn("111111111");
        person1.setDob("11111111");
        person1.setAddress("a");
        person1.setCity("a");
        person1.setState("a");
        person1.setZip("111111");
        persons.add(person1);
        
        PersonDetails person2 = new PersonDetails(); //missing SSN. AKA CheckEachField. Also for partial data match
        person2.setFirstName("a");
        person2.setMiddleName("a");
        person2.setLastName("a");
        person2.setSsn("");
        person2.setDob("11111111");
        person2.setAddress("a");
        person2.setCity("a");
        person2.setState("");
        person2.setZip("111111");
        persons.add(person2);
        
        PersonDetails person3 = new PersonDetails(); //CheckEachField data mismatch
        person3.setFirstName("");
        person3.setMiddleName("");
        person3.setLastName("a");
        person3.setSsn("");
        person3.setDob("");
        person3.setAddress("a");
        person3.setCity("x");
        person3.setState("a");
        person3.setZip("");
        persons.add(person3);
        
        PersonDetails person4 = new PersonDetails(); //mismatch data
        person4.setFirstName("g");
        person4.setMiddleName("e");
        person4.setLastName("a");
        person4.setSsn("123456789");
        person4.setDob("");
        person4.setAddress("a");
        person4.setCity("");
        person4.setState("a");
        person4.setZip("");
        persons.add(person4);
        
        PersonDetails person5 = new PersonDetails(); //SSN and DOB mismatch error data
        person5.setFirstName("a");
        person5.setMiddleName("a");
        person5.setLastName("a");
        person5.setSsn("111111111");
        person5.setDob("11111112");
        person5.setAddress("a");
        person5.setCity("a");
        person5.setState("a");
        person5.setZip("111111");
        persons.add(person5);

        PersonDetails person6 = new PersonDetails(); //perfect match with Ssn data
        person6.setFirstName("a");
        person6.setMiddleName("a");
        person6.setLastName("a");
        person6.setSsn("111111111");
        person6.setDob("11111111");
        person6.setAddress("a");
        person6.setCity("a");
        person6.setState("a");
        person6.setZip("111111");
        
        PersonDetails person7 = new PersonDetails(); //All fields empty data
        person7.setFirstName("");
        person7.setMiddleName("");
        person7.setLastName("");
        person7.setSsn("");
        person7.setDob("");
        person7.setAddress("");
        person7.setCity("");
        person7.setState("");
        person7.setZip("");

        
     // Testing the equalsCheck method
        
        //for return 10. AKA equals case
        int r1 = personService.equalscheck(person1, person6);
        assertEquals(10, r1);

      //for return 211. AKA no match case
        int r2 = personService.equalscheck(person1, person4);
        assertEquals(211, r2);

      //for return 12. AKA SSN and DOB error case
        int r3 = personService.equalscheck(person1, person5);
        assertEquals(12, r3);
        
      //for return 212. AKA SSN and DOB error case
        int r4 = personService.equalscheck(person1, person7);
        assertEquals(212, r4);

        //for return checkEachField 10 case
        int r5 = personService.equalscheck(person1, person2);
        assertEquals(10, r5);
        
        
        // Testing the checkEachField method
        
        //for return 10 and partial data match
        int r6 = personService.checkEachField(person1, person2);
        assertEquals(10, r6);
        
      //for return 211. AKA data mismatch
        int r7 = personService.checkEachField(person1, person3);
        assertEquals(211, r7);

    }

    @Test
    public void testUpdateFields() {
    	
        // The following existingPerson and inputPerson data should cover all the possible scenarios for the UpdateFields method.
        PersonDetails existingPerson = new PersonDetails();
        existingPerson.setFirstName("a");
        existingPerson.setMiddleName("");
        existingPerson.setLastName("a");
        existingPerson.setSsn("");
        existingPerson.setDob("");
        existingPerson.setAddress("c");
        existingPerson.setCity("a");
        existingPerson.setState("a");
        existingPerson.setZip("123456");
        

        PersonDetails inputPerson = new PersonDetails();
        inputPerson.setFirstName("a");
        inputPerson.setMiddleName("");
        inputPerson.setLastName("");
        inputPerson.setSsn("123456789");
        inputPerson.setDob("12345678");
        inputPerson.setAddress("a");
        inputPerson.setCity("");
        inputPerson.setState("");
        inputPerson.setZip("123456");

        // Calling the updateFields method.
        personService.updateFields(existingPerson, inputPerson);

        // Verifying that the fields are as expected.
        
        assertEquals("a", existingPerson.getFirstName());
        assertEquals("",existingPerson.getMiddleName());
        assertEquals("a",existingPerson.getLastName());
        assertEquals("123456789",existingPerson.getSsn());
        assertEquals("12345678",existingPerson.getDob());
        assertEquals("a",existingPerson.getAddress());
        assertEquals("a",existingPerson.getCity());
        assertEquals("a",existingPerson.getState());
        assertEquals("123456",existingPerson.getZip());

        
    }

    
}

	


