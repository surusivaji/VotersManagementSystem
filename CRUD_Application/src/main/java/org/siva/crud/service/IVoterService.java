package org.siva.crud.service;

import java.util.List;

import org.siva.crud.model.Voter;

public interface IVoterService {
	
	Voter addVoter(Voter voter);
	List<Voter> getAllVoters();
	Voter getVoterById(int id);
	void removeVoter(int id);
	
}
