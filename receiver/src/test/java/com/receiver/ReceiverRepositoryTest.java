package com.receiver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.receiver.entity.Receiver;
import com.receiver.repository.ReceiverRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ReceiverRepositoryTest {
    
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ReceiverRepository repoTest;
	
	@Test
	public void testReceiver() {
	    Receiver receiver = new Receiver();
	    receiver.setId(1232425L);
	    receiver.setName("Sudhanshu");
	    receiver.setDateRequired(new Date());
	    receiver.setAddress("Muzaffarpur");
	    
	     
	    Receiver savedReceiver = repoTest.save(receiver);
	     
	    Receiver existReceiver = entityManager.find(Receiver.class, savedReceiver.getId());
	     
	    assertEquals(receiver.getName(), existReceiver.getName());
	     
	}
}
