package platform.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import platform.model.entity.CodeDTO;
import platform.model.entity.NewCode;
import platform.service.CodeService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
@Validated
public class APIController {
    @Autowired
    CodeService codeService;

    @GetMapping(path = "/code")
    @ResponseBody
    public ResponseEntity<CodeDTO> getCodeSnippet() {
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(codeService.getSnippet());
    }

    @PostMapping(path = "/code/new")
    @ResponseBody
    public ResponseEntity<String> updateCodeSnippet(@RequestBody @Valid NewCode newCode) {
        codeService.updateSnippet(newCode);
        return ResponseEntity.ok()
                .body("{}");
    }
}
