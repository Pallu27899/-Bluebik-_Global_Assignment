package com.Bankapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bankapp.Service.TransactionService;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/credit")
    public ResponseEntity<Void> credit(@RequestParam Long userId, @RequestParam Double amount) {
        transactionService.credit(userId, amount);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/debit")
    public ResponseEntity<Void> debit(@RequestParam Long userId, @RequestParam Double amount) {
        transactionService.debit(userId, amount);
        return ResponseEntity.ok().build();
    }
    
    
}
