package platform.service;

import platform.model.entity.CodeDTO;
import platform.model.entity.NewCode;

public interface CodeService {
    CodeDTO getSnippet();
    void updateSnippet(NewCode newCode);
}
