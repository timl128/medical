package sydney.hospital.report.beans.api.hospital;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MedialApiHospitalResponse {

    @JsonProperty(value = "_embedded")
    private HospitalInfo info;
}
