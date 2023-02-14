package com.example.banksystem.web.account;

import com.example.banksystem.entity.Account;
import com.example.banksystem.service.AccountService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AbstractAccountController {
    protected final static Logger LOG = null;

    @Autowired
    private AccountService accountService;
    public List<Account> getAll() {
        return accountService.getAll();
    }

}
