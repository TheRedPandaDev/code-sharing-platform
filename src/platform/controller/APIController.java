package platform.controller;

import platform.model.entity.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import platform.service.CodeService;

@RestController
@RequestMapping(path = "/api")
public class APIController {
    @Autowired
    CodeService codeService;

    @GetMapping(path = "/code")
    @ResponseBody
    public ResponseEntity<Code> getCodeSnippet() {
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(codeService.getFirstSnippet());
    }
}
