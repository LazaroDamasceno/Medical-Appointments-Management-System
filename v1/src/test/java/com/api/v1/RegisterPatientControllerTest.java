package com.api.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.api.v1.patient.register.RegisterPatientController;
import com.api.v1.patient.register.RegisterPatientDTO;
import com.api.v1.patient.register.RegisterPatientService;
import com.api.v1.system_user.RegisterSystemUserDTO;

@ExtendWith(MockitoExtension.class)
public class RegisterPatientControllerTest {

    @Mock
    private RegisterPatientService service;

    @InjectMocks
    private RegisterPatientController controller;

    @Test
    public void testRegisterHiringAPhysician() {

        RegisterSystemUserDTO registerSystemUserDTO = new RegisterSystemUserDTO(
            "Leo", 
            "123456789", 
            "12/12/2000", 
            "leo@leo.com", 
            "1234567890", 
            "m"
        );
        RegisterPatientDTO mockDto = new RegisterPatientDTO("St. Dennis", registerSystemUserDTO);

        HttpStatus status = controller.register(mockDto);

        assertEquals(HttpStatus.CREATED, status);
        Mockito.verify(service, Mockito.times(1)).register(mockDto);
    }
    
}
