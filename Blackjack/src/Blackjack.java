import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args){
		
		System.out.println("¡Bienvenido a un juego de Blackjack!");
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			
		}
		//playingDeck will be the deck the dealer holds
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		
		//playerCards will be the cards the player has in their hand
		Deck playerCards = new Deck();
		//playerMoney holds players cash - we will be lazy and use doubles instead of bigdecimals
		boolean gameOn = true;
		//dealerCards will be the cards the dealer has in their hand
		Deck dealerCards = new Deck();
		
		//Scanner for user input
		Scanner userInput = new Scanner(System.in);
		
		//Play the game while the player has money
		//Game loop
while(gameOn==true){
	System.out.println("Repartiendo...");
	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	boolean endRound = false;
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			
		}
	//Player gets two cards
	playerCards.draw(playingDeck);
	playerCards.draw(playingDeck);
	
	//Dealer gets two cards
	dealerCards.draw(playingDeck);
	dealerCards.draw(playingDeck);
			
			//While loop for drawing new cards
			while(true)
			{
				//Display player cards
				System.out.println("Tu mano:" + playerCards.toString());
				
				//Display Value
				System.out.println("__________________________________");
				System.out.println("|La suma de tus cartas es: " + playerCards.cardsValue()+"|");
				System.out.println("__________________________________");
				
				//Display dealer cards
				System.out.println("La mano del Crupier es: " + dealerCards.getCard(0).toString() +" y "+ dealerCards.getCard(1).toString());
				
				//What do they want to do
				System.out.println("Quieres: (1)Pedir otra or (2)Plantarte");
				int response = userInput.nextInt();	
				//They hit
				if(response == 1){
					playerCards.draw(playingDeck);
					try{
						Thread.sleep(2000);
					}catch(Exception e){
						
					}
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("Sacaste un:" + playerCards.getCard(playerCards.deckSize()-1).toString());
					//Bust if they go over 21
					if(playerCards.cardsValue() > 21){
						System.out.println("Perdiste. La suma de tus cartas es: " + playerCards.cardsValue());
						
						endRound = true;
						break;
					}
				}
				
				//Stand
				if(response == 2){
					break;
				}
				
			}
				
			//Reveal Dealer Cards
			System.out.println("Las cartas del Crupier son:" + dealerCards.toString());
			//See if dealer has more points than player
			if((dealerCards.cardsValue() > playerCards.cardsValue())&&endRound == false){
				System.out.println("El Crupier te ganó, el resultado fue:" + dealerCards.cardsValue() + " a " + playerCards.cardsValue());
				
				endRound = true;
			}
			//Dealer hits at 16 stands at 17
			while((dealerCards.cardsValue() < 17) && endRound == false){
				dealerCards.draw(playingDeck);
				try{
					Thread.sleep(5000);
				}catch(Exception e){
					
				}
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("El crupier saca: " + dealerCards.getCard(dealerCards.deckSize()-1).toString());
			}
			//Display value of dealer
			System.out.println("La mano del crupier es: " + dealerCards.cardsValue());
			//Determine if dealer busted
			if((dealerCards.cardsValue()>21)&& endRound == false){
				System.out.println("El Crupier pierde. Tu ganas!");
				
				endRound = true;
			}
			//Determine if push
			if((dealerCards.cardsValue() == playerCards.cardsValue()) && endRound == false){
				System.out.println("El dealer se queda.");
				endRound = true;
			}
			//Determine if player wins
			if((playerCards.cardsValue() > dealerCards.cardsValue()) && endRound == false){
				System.out.println("Ganaste la mano.");
				
				endRound = true;
			}
			else if(endRound == false) //dealer wins
			{
				System.out.println("El dealer ganó.");
			
			}

			//End of hand - put cards back in deck
			playerCards.moveAllToDeck(playingDeck);
			dealerCards.moveAllToDeck(playingDeck);
			System.out.println("Fin de la ronda.");
			try{
				Thread.sleep(2000);
			}catch(Exception e){
				
			}
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

			System.out.println("Quieres: (1)Seguir jugando otra o (2)Salir");
			
			if( userInput.nextInt()==2){
				System.exit(0);
			}
			
			
			
		}
			//Close Scanner
		userInput.close();
		
	}
	
	
}
