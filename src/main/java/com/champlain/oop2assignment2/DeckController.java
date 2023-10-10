package com.champlain.oop2assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class DeckController {
    @FXML
    private TextArea aDeckTextArea;

    @FXML
    private TextArea aHandTextArea;

    @FXML
    private Label aScoreLabel;

    private final Deck aDeck = Deck.getInstance();

    private final Hand aHand = new Hand();

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
        aDeckTextArea.setText("This does not sort anything yet.");
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
}