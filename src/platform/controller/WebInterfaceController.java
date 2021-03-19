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
        model.addAttribute("snippet", codeService.getFirstSnippet().getCode());
        return "codeSnippet";
    }
}
