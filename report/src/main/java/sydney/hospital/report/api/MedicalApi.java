package sydney.hospital.report.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import sydney.hospital.report.beans.api.hospital.MedialApiHospitalResponse;
import sydney.hospital.report.beans.api.illnesses.MedialApiIllnessesResponse;

@Service
@FeignClient(name = "medicalapi" , url = "${medical_url}")
public interface MedicalApi {

    @GetMapping("/hospitals")
    MedialApiHospitalResponse getHospitalInfo();

    @GetMapping("/illnesses")
    MedialApiIllnessesResponse getIllnessInfo();
}
