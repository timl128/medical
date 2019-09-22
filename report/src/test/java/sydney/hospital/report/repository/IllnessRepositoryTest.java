package sydney.hospital.report.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sydney.hospital.report.entity.IllnessRecord;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IllnessRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IllnessRepository illnessRepository;

    @Test
    public void testSaveRecord(){

        IllnessRecord illnessRecord = new IllnessRecord();
        illnessRecord.setPainLevel(1);
        illnessRecord.setIllnessId(1);

        illnessRepository.save(illnessRecord);

        long count = illnessRepository.count();
        assertThat(count,equalTo(1L));

    }
}