package com.example.banksystem.controller.account;

import com.example.banksystem.entity.Account;
import com.example.banksystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @RequestMapping(method = RequestMethod.GET)
    public String accountList(Model model) {
        model.addAttribute("accountList", accountService.getAll());
        return "accountList";
    }

    public String create(Model model) {
        throw new UnsupportedOperationException();
    }

    public String create(@ModelAttribute("account") Account account) {
        throw new UnsupportedOperationException();
    }
    public String update(Model model) {
        throw new UnsupportedOperationException();
    }

    public String delete(@PathVariable Long id) {
        throw new UnsupportedOperationException();
    }

    public String replenishBalance(Model model) {
        throw new UnsupportedOperationException();
    }

    public String getTransaction(Model mode) {
        throw new UnsupportedOperationException();
    }

    public String transferMoney(Model model) {
        throw new UnsupportedOperationException();
    }


}
