package platform.service;

import org.springframework.stereotype.Service;
import platform.model.entity.Code;
import platform.model.entity.CodeDTO;
import platform.model.entity.NewCode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CodeServiceImpl implements CodeService {
    private static final String DATE_FORMATTER= "yyyy/MM/dd HH:mm:ss";

    Code code = new Code("public static void main(String[] args) {\n" +
            "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
            "}", LocalDateTime.now());

    @Override
    public CodeDTO getSnippet() {
        CodeDTO codeDTO = new CodeDTO();
        codeDTO.setCode(code.getCode());
        codeDTO.setDate(code.getDate().format(DateTimeFormatter.ofPattern(DATE_FORMATTER)));
        return codeDTO;
    }

    @Override
    public void updateSnippet(NewCode newCode) {
        code = new Code(newCode.getCode(), LocalDateTime.now());
    }
}
