package sydney.hospital.report.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sydney.hospital.report.services.IllnessesService;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({IllnessesController.class})
public class IllnessesControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IllnessesService illnessesService;

    @Test
    public void getIllnesses() throws Exception{

        when(illnessesService.getIllnessList()).thenReturn(new ArrayList<>());

        mvc.perform(get("/illnesses")
                .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().is2xxSuccessful());
    }
}