package sydney.hospital.report.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import sydney.hospital.report.beans.api.hospital.MedialApiHospitalResponse;
import sydney.hospital.report.beans.api.illnesses.MedialApiIllnessesResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "/application-integrate.properties")
@ActiveProfiles({"integrate"})
public class MedicalApiTest {

    @Autowired
    private MedicalApi medicalApi;

    private WireMockServer wireMockServer;

    @Value("${wire.mock.port}")
    private int port;

    @Before
    public void setUp()  {

        wireMockServer = new WireMockServer(wireMockConfig().port(port));
        wireMockServer.start();
    }

    @Test
    public void testHospitalApi() {

        wireMockServer.stubFor(get("/hospitals")
                .willReturn(okJson("{\n" +
                        "    \"_embedded\": {\n" +
                        "        \"hospitals\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"St Vincent's Hospital\",\n" +
                        "                \"waitingList\": [\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 10,\n" +
                        "                        \"levelOfPain\": 0,\n" +
                        "                        \"averageProcessTime\": 20\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 5,\n" +
                        "                        \"levelOfPain\": 1,\n" +
                        "                        \"averageProcessTime\": 33\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 1,\n" +
                        "                        \"levelOfPain\": 2,\n" +
                        "                        \"averageProcessTime\": 15\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 10,\n" +
                        "                        \"levelOfPain\": 3,\n" +
                        "                        \"averageProcessTime\": 39\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 2,\n" +
                        "                        \"levelOfPain\": 4,\n" +
                        "                        \"averageProcessTime\": 33\n" +
                        "                    }\n" +
                        "                ],\n" +
                        "                \"location\": {\n" +
                        "                    \"lat\": -33.880409,\n" +
                        "                    \"lng\": 151.220958\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"Royal Prince Alfred Hospital\",\n" +
                        "                \"waitingList\": [\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 0,\n" +
                        "                        \"levelOfPain\": 0,\n" +
                        "                        \"averageProcessTime\": 60\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 1,\n" +
                        "                        \"levelOfPain\": 1,\n" +
                        "                        \"averageProcessTime\": 15\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 2,\n" +
                        "                        \"levelOfPain\": 2,\n" +
                        "                        \"averageProcessTime\": 16\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 0,\n" +
                        "                        \"levelOfPain\": 3,\n" +
                        "                        \"averageProcessTime\": 87\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 1,\n" +
                        "                        \"levelOfPain\": 4,\n" +
                        "                        \"averageProcessTime\": 71\n" +
                        "                    }\n" +
                        "                ],\n" +
                        "                \"location\": {\n" +
                        "                    \"lat\": -33.889406,\n" +
                        "                    \"lng\": 151.183488\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 3,\n" +
                        "                \"name\": \"Royal North Shore Hospital\",\n" +
                        "                \"waitingList\": [\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 4,\n" +
                        "                        \"levelOfPain\": 0,\n" +
                        "                        \"averageProcessTime\": 75\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 4,\n" +
                        "                        \"levelOfPain\": 1,\n" +
                        "                        \"averageProcessTime\": 25\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 4,\n" +
                        "                        \"levelOfPain\": 2,\n" +
                        "                        \"averageProcessTime\": 5\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 4,\n" +
                        "                        \"levelOfPain\": 3,\n" +
                        "                        \"averageProcessTime\": 60\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 14,\n" +
                        "                        \"levelOfPain\": 4,\n" +
                        "                        \"averageProcessTime\": 87\n" +
                        "                    }\n" +
                        "                ],\n" +
                        "                \"location\": {\n" +
                        "                    \"lat\": -33.820992,\n" +
                        "                    \"lng\": 151.191415\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"Sydney Children's Hospital\",\n" +
                        "                \"waitingList\": [\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 2,\n" +
                        "                        \"levelOfPain\": 0,\n" +
                        "                        \"averageProcessTime\": 30\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 11,\n" +
                        "                        \"levelOfPain\": 1,\n" +
                        "                        \"averageProcessTime\": 29\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 10,\n" +
                        "                        \"levelOfPain\": 2,\n" +
                        "                        \"averageProcessTime\": 44\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 2,\n" +
                        "                        \"levelOfPain\": 3,\n" +
                        "                        \"averageProcessTime\": 16\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 11,\n" +
                        "                        \"levelOfPain\": 4,\n" +
                        "                        \"averageProcessTime\": 75\n" +
                        "                    }\n" +
                        "                ],\n" +
                        "                \"location\": {\n" +
                        "                    \"lat\": -33.917286,\n" +
                        "                    \"lng\": 151.23767\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 5,\n" +
                        "                \"name\": \"Prince of Wales Hospital\",\n" +
                        "                \"waitingList\": [\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 0,\n" +
                        "                        \"levelOfPain\": 0,\n" +
                        "                        \"averageProcessTime\": 23\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 2,\n" +
                        "                        \"levelOfPain\": 1,\n" +
                        "                        \"averageProcessTime\": 20\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 2,\n" +
                        "                        \"levelOfPain\": 2,\n" +
                        "                        \"averageProcessTime\": 28\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 3,\n" +
                        "                        \"levelOfPain\": 3,\n" +
                        "                        \"averageProcessTime\": 25\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 21,\n" +
                        "                        \"levelOfPain\": 4,\n" +
                        "                        \"averageProcessTime\": 65\n" +
                        "                    }\n" +
                        "                ],\n" +
                        "                \"location\": {\n" +
                        "                    \"lat\": -33.91851,\n" +
                        "                    \"lng\": 151.23897\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 6,\n" +
                        "                \"name\": \"Ryde Hospital\",\n" +
                        "                \"waitingList\": [\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 1,\n" +
                        "                        \"levelOfPain\": 0,\n" +
                        "                        \"averageProcessTime\": 40\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 1,\n" +
                        "                        \"levelOfPain\": 1,\n" +
                        "                        \"averageProcessTime\": 38\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 1,\n" +
                        "                        \"levelOfPain\": 2,\n" +
                        "                        \"averageProcessTime\": 50\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 4,\n" +
                        "                        \"levelOfPain\": 3,\n" +
                        "                        \"averageProcessTime\": 30\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 4,\n" +
                        "                        \"levelOfPain\": 4,\n" +
                        "                        \"averageProcessTime\": 29\n" +
                        "                    }\n" +
                        "                ],\n" +
                        "                \"location\": {\n" +
                        "                    \"lat\": -33.796271,\n" +
                        "                    \"lng\": 151.089709\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 7,\n" +
                        "                \"name\": \"Concord Repatriation General Hospital\",\n" +
                        "                \"waitingList\": [\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 5,\n" +
                        "                        \"levelOfPain\": 0,\n" +
                        "                        \"averageProcessTime\": 42\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 1,\n" +
                        "                        \"levelOfPain\": 1,\n" +
                        "                        \"averageProcessTime\": 16\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 2,\n" +
                        "                        \"levelOfPain\": 2,\n" +
                        "                        \"averageProcessTime\": 80\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 5,\n" +
                        "                        \"levelOfPain\": 3,\n" +
                        "                        \"averageProcessTime\": 44\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 4,\n" +
                        "                        \"levelOfPain\": 4,\n" +
                        "                        \"averageProcessTime\": 23\n" +
                        "                    }\n" +
                        "                ],\n" +
                        "                \"location\": {\n" +
                        "                    \"lat\": -33.835132,\n" +
                        "                    \"lng\": 151.096655\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 8,\n" +
                        "                \"name\": \"St George Hospital\",\n" +
                        "                \"waitingList\": [\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 5,\n" +
                        "                        \"levelOfPain\": 0,\n" +
                        "                        \"averageProcessTime\": 11\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 5,\n" +
                        "                        \"levelOfPain\": 1,\n" +
                        "                        \"averageProcessTime\": 42\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 5,\n" +
                        "                        \"levelOfPain\": 2,\n" +
                        "                        \"averageProcessTime\": 37\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 15,\n" +
                        "                        \"levelOfPain\": 3,\n" +
                        "                        \"averageProcessTime\": 39\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 5,\n" +
                        "                        \"levelOfPain\": 4,\n" +
                        "                        \"averageProcessTime\": 68\n" +
                        "                    }\n" +
                        "                ],\n" +
                        "                \"location\": {\n" +
                        "                    \"lat\": -33.965493,\n" +
                        "                    \"lng\": 151.134032\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 9,\n" +
                        "                \"name\": \"Northern Beaches Hospital\",\n" +
                        "                \"waitingList\": [\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 10,\n" +
                        "                        \"levelOfPain\": 0,\n" +
                        "                        \"averageProcessTime\": 21\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 10,\n" +
                        "                        \"levelOfPain\": 1,\n" +
                        "                        \"averageProcessTime\": 41\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 21,\n" +
                        "                        \"levelOfPain\": 2,\n" +
                        "                        \"averageProcessTime\": 39\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 10,\n" +
                        "                        \"levelOfPain\": 3,\n" +
                        "                        \"averageProcessTime\": 40\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 10,\n" +
                        "                        \"levelOfPain\": 4,\n" +
                        "                        \"averageProcessTime\": 38\n" +
                        "                    }\n" +
                        "                ],\n" +
                        "                \"location\": {\n" +
                        "                    \"lat\": -33.7504,\n" +
                        "                    \"lng\": 151.2326\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 10,\n" +
                        "                \"name\": \"Auburn Hospital & Community Health Services\",\n" +
                        "                \"waitingList\": [\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 1,\n" +
                        "                        \"levelOfPain\": 0,\n" +
                        "                        \"averageProcessTime\": 36\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 6,\n" +
                        "                        \"levelOfPain\": 1,\n" +
                        "                        \"averageProcessTime\": 20\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 3,\n" +
                        "                        \"levelOfPain\": 2,\n" +
                        "                        \"averageProcessTime\": 18\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 4,\n" +
                        "                        \"levelOfPain\": 3,\n" +
                        "                        \"averageProcessTime\": 50\n" +
                        "                    },\n" +
                        "                    {\n" +
                        "                        \"patientCount\": 6,\n" +
                        "                        \"levelOfPain\": 4,\n" +
                        "                        \"averageProcessTime\": 4\n" +
                        "                    }\n" +
                        "                ],\n" +
                        "                \"location\": {\n" +
                        "                    \"lat\": -33.860402,\n" +
                        "                    \"lng\": 151.03362\n" +
                        "                }\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    \"_links\": {\n" +
                        "        \"self\": {\n" +
                        "            \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/hospitals\"\n" +
                        "        },\n" +
                        "        \"next\": {\n" +
                        "            \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/hospitals?limit=10&page=1\"\n" +
                        "        }\n" +
                        "    },\n" +
                        "    \"page\": {\n" +
                        "        \"size\": 10,\n" +
                        "        \"totalElements\": 23,\n" +
                        "        \"totalPages\": 2,\n" +
                        "        \"number\": 0\n" +
                        "    }\n" +
                        "}")));

        MedialApiHospitalResponse response = medicalApi.getHospitalInfo();
        assertThat(response.getInfo().getHospitals().size(),equalTo(10));
    }

