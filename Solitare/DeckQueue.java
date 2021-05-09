public class DeckQueue {

    private int front;
    private int rear;
    private Card[] deck;
    private int size;

    public DeckQueue(int size){
        front = rear = this.size = 0;
        deck = new Card[size];
    }

    public void enqueue(Card card){
        int nextRear = (rear + 1) % deck.length;
        if(front == nextRear){
            throw new IllegalStateException("Deck is full");
        }
        else{
            rear = nextRear;
            size++;
            deck[rear] = card;
        }
    }

    public Card dequeue(){
        if(front == rear){
            throw new IllegalStateException("Deck is empty");
        }
        else{
            front = (front + 1) % deck.length;
            Card temp = deck[front];
            deck[front] = null;
            size--;
            return temp;
        }
    }

    public Card peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        } else {
            return deck[(front + 1) % deck.length];
        }
    }

    public int getSize(){
        return size;
    }

    public void flipTop(){
        peek().flip();
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return front == (rear + 1) % deck.length;
    }

}
