package com.champlain.oop2assignment2;

import java.util.Objects;

public class Card {
    private final Suit aSuit;
    private final Rank aRank;

    public Card(Rank pRank, Suit pSuit) {
        this.aRank = pRank;
        this.aSuit = pSuit;
    }

    public Rank getRank() {
        return this.aRank;
    }

    public Suit getSuit() {
        return this.aSuit;
    }

    @Override
    public String toString() {
        return this.aRank + " of " + this.aSuit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card otherCard = (Card) obj;
        return aSuit == otherCard.aSuit && aRank == otherCard.aRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aSuit, aRank);
    }
}
