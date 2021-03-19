package platform.service;

import org.springframework.stereotype.Service;
import platform.model.entity.Code;

@Service
public class CodeServiceImpl implements CodeService {
    @Override
    public Code getFirstSnippet() {
        return new Code("public static void main(String[] args) {" +
                "    SpringApplication.run(CodeSharingPlatform.class, args);" +
                "}");
    }
}
