package sydney.hospital.report.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sydney.hospital.report.beans.request.EstimateRequest;
import sydney.hospital.report.entity.IllnessRecord;
import sydney.hospital.report.repository.IllnessRepository;

import java.util.concurrent.Executor;

@Service
public class PatientService {

    @Autowired
    private IllnessRepository illnessRepository;


    @Qualifier("db")
    @Autowired
    public Executor executor;

    /**
     * add saving job
     * @param request
     */
    public void addSaveJob(EstimateRequest request){

        executor.execute(
                () ->saveRecord(request)
        );
    }

    /**
     * save patient record
     * @param request
     */
    public IllnessRecord saveRecord(EstimateRequest request){

        IllnessRecord illnessRecord = new IllnessRecord();
        illnessRecord.setIllnessId(request.getIllnessId());
        illnessRecord.setPainLevel(request.getPainLevel());

        return illnessRepository.save(illnessRecord);
    }
}
