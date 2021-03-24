package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.model.entity.Code;
import platform.model.entity.CodeDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {
    private static long currentId = 1;

    @Autowired
    private CodeRepository codeRepository;

    private final String DATE_FORMATTER= "yyyy/MM/dd HH:mm:ss";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    @Override
    public Code getCodeById(long id) {
        return codeRepository.getCodeById(id);
    }

    @Override
    public long putCode(CodeDTO newCode) {
        long id = currentId++;
        LocalDateTime localDateTime = LocalDateTime.now();
        codeRepository.putCode(
                new Code(id, newCode.getCode(), formatter.format(localDateTime), localDateTime)
        );
        return id;
    }

    @Override
    public List<Code> getLatestCode() {
        return codeRepository.getLatestCode();
    }
}
