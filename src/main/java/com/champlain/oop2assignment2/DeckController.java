package com.champlain.oop2assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.util.Comparator;


import java.util.Arrays;


public class DeckController {
    @FXML
    private TextArea aDeckTextArea;

    @FXML
    private TextArea aHandTextArea;

    @FXML
    private Label aScoreLabel;

    private final Deck aDeck = Deck.getInstance();

    private final Hand aHand = new Hand();

    private boolean isRankFirst = true;  // Flag to track the current sorting strategy

    public void initialize() {
        this.displayCardCollections();
    }

    @FXML
    protected void onShuffleButtonClick() {
        this.aDeck.shuffle();
        this.displayCardCollections();
    }

    @FXML
    protected void onSortButtonClick() {
        // Sort the deck using the current sorting strategy
        Card[] deckArray = aDeck.getDeck();
        Comparator<Card> currentComparator = isRankFirst ? new RankFirstComparator() : new SuitFirstComparator();
        Card.setSortingStrategy(currentComparator);
        Card.sortCards(deckArray);

        // Update the TextArea to display the sorted deck
        aDeckTextArea.setText(formatCards(deckArray));
    }

    @FXML
    protected void onSortByRankButtonClick() {
        // Sort the deck by rank
        Card[] deckArray = aDeck.getDeck();
        Card.setSortingStrategy(new RankFirstComparator());
        Card.sortCards(deckArray);

        // Update the TextArea to display the sorted deck
        aDeckTextArea.setText(formatCards(deckArray));
    }

    @FXML
    protected void onSortBySuitButtonClick() {
        // Sort the deck by suit
        Card[] deckArray = aDeck.getDeck();
        Card.setSortingStrategy(new SuitFirstComparator());
        Card.sortCards(deckArray);

        // Update the TextArea to display the sorted deck
        aDeckTextArea.setText(formatCards(deckArray));
    }




    @FXML
    protected void onScoreButtonClick() {
        aScoreLabel.setText("Not implemented.");
    }

    @FXML
    protected void onDrawButtonClick() {
        if (!this.aDeck.isEmpty()) {
            this.aHand.addCard(aDeck.draw());
        }
        this.displayCardCollections();
    }

    private void displayCardCollections () {
        this.aDeckTextArea.setText(this.aDeck.toString());
        this.aHandTextArea.setText(this.aHand.toString());
    }

    private String formatCards(Card[] cards) {
        // Create a StringBuilder to build the formatted text
        StringBuilder formattedText = new StringBuilder();

        // Append each card to the StringBuilder with a line break
        for (Card card : cards) {
            formattedText.append(card.toString()).append("\n");
        }

        return formattedText.toString();
    }
}