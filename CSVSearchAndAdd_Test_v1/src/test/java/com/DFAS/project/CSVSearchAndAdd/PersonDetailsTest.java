package com.DFAS.project.CSVSearchAndAdd;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class PersonDetailsTest {

	@Test
	public void testEmptyValues() {
		//Preparing the test data
        PersonDetails person = new PersonDetails();
        person.setFirstName(null);
        person.setMiddleName("  ");
        person.setLastName(" ");
        person.setSsn("123456789");
        person.setDob("");
        
        //Calling and testing the method
        assertTrue(PersonDetails.isEmpty(person.getFirstName()));
        assertTrue(PersonDetails.isEmpty(person.getMiddleName()));
        assertTrue(PersonDetails.isEmpty(person.getLastName()));
        assertFalse(PersonDetails.isEmpty(person.getSsn()));
        assertTrue(PersonDetails.isEmpty(person.getDob()));
    }

}
