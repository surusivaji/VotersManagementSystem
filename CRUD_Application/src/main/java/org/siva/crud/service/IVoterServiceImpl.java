package org.siva.crud.service;

import java.util.List;
import java.util.Optional;

import org.siva.crud.model.Voter;
import org.siva.crud.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class IVoterServiceImpl implements IVoterService {
	
	@Autowired
	private VoterRepository voterRepository;
	
	@Override
	public Voter addVoter(Voter voter) {
		Voter save = voterRepository.save(voter);
		if (save!=null) {
			return save;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Voter> getAllVoters() {
		List<Voter> findAll = voterRepository.findAll();
		return findAll;
	}
	
	@Override
	public Voter getVoterById(int id) {
		Optional<Voter> optional = voterRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	@Override
	public void removeVoter(int id) {
		voterRepository.deleteById(id);
	}

}
