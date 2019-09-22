package sydney.hospital.report.beans.response;

import lombok.Data;

@Data
public class EstimateResult implements Comparable<EstimateResult>{

    private int painLevel;
    private String hospitalName;
    private int averageProcessTime;
    private int numWaitingPatients;
    private int totalWaitTime;

    @Override
    public int compareTo(EstimateResult o) {
        return totalWaitTime - o.getTotalWaitTime();
    }
}
