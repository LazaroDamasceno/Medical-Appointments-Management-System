package com.api.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.api.v1.physician.hire.HirePhysicianController;
import com.api.v1.physician.hire.HirePhysicianDTO;
import com.api.v1.physician.hire.HirePhysicianService;
import com.api.v1.system_user.RegisterSystemUserDTO;

@ExtendWith(MockitoExtension.class)
public class HirePhysicianControllerTest {

    @Mock
    private HirePhysicianService service;

    @InjectMocks
    private HirePhysicianController controller;

    @Test
    public void testRegisterHiringAPhysician() {

        RegisterSystemUserDTO registerSystemUserDTO = new RegisterSystemUserDTO(
            "Leo", 
            "987654321", 
            "12/12/2000", 
            "leo@leo.com", 
            "1234567890", 
            "m"
        );
        String licenseNumber = "1234567";
        HirePhysicianDTO mockDto = new HirePhysicianDTO(licenseNumber, registerSystemUserDTO);

        HttpStatus status = controller.register(mockDto);

        assertEquals(HttpStatus.CREATED, status);
        Mockito.verify(service, Mockito.times(1)).register(mockDto);
    }
}

