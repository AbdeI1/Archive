import java.util.Random;

class Deck {

    Card[] deck = new Card[52];
    int top;

    public Deck(){
        for(int i = 0; i < 13; i ++){
            for(int j = 0; j < 4; j++){
                deck[(4 * i) + j] = new Card(i, j);
            }
        }
        top = 51;
    }

    public Card deal(){
        if(top == -1){
            throw new IllegalStateException("Deck is empty");
        } else {
            top--;
            return (deck[top + 1]);
        }
    }

    public void shuffle(){
        Random r = new Random();
        if(top < 51){
            throw new IllegalStateException("Cannot shuffle after dealing");
        } else {
            for(int i = 51; i > 0; i--){     //At this point, size of deck should always be 51, so no need to use deck.length
                int j = Math.abs(r.nextInt()) % i;
                Card temp = deck[j];
                deck[j] = deck[i];
                deck[i] = temp;
            }
        }
    }

}
