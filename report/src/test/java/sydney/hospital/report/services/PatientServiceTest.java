package sydney.hospital.report.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import sydney.hospital.report.beans.request.EstimateRequest;
import sydney.hospital.report.entity.IllnessRecord;
import sydney.hospital.report.repository.IllnessRepository;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PatientServiceTest {

    @InjectMocks
    private PatientService patientService;

    @Mock
    private IllnessRepository illnessRepository;

    @Test
    public void saveRecord() {

        EstimateRequest request = new EstimateRequest();
        request.setIllnessId(1);
        request.setPainLevel(1);
        when(illnessRepository.save(any())).thenReturn(new IllnessRecord());
        IllnessRecord illnessRecord = patientService.saveRecord(request);
        assertNotNull(illnessRecord);
    }
}