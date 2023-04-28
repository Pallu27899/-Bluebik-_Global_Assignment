package com.LotteryApplication.rest;

import com.LotteryApplication.calculation.LotteryCalculationService;
import com.LotteryApplication.winner.LotteryWinnerService;
import com.LotteryApplication.winner.LotteryWinnersStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    private LotteryCalculationService calculationService;

    @Autowired
    private LotteryWinnerService winnerService;

    @Autowired
    private LotteryWinnersStorage winnersStorage;

    @PostMapping("/calculate")
    public ResponseEntity<Void> calculateWinners(@RequestBody List<Integer> lotteryIds) {
        List<Integer> winners = calculationService.calculateWinners(lotteryIds);
        winnerService.storeWinners(winners);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/check/{number}")
    public ResponseEntity<Boolean> checkWinner(@PathVariable int number) {
        boolean isWinner = winnersStorage.isWinner(number);
        return ResponseEntity.ok(isWinner);
    }
}