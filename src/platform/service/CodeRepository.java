package platform.service;

import platform.model.entity.Code;

import java.util.List;

public interface CodeRepository {
    Code getCodeById(long id);
    void putCode(Code code);
    List<Code> getLatestCode();
}
