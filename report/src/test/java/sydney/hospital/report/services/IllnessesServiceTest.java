package sydney.hospital.report.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import sydney.hospital.report.api.MedicalApi;
import sydney.hospital.report.beans.api.illnesses.Illnesses;
import sydney.hospital.report.beans.api.illnesses.IllnessesDetails;
import sydney.hospital.report.beans.api.illnesses.IllnessesInfo;
import sydney.hospital.report.beans.api.illnesses.MedialApiIllnessesResponse;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class IllnessesServiceTest {

    @InjectMocks
    private IllnessesService illnessesService;

    @Mock
    private MedicalApi medicalApi;

    private MedialApiIllnessesResponse medialApiIllnessesResponse;

    @Before
    public void setUp()  {

        medialApiIllnessesResponse = new MedialApiIllnessesResponse();
        IllnessesInfo illnessesInfo = new IllnessesInfo();
        medialApiIllnessesResponse.setIllnessesInfo(illnessesInfo);

        List<IllnessesDetails> illnesses = new ArrayList<>();
        illnessesInfo.setIllnesses(illnesses);

        IllnessesDetails illnessesDetails = new IllnessesDetails();
        illnesses.add(illnessesDetails);
        Illnesses illness = new Illnesses();
        illnessesDetails.setIllness(illness);
        illness.setId(1);
        illness.setName("A");


    }

    @Test
    public void getIllnessList() {

        when(medicalApi.getIllnessInfo()).thenReturn(medialApiIllnessesResponse);
        List<Illnesses> result = illnessesService.getIllnessList();
        assertThat(result.size(),equalTo(1));
        assertThat(result.get(0).getName(),equalTo("A"));
    }
}