package com.api.v1.physician.update;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.physician.find_by_mln.FindPhysicianByMln;
import com.api.v1.system_user.UpdatedSystemUserDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdatePhysicianService implements UpdatePhysician {

    private final PhysicianRepository repository;
    private final FindPhysicianByMln findPhysicianByMln;
    
    @Override
    @Transactional
    public ResponseEntity<Void> update(@NotNull @Size(min = 7, max = 7) String mln, @NotNull UpdatedSystemUserDTO dto) {
        Physician physician = findPhysicianByMln.findByMln(mln);
        physician.update(dto);
        repository.save(physician);
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