    @Test
    public void testIllnesses(){

        wireMockServer.stubFor(get("/illnesses")
                .willReturn(okJson("{\n" +
                        "    \"_embedded\": {\n" +
                        "        \"illnesses\": [\n" +
                        "            {\n" +
                        "                \"illness\": {\n" +
                        "                    \"name\": \"Mortal Cold\",\n" +
                        "                    \"id\": 1\n" +
                        "                },\n" +
                        "                \"_links\": {\n" +
                        "                    \"illnesses\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "                    },\n" +
                        "                    \"self\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/1\"\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"illness\": {\n" +
                        "                    \"name\": \"Happy Euphoria\",\n" +
                        "                    \"id\": 2\n" +
                        "                },\n" +
                        "                \"_links\": {\n" +
                        "                    \"illnesses\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "                    },\n" +
                        "                    \"self\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/2\"\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"illness\": {\n" +
                        "                    \"name\": \"Withering Parasite\",\n" +
                        "                    \"id\": 3\n" +
                        "                },\n" +
                        "                \"_links\": {\n" +
                        "                    \"illnesses\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "                    },\n" +
                        "                    \"self\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/3\"\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"illness\": {\n" +
                        "                    \"name\": \"Death's Delusions\",\n" +
                        "                    \"id\": 4\n" +
                        "                },\n" +
                        "                \"_links\": {\n" +
                        "                    \"illnesses\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "                    },\n" +
                        "                    \"self\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/4\"\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"illness\": {\n" +
                        "                    \"name\": \"Intense Intolerance\",\n" +
                        "                    \"id\": 5\n" +
                        "                },\n" +
                        "                \"_links\": {\n" +
                        "                    \"illnesses\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "                    },\n" +
                        "                    \"self\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/5\"\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"illness\": {\n" +
                        "                    \"name\": \"Whispering Hepatitis\",\n" +
                        "                    \"id\": 6\n" +
                        "                },\n" +
                        "                \"_links\": {\n" +
                        "                    \"illnesses\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "                    },\n" +
                        "                    \"self\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/6\"\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"illness\": {\n" +
                        "                    \"name\": \"Spirit Parasite\",\n" +
                        "                    \"id\": 7\n" +
                        "                },\n" +
                        "                \"_links\": {\n" +
                        "                    \"illnesses\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "                    },\n" +
                        "                    \"self\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/7\"\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"illness\": {\n" +
                        "                    \"name\": \"Crippling Paranoia\",\n" +
                        "                    \"id\": 8\n" +
                        "                },\n" +
                        "                \"_links\": {\n" +
                        "                    \"illnesses\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "                    },\n" +
                        "                    \"self\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/8\"\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"illness\": {\n" +
                        "                    \"name\": \"Sheep Sneeze\",\n" +
                        "                    \"id\": 9\n" +
                        "                },\n" +
                        "                \"_links\": {\n" +
                        "                    \"illnesses\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "                    },\n" +
                        "                    \"self\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/9\"\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"illness\": {\n" +
                        "                    \"name\": \"Impossible Ebola\",\n" +
                        "                    \"id\": 10\n" +
                        "                },\n" +
                        "                \"_links\": {\n" +
                        "                    \"illnesses\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "                    },\n" +
                        "                    \"self\": {\n" +
                        "                        \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses/10\"\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    \"_links\": {\n" +
                        "        \"self\": {\n" +
                        "            \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses\"\n" +
                        "        },\n" +
                        "        \"next\": {\n" +
                        "            \"href\": \"http://dmmw-api.australiaeast.cloudapp.azure.com:8080/illnesses?limit=10&page=1\"\n" +
                        "        }\n" +
                        "    },\n" +
                        "    \"page\": {\n" +
                        "        \"size\": 10,\n" +
                        "        \"totalElements\": 15,\n" +
                        "        \"totalPages\": 1,\n" +
                        "        \"number\": 0\n" +
                        "    }\n" +
                        "}")));

        MedialApiIllnessesResponse response = medicalApi.getIllnessInfo();
        assertThat(response.getIllnessesInfo().getIllnesses().size(),equalTo(10));
        assertThat(response.getIllnessesInfo()
                .getIllnesses().get(0).getIllness().getName(),equalTo("Mortal Cold"));
    }

    @After
    public void tearDown() throws Exception {

        wireMockServer.stop();
    }
}