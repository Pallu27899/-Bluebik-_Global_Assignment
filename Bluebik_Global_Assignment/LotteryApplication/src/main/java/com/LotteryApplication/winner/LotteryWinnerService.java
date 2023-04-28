package com.LotteryApplication.winner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LotteryWinnerService {
    
    // Define a List to store the winning lottery numbers
    private List<Integer> winners = new ArrayList<>();
    
    // Define a method to store the winning lottery numbers
    public void storeWinners(List<Integer> lotteryNumbers) {
        winners.addAll(lotteryNumbers);
    }

    // Define a method to check if a number is a winning lottery number
    public boolean isWinner(int num) {
        return winners.contains(num);
    }
}