package com.LotteryApplication.winner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LotteryWinnersStorage {

    private Set<Integer> winners = new HashSet<>();

    public void addWinners(List<Integer> newWinners) {
        winners.addAll(newWinners);
    }

    public boolean isWinner(int number) {
        return winners.contains(number);
    }
}