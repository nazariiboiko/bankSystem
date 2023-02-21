package com.example.banksystem.controller.account;

import com.example.banksystem.entity.Account;
import com.example.banksystem.entity.User;
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
        account.setId(-1L);
        account.setBalance(BigDecimal.valueOf(0));
        model.addAttribute("account", account);
        model.addAttribute("id", id);
        return "accountCreateForm";
    }

    @PostMapping("/new/{id}")
    public String create(@PathVariable("id") Long id, @ModelAttribute("account") Account account) {
        User user = userService.get(id);
        account.setUser(user);
        String accountNumber = AccountGenerator.generateAccountNumber(user.getId(), account.getCurrency());
        account.setAccountNumber(accountNumber);
        accountService.save(account);
        return "redirect:/accounts/" + id;
    }

    @PostMapping("/block/{userId}/{accountId}")
    public String blockAccount(@PathVariable("userId") Long userId, @PathVariable("accountId") Long accountId) {
        accountService.block(accountId);
        return "redirect:/accounts/" + userId;
    }

    @PostMapping("/delete/{userId}/{accountId}")
    public String delete(@PathVariable("userId") Long userId, @PathVariable("accountId") Long accountId) {
        accountService.delete(accountId);
        return "redirect:/accounts/" + userId;
    }

    public String replenishBalance(Model model) {
        throw new UnsupportedOperationException();
    }

    public String withdrawBalance(Model model) {
        throw new UnsupportedOperationException();
    }

    public String getTransaction(Model model) {
        throw new UnsupportedOperationException();
    }

    public String transferMoney(Model model) {
        throw new UnsupportedOperationException();
    }


}
