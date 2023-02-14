package com.example.banksystem.web.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/accounts")
public class AccountController extends AbstractAccountController {

    @RequestMapping(method = RequestMethod.GET)
    public String accountList(Model model) {
        model.addAttribute("accountList", super.getAll());
        return "accountList";
    }
}
