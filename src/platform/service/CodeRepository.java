package platform.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.model.entity.Code;

import java.util.List;

@Repository
public interface CodeRepository extends CrudRepository<Code, String> {
//    List<Code> findFirst10ByOrderByLocalDateTimeDesc();
    @Query(value = "SELECT * FROM CODE WHERE TIME < 1 AND VIEWS < 1 ORDER BY LOCAL_DATE_TIME DESC LIMIT 10", nativeQuery = true)
    List<Code> getLatestCode();
}
