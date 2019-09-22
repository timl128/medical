package sydney.hospital.report.beans.api.illnesses;

import lombok.Data;

import java.util.List;

@Data
public class IllnessesInfo {

    private List<IllnessesDetails> illnesses;
}
