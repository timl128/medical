package sydney.hospital.report.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sydney.hospital.report.api.MedicalApi;
import sydney.hospital.report.beans.api.illnesses.Illnesses;
import sydney.hospital.report.beans.api.illnesses.IllnessesDetails;
import sydney.hospital.report.beans.api.illnesses.MedialApiIllnessesResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IllnessesService {

    @Autowired
    private MedicalApi medicalApi;


    /**
     * get illness list
     * @return
     */
    public List<Illnesses> getIllnessList(){

        MedialApiIllnessesResponse medialApiIllnessesResponse = medicalApi.getIllnessInfo();
        List<IllnessesDetails> illnessesDetailsList = medialApiIllnessesResponse
                .getIllnessesInfo()
                .getIllnesses();

        return illnessesDetailsList.stream().map(IllnessesDetails::getIllness).collect(Collectors.toList());

    }
}
