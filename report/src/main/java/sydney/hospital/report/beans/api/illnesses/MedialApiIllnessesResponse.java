package sydney.hospital.report.beans.api.illnesses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MedialApiIllnessesResponse {

    @JsonProperty(value = "_embedded")
    private IllnessesInfo illnessesInfo;
}
