
package com.DFAS.project.CSVSearchAndAdd;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;
import org.springframework.stereotype.Repository;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
class MainCSV_noOpenCSVTest {
	
	

	@InjectMocks
    private MainCSV_noOpenCSV mainCSV_noOpenCSV;

    @Mock
    private Scanner scannerMock;

    @Mock
    private PersonService personServiceMock;

    @Test
    public void testApp() throws IOException {
    	
        // Preparing the test data
    	List<PersonDetails> persons = new ArrayList<>();
    	String CSV_FILE_PATH = "C:\\Users\\NaniG\\eclipse-workspace\\CSVSearchAndAdd_Test_v1\\files\\persons.csv";

        
        PersonDetails existingPerson = new PersonDetails(); 
        existingPerson.setFirstName("a");
        existingPerson.setMiddleName("a");
        existingPerson.setLastName("a");
        existingPerson.setSsn("111111111");
        existingPerson.setDob("11111111");
        existingPerson.setAddress("a");
        existingPerson.setCity("a");
        existingPerson.setState("a");
        existingPerson.setZip("111111");
        MainCSV_noOpenCSV.persons.add(existingPerson);
      

        // Mock static methods
        try (MockedStatic<MainCSV_noOpenCSV> mockedStatic = mockStatic(MainCSV_noOpenCSV.class)) {
            
            // Calling the method for testing
            mainCSV_noOpenCSV.App();

            // Verify-ing interactions

            mockedStatic.verify(MainCSV_noOpenCSV::readFromCSV, atLeastOnce());
            mockedStatic.verify(MainCSV_noOpenCSV::writeToCSV, atLeastOnce());
        }
    }

    @Test
    public void testReadFromCSV() throws IOException {
    		//already existing data is reused for testing. Please run the test twice in case of error in this section.

            // Calling the method for testing
            mainCSV_noOpenCSV.readFromCSV();

            // Verifying result
            List<PersonDetails> persons = MainCSV_noOpenCSV.persons;
            
            PersonDetails person = persons.get(0);

            assertEquals("a", person.getFirstName());
            assertEquals("a", person.getMiddleName());
            assertEquals("a", person.getLastName());
            assertEquals("111111111", person.getSsn());
            assertEquals("11111111", person.getDob());
            assertEquals("a", person.getAddress());
            assertEquals("a", person.getCity());
            assertEquals("a", person.getState());
            assertEquals("111111", person.getZip());
        }
    

    @Test
    public void testWriteToCSV() throws IOException {
        // Preparing the test data
        String CSV_FILE_PATH = "C:\\Users\\NaniG\\eclipse-workspace\\CSVSearchAndAdd_Test_v1\\files\\persons.csv";
        PersonDetails person1 = new PersonDetails();
        person1.setFirstName("John");
        person1.setMiddleName("a");
        person1.setLastName("Doe");
        person1.setSsn("123456789");
        person1.setDob("1990-01-01");
        person1.setAddress("123 Main St");
        person1.setCity("City");
        person1.setState("State");
        person1.setZip("123456");
        MainCSV_noOpenCSV.persons.add(person1);


            // Calling the method for testing
            mainCSV_noOpenCSV.writeToCSV();

            // Verifying result
            BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH));
            String line = reader.readLine();
            reader.close();
            assertNotNull(line);            
            String[] data = line.split(",");
            PersonDetails person2 = new PersonDetails();
            int p = MainCSV_noOpenCSV.persons.size() -1;
            person2 = MainCSV_noOpenCSV.persons.get(p);
            assertEquals("John", person2.getFirstName());
            assertEquals("a", person2.getMiddleName());
            assertEquals("Doe", person2.getLastName());
            assertEquals("123456789", person2.getSsn());
            assertEquals("1990-01-01", person2.getDob());
            assertEquals("123 Main St", person2.getAddress());
            assertEquals("City", person2.getCity());
            assertEquals("State", person2.getState());
            assertEquals("123456", person2.getZip());
            
        }

    }
    


 

