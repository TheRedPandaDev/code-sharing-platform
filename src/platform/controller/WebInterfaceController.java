package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.service.CodeService;

import javax.validation.constraints.Size;

@Controller
@Validated
public class WebInterfaceController {
    @Autowired
    private CodeService codeService;

    @GetMapping(path = "/code/{id}")
    public String getCodeSnippetById(Model model, @PathVariable("id") @Size(min = 36, max = 36) String id) {
        model.addAttribute("code", codeService.getCodeById(id));
        return "codeSnippet";
    }

    @GetMapping(path = "/code/latest")
    public String getCodeSnippetById(Model model) {
        model.addAttribute("latestCode", codeService.getLatestCode());
        return "codeLatest";
    }

    @GetMapping(path = "/code/new")
    public String getNewCode(Model model) {
        return "codeNew";
    }
}
