package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import platform.service.CodeService;

@Controller
public class WebInterfaceController {
    @Autowired
    CodeService codeService;

    @GetMapping(path = "/code")
    public String getCodeSnippet(Model model) {
        model.addAttribute("snippetCode", codeService.getSnippet().getCode())
        .addAttribute("snippetDate", codeService.getSnippet().getDate());
        return "codeSnippet";
    }

    @GetMapping(path = "/code/new")
    public String getNewCode(Model model) {
        return "codeNew";
    }
}
