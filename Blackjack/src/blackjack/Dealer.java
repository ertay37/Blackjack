package blackjack;


// dealer class used to carry out dealer actions such as dealing and displaying cards
import java.util.ArrayList;

public class Dealer {
// a list to store the cards the dealer hits for
private ArrayList<Integer> list = new ArrayList<Integer>();
// the current cards that the dealer has
String cards;
// the known card that the dealer has
String known;
// extra variable just incase dealer needs to hit
String hit;
// count 1,2, and 3
int c1;
int c2;
int c3;
// the current count of the dealers cards (ex: a 2 and a 4 would result in count
// equaling 6)
int dealerCount = 0;

// a random dealer constructor with random card values
public Dealer(Deck d) {
  Card a = d.drawCard();
  known = a.toString();
  int val1 = a.getFaceNumber();
  if (val1 == 1) val1 = 11;
  list.add(val1);

  Card b = d.drawCard();
  String temp = b.toString();
  cards = known + " " + temp;
  int val2 = b.getFaceNumber();
  if (val2 == 1) val2 = 11;
  list.add(val2);

  dealerCount = val1 + val2;

  // Adjust for Aces if over 21
  for (int i = 0; i < list.size(); i++) {
    if (dealerCount > 21 && list.get(i) == 11) {
      list.set(i, 1);
      dealerCount -= 10;
    }
  }
}

// pre: a dealer with set initial card values
// post: c1 = card 1, v1 = value 1
public Dealer(String co1, String co2, int v1, int v2) {
  known = co1;
  cards = co1 + " " + co2;
  dealerCount = v1 + v2;
}

// pre: known is initialized, a dealer exists
// post: returns the card that will be known to the players before they make
// their bets
public String getKnown() {
  return known + " " + "[unknown]";
}

// pre: cards is initialized, a dealer exists
// post: returns both of the dealer's cards
public String getCards() {
  return cards;
}

// pre: dealerCount is initialized, a dealer exists
// post: returns the dealer's current count of cards
public int getCount() {
  return dealerCount;
}

// pre: c1 is initialized, a dealer exists
// post: returns the dealer's currently known count of cards
public int getKnownCount() {
  return c1;
}

// pre: none
// post: sets the dealers cards and card value to the creator's choice
public void setDeck(String co1, String co2, int v1, int v2) {
  known = co1;
  cards = co1 + " " + co2;
  dealerCount = v1 + v2;
}

// pre: a dealer constructor is already initialzied
// post: dealer's deck is reseet
public void dealerReset(Deck d) {
  Card a = d.drawCard();
  known = a.toString();
  Card b = d.drawCard();
  String temp = b.toString();
  cards = known + " " + temp;
  c1 = a.getFaceNumber();
  c2 = b.getFaceNumber();
  if (c1 == 1) {
    c1 = 11;
  }
  if (c2 == 1) {
    c2 = 11;
  }
  dealerCount = c1 + c2;
  if (c1 == 11 && dealerCount > 21) {
    c1 = 1;
  }
  dealerCount = c1 + c2;
  if (c2 == 11 && dealerCount > 21) {
    c2 = 1;
  }
  dealerCount = c1 + c2;
}

// pre: c1 is initialized and c2 is initialized, a dealer exists
// post: deals the dealer another card
public String hit(Deck d) {
  Card c = d.drawCard();
  hit = c.toString();
  int value = c.getFaceNumber();

  // treat Ace as 11 initially
  if (value == 1) {
    value = 11;
  }

  cards += " " + hit;
  dealerCount += value;
  list.add(value);

  // adjust any 11s (aces) to 1 if over 21
  for (int i = 0; i < list.size(); i++) {
    if (dealerCount > 21 && list.get(i) == 11) {
      list.set(i, 1);
      dealerCount -= 10;
    }
  }

  return cards;
}

}
