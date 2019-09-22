package sydney.hospital.report.beans.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class EstimateRequest {

    @NotNull
    private Integer illnessId;

    @Min(0)
    @Max(4)
    @NotNull
    private Integer painLevel;
}
