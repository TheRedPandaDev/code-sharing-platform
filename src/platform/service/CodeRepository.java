package platform.service;

import org.springframework.data.repository.CrudRepository;
import platform.model.entity.Code;

import java.util.List;

public interface CodeRepository extends CrudRepository<Code, Long> {
    List<Code> findFirst10ByOrderByLocalDateTimeDesc();
}
