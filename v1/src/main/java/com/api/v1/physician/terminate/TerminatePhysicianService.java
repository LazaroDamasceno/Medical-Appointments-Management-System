package com.api.v1.physician.terminate;

import java.time.ZonedDateTime;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.AsyncHttpStatus;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.physician.find_by_mln.FindPhysicianByMlnService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TerminatePhysicianService implements TerminatePhysician {
	
	private final PhysicianRepository repository;
	private final FindPhysicianByMlnService findPhysicianByMln;

	@Override
	public CompletableFuture<ResponseEntity<Void>> terminate(@NotBlank @Size(min = 7, max = 7) String mln) {
		Physician physician = findPhysicianByMln.findByMln(mln);
		ZonedDateTime now = ZonedDateTime.now();
		physician.setTerminationDateTime(now);
		repository.save(physician);
		return AsyncHttpStatus.NO_CONTENT_204;
	}

}
