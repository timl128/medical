package sydney.hospital.report.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sydney.hospital.report.beans.api.illnesses.Illnesses;
import sydney.hospital.report.services.IllnessesService;

import java.util.List;

@RestController
@CrossOrigin
public class IllnessesController {

    @Autowired
    private IllnessesService illnessesService;

    @GetMapping("/illnesses")
    public List<Illnesses> getIllnesses(){

        return illnessesService.getIllnessList();


    }
}
