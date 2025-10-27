Blackjack: Java Console Game 🃏
-----------
This open-source project implements a fully functional Blackjack game in Java, supporting multiple human players against a computer dealer. The game handles player bets, card dealing, dealer logic, and payouts, all in a console-based interface—ideal for demonstrating object-oriented design, inheritance, and game logic implementation.

Overview
--
- Object-Oriented Design
- Built around core classes: Main, Player, Bets, Card, Deck, and Dealer.
- Clear separation of responsibilities: player management, card handling, dealer actions, and game flow.
- Player vs Dealer Gameplay
- Supports 1–10 players.
- Players can place bets and make decisions to hit or stay.
- Dealer follows standard Blackjack rules (hits until 17+).
- Handles Blackjack, busts, wins, losses, and pushes automatically.

Bets & Money Management
--
- Players start with a default balance ($5000).
- Each round, players place bets before receiving cards.
- Payouts are automatically calculated based on game results:
- Win → Double the bet added to player balance
- Push → Bet returned
- Loss → Bet subtracted from balance
- If a player reaches $0, the program optionally grants a minimum amount to continue.

Setup & Usage
--
- 1. Clone the repository: git clone https://github.com/your-username/java-blackjack.git
- cd java-blackjack
- 2. Compile the source files: javac Main.java Player.java Bets.java Card.java Deck.java Dealer.java
- 3. Run the game: java Main

- Follow on-screen prompts to set the number of players, place bets, and play rounds against the dealer.

How It Works
--
Deck & Cards:
- Deck class manages a shuffled 52-card deck.
- Card class represents individual cards with face and suit, and calculates Blackjack values (Aces can count as 1 or 11).
- Player Logic: Player class tracks the hand, total card count, and balance.
- Players can hit (draw a card) or stay, with automatic bust detection.

Bets:
- Bets class extends Player to manage bet amounts and the player placing the bet.

Dealer Logic:
- Dealer starts with two cards (one visible).
- Hits automatically until total is 17 or higher.
- Adjusts Ace values to prevent busting.

Game Flow:
- Players place bets.
- Cards are dealt to players and dealer.
- Players take turns hitting or staying.
- Dealer reveals hand and hits if needed.
- Outcomes are evaluated, balances updated.
- Players can choose to play additional rounds.

Example Gameplay
--
Welcome to Blackjack!
Enter number of players (1-10): 2

Player 1, place your bet: 500
Player 1's hand: 9H 7D | Count: 16
Player 2, place your bet: 300
Player 2's hand: 10C 6S | Count: 16

Dealer shows: 8S [unknown]

Player 1's turn.
Hit or Stay (h/s)? h
Drew: 5D | New hand: 9H 7D 5D | Count: 21

Player 2's turn.
Hit or Stay (h/s)? s

Dealer reveals: 8S 7H | Count: 15
Dealer hits...
Dealer hand: 8S 7H 6C | Count: 21

Player 1 Final Count: 21 | Result: PUSH
Player 2 Final Count: 16 | Result: LOSE

Would you like to play another round? (y/n): n
Thanks for playing!

Features
--
- Fully playable multi-player Blackjack game in the console.
- Automated dealer behavior following standard Blackjack rules.
- Handles betting, winnings, busts, and pushes.
- Robust input validation for bets and player decisions.
- Beginner-friendly and portable — runs on any system with Java 8+.

Future Improvements
--
- Implement split and double down betting options.
- Add a GUI interface using JavaFX or Swing.
- Track player statistics across multiple rounds.
- Implement AI players for automated multiplayer rounds.

License
--
MIT License (see LICENSE file for details).

Contributing
--
Pull requests and issues are welcome.
If you’d like to improve dealer AI, betting options, or add a GUI, feel free to fork the repo and submit a PR.
