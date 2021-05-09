class Pile {

    private class Layer{

        private Card card;
        private Layer next;

        private Layer(Card card, Layer next){
            this.card = card;
            this.next = next;
        }

    }

    private Layer top;
    private int size;

    public Pile(){
        top = null;
        size = 0;
    }

    public void add(Card card){
        top = new Layer(card, top);
        size++;
    }

    public Card peek(){
        if(isEmpty()){
            throw new IllegalStateException("Pile is Empty");
        }
        return top.card;
    }

    public int getSize(){
        return size;
    }

    public void flipTop(){
        top.card.flip();
    }

    public Card draw(){
        if(isEmpty()){
            throw new IllegalStateException("Pile is empty");
        } else {
            Card temp = top.card;
            top = top.next;
            size--;
            return(temp);
        }
    }

    public boolean isEmpty(){
        return top == null;
    }

}
