package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import platform.model.entity.Code;
import platform.model.entity.CodeDTO;
import platform.model.entity.Response;
import platform.service.CodeService;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Validated
public class APIController {

    private final CodeService codeService;

    @Autowired
    public APIController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(path = "/code/{id}")
    @ResponseBody
    public ResponseEntity<Code> getCodeSnippetById(@PathVariable("id") @Size(min = 36, max = 36) String id) {
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(codeService.getCodeById(id));
    }

    @GetMapping(path = "/code/latest")
    @ResponseBody
    public ResponseEntity<List<Code>> getLatestCodeSnippets() {
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(codeService.getLatestCode());
    }

    @PostMapping(path = "/code/new")
    @ResponseBody
    public ResponseEntity<Response> putCodeSnippet(@RequestBody @Valid CodeDTO newCode) {
        String id = codeService.putCode(newCode);
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(new Response(id));
    }
}
