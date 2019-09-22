package sydney.hospital.report.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sydney.hospital.report.services.EstimateService;

import java.util.TreeSet;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({EstimateController.class})
public class EstimateControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EstimateService estimateService;

    @Test
    public void getEstimate() throws Exception{

        when(estimateService.getEstimateTime(any())).thenReturn(new TreeSet<>());

        mvc.perform(post("/estimate")
                .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "\t\"illnessId\" : 1,\n" +
                "\t\"painLevel\" : 1\n" +
                "}")).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getEstimateWithRequestError() throws Exception{

        when(estimateService.getEstimateTime(any())).thenReturn(new TreeSet<>());

        mvc.perform(post("/estimate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"illnessId\" : 1,\n" +
                        "\t\"painLevel\" : 12\n" +
                        "}")).andExpect(status().isBadRequest());
    }
}