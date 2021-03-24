package platform.service;

import platform.model.entity.Code;
import platform.model.entity.CodeDTO;

import java.util.List;

public interface CodeService {
    Code getCodeById(long id);
    long putCode(CodeDTO newCode);
    List<Code> getLatestCode();
}
