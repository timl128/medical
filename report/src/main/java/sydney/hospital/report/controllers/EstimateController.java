package sydney.hospital.report.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sydney.hospital.report.beans.request.EstimateRequest;
import sydney.hospital.report.beans.response.EstimateResult;
import sydney.hospital.report.services.EstimateService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@CrossOrigin
public class EstimateController {

    @Autowired
    private EstimateService estimateService;

    @PostMapping("/estimate")
    public Set<EstimateResult> getEstimate(@Valid @RequestBody EstimateRequest request){

        return estimateService.getEstimateTime(request);

    }
}
