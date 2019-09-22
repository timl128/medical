package sydney.hospital.report.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sydney.hospital.report.api.MedicalApi;
import sydney.hospital.report.beans.api.hospital.Hospital;
import sydney.hospital.report.beans.api.hospital.MedialApiHospitalResponse;
import sydney.hospital.report.beans.request.EstimateRequest;
import sydney.hospital.report.beans.response.EstimateResult;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class EstimateService {

    @Autowired
    private MedicalApi medicalApi;

    @Autowired
    private PatientService patientService;

    /**
     * @todo save
     * get estimate time
     * @param request
     */
    public Set<EstimateResult> getEstimateTime(EstimateRequest request){

        MedialApiHospitalResponse apiHospitalResponse = medicalApi.getHospitalInfo();
        List<Hospital> hospitalList = apiHospitalResponse.getInfo().getHospitals();

        Set<EstimateResult> response = new TreeSet<>();

        /**
         * @improvement
         * multiThread O(n^2)
         */
        hospitalList.forEach(
                h ->
                    h.getWaitingList().forEach(

                        w ->{

                            if(w.getLevelOfPain() == request.getPainLevel()){
                                EstimateResult estimateResult = new EstimateResult();
                                estimateResult.setHospitalName(h.getName());
                                estimateResult.setPainLevel(request.getPainLevel());
                                estimateResult.setAverageProcessTime(w.getAverageProcessTime());

                                int newCount = w.getPatientCount() + 1;
                                estimateResult.setNumWaitingPatients(newCount);
                                estimateResult.setTotalWaitTime(newCount * w.getAverageProcessTime());

                                response.add(estimateResult);
                            }
                        }
                    )

        );

        patientService.addSaveJob(request);


        return response;

    }

}
