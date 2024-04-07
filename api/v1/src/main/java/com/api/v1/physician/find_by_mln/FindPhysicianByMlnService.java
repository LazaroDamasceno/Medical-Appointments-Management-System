package com.api.v1.physician.find_by_mln;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPhysicianByMlnService implements FindPhysicianByMln {

	private final PhysicianRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Physician findByMln(@NotNull @Size(min = 7, max = 7) String mln) {
		validatedInput(mln);
		return repository.findByMln(mln).get();
	}
	
	private void validatedInput(String mln) {
		if (repository.findByMln(mln).isEmpty()) throw new PhysicianNotFoundException(mln);
	}

}
