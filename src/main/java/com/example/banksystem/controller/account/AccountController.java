package com.example.banksystem.controller.account;

import com.example.banksystem.entity.Account;
import com.example.banksystem.service.AccountService;
import com.example.banksystem.service.UserService;
import com.example.banksystem.util.account.AccountGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String listOfUsersAccounts(@PathVariable("id") Long id, Model model) {
        List<Account> accounts = accountService.getAllByUserId(id);
        model.addAttribute("accounts", accounts);
        return "accountList";
    }

    @GetMapping("/new/{id}")
    public String create(@PathVariable("id") Long id, Model model) {
        Account account = new Account();
        account.setId(Long.valueOf(-1));
        account.setBalance(BigDecimal.valueOf(0));
        account.setUser(userService.get(id));
        model.addAttribute("account", account);
        return "accountCreateForm";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("account") Account account) {
        String accountNumber = AccountGenerator.generateAccountNumber(account.getId(), account.getCurrency());
        account.setAccountNumber(accountNumber);
        accountService.save(account);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Account account = accountService.get(id);
        model.addAttribute("account", account);
        return "accountEditForm";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("account") Account account) {
        accountService.update(account);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        accountService.delete(id);
        return "redirect:/users";
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
