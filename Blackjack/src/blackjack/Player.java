package blackjack;

import java.util.ArrayList;

public class Player {
  private int money;
  private ArrayList<Card> hand;
  private int playerCount;
  private String cards;

  public Player(int m) {
    money = m;
  }

  public Player(Card card1, Card card2, int money) {
    this.money = money;
    this.hand = new ArrayList<>();
    this.cards = "";

    addCard(card1);
    addCard(card2);
  }

  public int getCount() {
    return playerCount;
  }

  public int getMoney() {
    return money;
  }

  public void addMoney(int m) {
    money += m;
  }

  public void subtractMoney(int m) {
    money -= m;
  }

  public String getCards() {
    return cards;
  }

  public void hit(Card card) {
    addCard(card);
  }

  public void placeBet(int amount) {
    if (amount > money) {
      System.out.println("Not enough money to place bet.");
    } else {
      money -= amount;
    }
  }

  public void addCard(Card card) {
    hand.add(card);
    cards += " " + card.toString();

    updateCount();
  }

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