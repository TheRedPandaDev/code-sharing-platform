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

    @Autowired
    private CodeRepository codeRepository;

    private final String DATE_FORMATTER= "yyyy/MM/dd HH:mm:ss";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    @Override
    public Code getCodeById(long id) {
        return codeRepository.findById(id).orElseThrow();
    }

    @Override
    public long putCode(CodeDTO newCode) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Code codeToSave = new Code();
        codeToSave.setCode(newCode.getCode());
        codeToSave.setDate(formatter.format(localDateTime));
        codeToSave.setLocalDateTime(localDateTime);

        return codeRepository.save(codeToSave).getId();
    }

    @Override
    public List<Code> getLatestCode() {
        return codeRepository.findFirst10ByOrderByLocalDateTimeDesc();
    }
}
