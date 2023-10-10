package com.champlain.oop2assignment2;

import java.util.Comparator;

public class SuitFirstComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        // Compare by suit first
        int suitComparison = card1.getSuit().compareTo(card2.getSuit());

        // If suits are the same, compare by rank
        if (suitComparison == 0) {
            return card1.getRank().compareTo(card2.getRank());
        }

        return suitComparison;
    }
}

