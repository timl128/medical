package sydney.hospital.report.beans.api.hospital;

import lombok.Data;

import java.util.List;

@Data
public class Hospital {

    private long id;
    private String name;
    private List<WaitingInfo> waitingList;
}
