package platform.service;

import platform.model.entity.Code;
import platform.model.entity.CodeDTO;

import java.util.List;

public interface CodeService {
    Code getCodeById(String id);

    String putCode(CodeDTO newCode);

    List<Code> getLatestCode();
}
