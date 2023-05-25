package io.buza.chapter2.controller;


import io.buza.chapter2.pojo.Account;
import io.buza.chapter2.response.util.ResponseUtils;
import io.buza.chapter2.vo.ResultMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fund")
public class AccountController {

    @GetMapping("/account/page")
    public String page() {
        return "account";
    }

    @GetMapping("/account/{id}") // @GetMapping代表GET请求
    @ResponseBody // 结果转换为JSON
    public Account getAccount(@PathVariable Long id) {
        Account account = new Account();
        account.setId(id);
        account.setAccountName("account_" + id);
        double balance = id %10 * 10000.0 * Math.random();
        account.setBalance(balance);
        account.setNote("note_" + id);
        return account;
    }

    @PostMapping("/account") // POST请求
    @ResponseBody
    public Account createAccount(@RequestBody Account account) {
        long id = (long)(10000.0*Math.random());
        account.setId(id);
        return account;
    }

    @PutMapping("/account") // HTTP PUT请求
    @ResponseBody
    public ResultMessage updateAccount(@RequestBody Account account) {
        System.out.println("更新账户");
        return new ResultMessage(true, "更新账户成功");
    }

    @PostMapping("/account2") // POST请求
    @ResponseBody
    public ResponseEntity<Account> createAccount2(@RequestBody Account account) {
        // 异常标志
        boolean exFlag = false;
        try {
            long id = (long) (10000.0 * Math.random());
            account.setId(id);
            // 测试时可自己加入异常测试异常情况
            throw new RuntimeException();
        } catch (Exception ex) {
            // 设置异常标志为true
            exFlag = true;
        }
        return exFlag ?
                ResponseUtils.generateResponseEntity(account, // 异常处理
                        HttpStatus.OK, false, "create account error,plz check ur input!!") :
                ResponseUtils.generateResponseEntity(account, // 正常返回
                        HttpStatus.CREATED, true, "create account success!!");
    }

}
