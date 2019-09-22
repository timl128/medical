package sydney.hospital.report.beans.api.hospital;

import lombok.Data;

@Data
public class WaitingInfo {

    private int patientCount;
    private int levelOfPain;
    private int averageProcessTime;
}
