package blackjack;

// bets class is used to extend the player class in order to allow them to place bets
public class Bets extends Player {
// the number that correlates to the player who is putting in their bets
int playerNumber = 0;
// amount of money being put in
int cash = 0;
public Bets(int money, int player, int amount) {
  super(money);
  playerNumber = player;
  cash = amount;
}


// pre: playerNumber is initialized, a bet exists
// post: returns the player who is betting
public int getPlayer() {
  return playerNumber;
}

// pre: none
// post: allows someone to change who they are betting on/who the bet is for
public void changeBet(int p) {
  playerNumber = p;
}

// pre: cash is initialized, a bet exists
// post: returns cash
public int getCash() {
  return cash;
}
}
