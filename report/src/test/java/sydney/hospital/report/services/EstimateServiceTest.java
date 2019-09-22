package sydney.hospital.report.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import sydney.hospital.report.api.MedicalApi;
import sydney.hospital.report.beans.api.hospital.Hospital;
import sydney.hospital.report.beans.api.hospital.HospitalInfo;
import sydney.hospital.report.beans.api.hospital.MedialApiHospitalResponse;
import sydney.hospital.report.beans.api.hospital.WaitingInfo;
import sydney.hospital.report.beans.request.EstimateRequest;
import sydney.hospital.report.beans.response.EstimateResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class EstimateServiceTest {

    @InjectMocks
    private EstimateService estimateService;

    @Mock
    private MedicalApi medicalApi;

    private MedialApiHospitalResponse apiHospitalResponse;

    @Mock
    private PatientService patientService;

    @Before
    public void setup(){

        apiHospitalResponse = new MedialApiHospitalResponse();
        HospitalInfo hospitalInfo = new HospitalInfo();

        apiHospitalResponse.setInfo(hospitalInfo);
        List<Hospital> hospitalList = new ArrayList<>();
        hospitalInfo.setHospitals(hospitalList);

        Hospital hospital1 = new Hospital();
        hospitalList.add(hospital1);

        hospital1.setId(1);
        hospital1.setName("A");
        List<WaitingInfo> waitingInfos = new ArrayList<>();
        hospital1.setWaitingList(waitingInfos);
        WaitingInfo waitingInfo = new WaitingInfo();
        waitingInfos.add(waitingInfo);

        WaitingInfo waitingInfo1 = new WaitingInfo();
        waitingInfos.add(waitingInfo1);
        waitingInfo1.setPatientCount(9);
        waitingInfo1.setAverageProcessTime(3);
        waitingInfo1.setLevelOfPain(1);


        Hospital hospital2 = new Hospital();
        hospitalList.add(hospital2);

        hospital2.setId(2);
        hospital2.setName("B");
        List<WaitingInfo> waitingInfos1 = new ArrayList<>();
        hospital2.setWaitingList(waitingInfos1);
        WaitingInfo waitingInfo3 = new WaitingInfo();
        waitingInfos1.add(waitingInfo3);

        waitingInfo3.setPatientCount(20);
        waitingInfo3.setAverageProcessTime(1);
        waitingInfo3.setLevelOfPain(1);

    }

    @Test
    public void getEstimateTime() {

        when(medicalApi.getHospitalInfo()).thenReturn(apiHospitalResponse);

        EstimateRequest request = new EstimateRequest();
        request.setIllnessId(1);
        request.setPainLevel(1);
        Set<EstimateResult> results = estimateService.getEstimateTime(request);
        assertThat(results.size(),equalTo(2));

        EstimateResult estimateResult = results.iterator().next();
        assertThat(estimateResult.getHospitalName(),equalTo("B"));


    }
}