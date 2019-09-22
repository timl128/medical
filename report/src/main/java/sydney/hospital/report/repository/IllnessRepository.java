package sydney.hospital.report.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sydney.hospital.report.entity.IllnessRecord;

@Repository
public interface IllnessRepository extends CrudRepository<IllnessRecord,Integer> {
}
