package blackjack;

//(Eric Taylor, 5/6/22, P.1, Card class used to create a card, or multiple cards, in order to create a deck class that functions with proper values and faces/suits)
public class Card {
// the suit of the card
private int suit;
// the face of the card
private int face;

// creates a card with an assigned face and suit
public Card(int face, int suit) {
  this.face = face;
  this.suit = suit;
}

// creates a random card
public Card() {
  int high = 4;
  int low = 1;
  suit = (int) ((high - low + 1) * Math.random() + low);
  int high1 = 13;
  int low1 = 1;
  face = (int) ((high1 - low1 + 1) * Math.random() + low1);
}

// creates a card from an already existing card, copies it
public Card(Card card) {
  this.face = card.face;
  this.suit = card.suit;
}

// pre: none
// post: generates a random suit value
private int generateSuit() {
  int high = 4;
  int low = 1;
  int suitvalue = (int) ((high - low + 1) * Math.random() + low);
  return suitvalue;
}

// pre: none
// post: generates a random face value
private int generateFace() {
  int high = 13;
  int low = 1;
  int facevalue = (int) ((high - low + 1) * Math.random() + low);
  return facevalue;
}

// pre: none
// post: generates a random card
// note: this method is not used in the program
private void generateCard() {
  face = generateFace();
  suit = generateSuit();
}

// pre: face is initialized, a card exists
// post: returns face as an integer value
public int getFaceNumber() {
  return (face > 10) ? 10 : face;
}

// pre: face is initialized, a card exists
// post: returns the current face value based on the value of the int face
public String getFace() {
  if (face == 1) {
    return "A";
  } else if (face == 2) {
    return "2";
  } else if (face == 3) {
    return "3";
  } else if (face == 4) {
    return "4";
  } else if (face == 5) {
    return "5";
  } else if (face == 6) {
    return "6";
  } else if (face == 7) {
    return "7";
  } else if (face == 8) {
    return "8";
  } else if (face == 9) {
    return "9";
  } else if (face == 10) {
    return "10";
  } else if (face == 11) {
    return "J";
  } else if (face == 12) {
    return "Q";
  } else if (face == 13) {
    return "K";
  } else {
    return "what";
  }
}

// pre: suit is initialized, a card exists
// post: returns the current suit value based on the value of the int suit
public String getSuit() {
  if (suit == 1) {
    return "S";
  } else if (suit == 2) {
    return "C";
  } else if (suit == 3) {
    return "H";
  } else if (suit == 4) {
    return "D";
  } else {
    return "how";
  }
}

// pre: face and suit are initialized, and getFace() and getSuit() are
// funcitonal, a card exists
// post: returns the current card in the format "faceSuit" (for example: "2S")
// (2 of spaces)
public String getCard() {
  return getFace() + getSuit();
}

// pre: face and suit are initialized, a card exists
// post: checks if one card is the same suit and face as another
public boolean equals(Object obj) {
  if (obj instanceof Card) {
    Card c = (Card) obj;
    return this.face == c.face && this.suit == c.suit;
  }
  return false;
}

// pre: getCard() is functional, a card exists
// post: returns card as a string value
public String toString() {
  return getCard();
}
}