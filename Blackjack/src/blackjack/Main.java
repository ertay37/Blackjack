package blackjack;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Deck deck = new Deck();
    int playerAmount = 0, numPlayers = 0;

    System.out.println("Welcome to Blackjack!");
    while (playerAmount < 1 || playerAmount > 10) {
      System.out.print("Enter number of players (1-10): ");
      numPlayers = scan.nextInt();
      playerAmount = numPlayers;

      if (playerAmount < 1 || playerAmount > 10) {
        System.out.println("Invalid number of players");
      }
    }

    // Initial player setup
    System.out.println("\nEach player starts with $5000.");
    ArrayList<Player> players = new ArrayList<>();
    for (int i = 0; i < numPlayers; i++) {
      Card c1 = deck.drawCard();
      Card c2 = deck.drawCard();
      Player p = new Player(c1, c2, 5000);
      players.add(p);
    }

    boolean playAgain = true;
    while (playAgain) {
      if (deck.cardsLeft() < numPlayers * 5 + 10) {
        deck = new Deck(); // reshuffle if running low
        System.out.println("\n[Shuffling a new deck...]\n");
      }

      ArrayList<Bets> bets = new ArrayList<>();

      // Re-deal new hands to players (replacing Player objects but keeping their
      // money)

      for (int i = 0; i < numPlayers; i++) {
        Player old = players.get(i);
        int balance = old.getMoney();

        if (balance == 0) {
          balance = 1000;
          System.out.println("Player " + (i + 1) + " had $0. Granting $1000 to continue.");
        }

        System.out.print("Player " + (i + 1) + ", place your bet: ");
        int amount = scan.nextInt();
        while (amount > balance) {
          System.out.print("Insufficient funds. Enter a valid bet: ");
          amount = scan.nextInt();
        }

        // Deal cards after bet
        Card c1 = deck.drawCard();
        Card c2 = deck.drawCard();
        Player p = new Player(c1, c2, balance - amount);
        players.set(i, p);
        bets.add(new Bets(balance, i + 1, amount));

        System.out.println("Player " + (i + 1) + "'s hand: " + p.getCards() + " | Count: " + p.getCount());
      }

      // Dealer setup
      Dealer dealer = new Dealer(deck);
      System.out.println("\nDealer shows: " + dealer.getKnown());

      // Player turns
      for (int i = 0; i < numPlayers; i++) {
        Player p = players.get(i);
        System.out.println("\nPlayer " + (i + 1) + "'s turn.");
        System.out.println("Current hand: " + p.getCards() + " | Count: " + p.getCount());

        if (p.getCount() == 21) {
          System.out.println("Blackjack!");
        }
        while (p.getCount() < 21) {
          System.out.print("Hit or Stay (h/s)? ");
          String decision = scan.next().toLowerCase();
          if (decision.equals("h")) {
            Card drawn = deck.drawCard();
            p.hit(drawn);
            System.out.println("Drew: " + drawn + " | New hand: " + p.getCards() + " | Count: " + p.getCount());
          } else if (decision.equals("s")) {
            break;
          } else {
            System.out.println("Invalid choice. Please enter 'h' or 's'.");
          }
        }

        if (p.getCount() > 21) {
          System.out.println("Player " + (i + 1) + " busted!");
        }
      }

      // Dealer turn
      System.out.println("\nDealer reveals: " + dealer.getCards() + " | Count: " + dealer.getCount());

      while (dealer.getCount() < 17) {
        System.out.println("Dealer hits...");
        dealer.hit(deck);
        System.out.println("Dealer hand: " + dealer.getCards() + " | Count: " + dealer.getCount());
      }

      if (dealer.getCount() > 21) {
        System.out.println("Dealer busts!");
      }

      // Determine winners
      for (int i = 0; i < numPlayers; i++) {
        Player p = players.get(i);
        Bets b = bets.get(i);
        int playerCount = p.getCount();
        int dealerCount = dealer.getCount();

        System.out.println("\nPlayer " + (i + 1) + " Final Count: " + playerCount);
        if (playerCount > 21) {
          System.out.println("Result: BUST. You lose your bet of $" + b.getCash());
        } else if (dealerCount > 21 || playerCount > dealerCount) {
          System.out.println("Result: WIN! You win $" + b.getCash());
          p.addMoney(b.getCash() * 2);
        } else if (playerCount == dealerCount) {
          System.out.println("Result: PUSH. Your bet is returned.");
          p.addMoney(b.getCash());
        } else {
          System.out.println("Result: LOSE. You lose your bet of $" + b.getCash());
        }

        System.out.println("Player " + (i + 1) + " New Balance: $" + p.getMoney());
      }

      System.out.print("\nWould you like to play another round? (y/n): ");
      String again = scan.next().toLowerCase();
      if (!again.equals("y")) {
        playAgain = false;
      }
    }

    System.out.println("\nThanks for playing!");
    scan.close();
  }
}
