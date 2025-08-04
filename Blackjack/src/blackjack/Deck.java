package blackjack;

//(Eric Taylor, 5/6/22, P.1, Deck class used to create a deck, or multiple decks, that will be utilized in order to create a dealer class or to be utilized in other classes)
import java.util.ArrayList;

public class Deck {
// the deck that the dealer will use
private ArrayList<Card> deck;
int currentCardIndex = 0;
int next = 0;

// creates a new deck
public Deck() {
  deck = new ArrayList<Card>();
  reset();
}

// copies an already existing deck
public Deck(Deck d) {
  deck = d.deck;
}

public int cardsLeft() {
  return deck.size();
}

// pre: a deck exists
// post: resets deck to the original order of cards, sorts the deck
public void reset() {
  deck.clear();
  for (int s = 1; s <= 4; s++) {
    for (int f = 1; f <= 13; f++) {
      deck.add(new Card(f, s));
    }
  }

  shuffle();
  currentCardIndex = 0;
}

// pre: a deck exists
// post: shuffles the deck and sets each card to a new random position in the
// deck
public void shuffle() {
  ArrayList<Card> tempDeck = new ArrayList<Card>();
  int size = this.deck.size();
  for (int i = 0; i < size; i++) {
    int index = (int) (Math.random() * (this.deck.size()));
    tempDeck.add(this.deck.get(index));
    this.deck.remove(index);
  }

  this.deck = tempDeck;
}

// pre: a deck exists
// post: returns the next card in the deck and removes it from the deck, putting
// another card to be played next
public Card drawCard() {
  currentCardIndex++;
  return deck.remove(next);
}

// pre: a deck exists
// post: returns any card of your choice
public Card getCard(int index) {
  return deck.get(index);
}

// pre: a deck exists
// post: returns the next card up in the deck
public Card getNextCard() {
  return deck.get(next);
}

// pre: a deck exists
// post: returns cards as a string value
public String toString() {
  String str = "";
  for (int i = 0; i < 52; i++) {
    str = str + deck.get(i) + " ";
  }
  return str;
}
}