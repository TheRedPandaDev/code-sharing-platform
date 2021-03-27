package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import platform.model.entity.Code;
import platform.model.entity.CodeDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class CodeServiceImpl implements CodeService {

    private final String DATE_FORMATTER = "yyyy/MM/dd HH:mm:ss";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    @Autowired
    private CodeRepository codeRepository;

    @Override
    public Code getCodeById(String id) {
        Code codeSnippet = codeRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No snippet with such id");
        });

        if (codeSnippet.getTime() >= 1 || codeSnippet.getViews() >= 1) {
            if (codeSnippet.getViews() > 0) {
                codeSnippet.setViewsLimited(true);
                codeSnippet.setViews(codeSnippet.getViews() - 1);
                if (codeSnippet.getViews() < 1) {
                    codeRepository.deleteById(codeSnippet.getId());
                    return codeSnippet;
                }

                codeSnippet = codeRepository.save(codeSnippet);
            }
            if (codeSnippet.getTime() > 0) {
                codeSnippet.setTime(codeSnippet.getTime() -
                        ChronoUnit.SECONDS.between(codeSnippet.getLocalDateTime(), LocalDateTime.now()));
                if (codeSnippet.getTime() < 1) {
                    codeRepository.deleteById(codeSnippet.getId());
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "No snippet with such id");
                }
            }
        }

        return codeSnippet;
    }

    @Override
    public String putCode(CodeDTO newCode) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Code codeToSave = new Code();
        codeToSave.setId(UUID.randomUUID().toString());
        codeToSave.setCode(newCode.getCode());
        codeToSave.setDate(formatter.format(localDateTime));
        codeToSave.setLocalDateTime(localDateTime);
        codeToSave.setTime(newCode.getTime());
        codeToSave.setViews(newCode.getViews());

        return codeRepository.save(codeToSave).getId();
    }

    @Override
    public List<Code> getLatestCode() {
        return codeRepository.getLatestCode();
    }
}
