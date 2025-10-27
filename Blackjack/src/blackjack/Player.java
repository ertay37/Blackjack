package blackjack;

import java.util.ArrayList;

public class Player {
  private int money;
  private ArrayList<Card> hand;
  private int playerCount;
  private String cards;

  // pre: m is a non-negative integer
  // post: creates a player with money = m, empty hand, and count = 0
  public Player(int m) {
    money = m;
  }

  // pre: card1 and card2 are valid Card objects, money >= 0
  // post: creates a player with hand containing card1 and card2, updates playerCount and cards string
  public Player(Card card1, Card card2, int money) {
    this.money = money;
    this.hand = new ArrayList<>();
    this.cards = "";

    addCard(card1);
    addCard(card2);
  }

  // pre: hand exists and contains valid cards
  // post: returns playerCount as an integer
  public int getCount() {
    return playerCount;
  }

  // pre: money has been initialized
  // post: returns money
  public int getMoney() {
    return money;
  }

  // pre: m >= 0
  // post: increases money by m
  public void addMoney(int m) {
    money += m;
  }

  // pre: m >= 0
  // post: decreases money by m
  public void subtractMoney(int m) {
    money -= m;
  }

  // pre: hand exists
  // post: returns cards string
  public String getCards() {
    return cards;
  }

  // pre: card is a valid Card object
  // post: adds card to hand and updates playerCount and cards string
  public void hit(Card card) {
    addCard(card);
  }

  // pre: amount >= 0
  // post: if amount <= money, subtracts amount from money; otherwise, prints error
  public void placeBet(int amount) {
    if (amount > money) {
      System.out.println("Not enough money to place bet.");
    } else {
      money -= amount;
    }
  }

  // pre: card is a valid Card object
  // post: appends card to hand, updates cards string, and recalculates playerCount
  public void addCard(Card card) {
    hand.add(card);
    cards += " " + card.toString();

    updateCount();
  }

  // pre: hand contains valid cards
  // post: updates playerCount considering Aces as 1 or 11 to avoid busting
  private void updateCount() {
    playerCount = 0;
    int aceCount = 0;

    for (Card c : hand) {
      int val = c.getFaceNumber();
      if (val == 1) {
        aceCount++;
        val = 11;
      }
      playerCount += val;
    }

    while (playerCount > 21 && aceCount > 0) {
      playerCount -= 10;
      aceCount--;
    }
  }
}
