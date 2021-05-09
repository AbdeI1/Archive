public class DeckStack {

    private int count;
    private Card[] deck;

    public DeckStack(int size){
        deck = new Card[size];
        count = 0;
    }

    public void push(Card c){
        if(isFull()){
            throw new IllegalStateException("Deck Stack is full (push)");
        } else {
            deck[count] = c;
            count++;
        }
    }

    public Card peek(){
        if(isEmpty()){
            throw new IllegalStateException("Deck Stack is empty (peek)");
        } else {
            return deck[count - 1];
        }
    }

    public void pop(){
        if(isEmpty()){
            throw new IllegalStateException("Deck Stack is empty (pop)");
        } else {
            count--;
            deck[count] = null;
        }
    }

    public void flipTop(){
        if(isEmpty()){
            return;
        }
        deck[count - 1].flip();
    }

    public int getCount(){
        return count;
    }

    public Card cardAt(int i){
        return deck[i];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == deck.length;
    }

}
