package com.receiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.receiver.entity.Receiver;

public interface ReceiverRepository extends JpaRepository<Receiver, Long>{
	//public Receiver save(Receiver receiver);
	

}
