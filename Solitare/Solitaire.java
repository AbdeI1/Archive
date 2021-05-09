class Solitaire {

    DeckStack[] board;
    Pile[] sets;
    Deck deck;
    DeckQueue dQ;

    public Solitaire(){
        board = new DeckStack[7];
        sets = new Pile[4];
        deck = new Deck();
        deck.shuffle();
        for(int i = 1; i <= 7; i++){
            board[i - 1] = new DeckStack(20);
            for(int j = 0; j < i; j++){
                board[i - 1].push(deck.deal());
            }
            board[i-1].flipTop();
        }
        dQ = new DeckQueue(25);
        for(int i = 0; i < 24; i++){
            dQ.enqueue(deck.deal());
        }
        for(int i = 0; i < 4; i++){
            sets[i] = new Pile();
        }
        dQ.flipTop();
    }

    public void draw(){
        Card x = dQ.dequeue();
        x.flip();
        dQ.enqueue(x);
        dQ.flipTop();
    }

    public void move(int from, int to){
        if(from >= 8 || from <= -1 || to <= -1 || to >= 8){
            throw new IllegalStateException("Not a valid number");
        }
        if(to == 0){
            throw new IllegalStateException("Not allowed to move to deck");
        }
        if(from == 0){
            Card f = dQ.peek();
            if(f.getRank() == 12 && board[to - 1].isEmpty()){
                dQ.dequeue();
                dQ.flipTop();
                board[to - 1].push(f);
                System.out.println("Card moved");
                return;
            }
            Card t = board[to - 1].peek();
            if(f.getRank() == t.getRank() - 1 && !(f.getColor().equals(t.getColor()))){
                dQ.dequeue();
                dQ.flipTop();
                board[to - 1].push(f);
                System.out.println("Card moved");
            } else {
                System.out.println("Not a legal move");
            }
        } else {
            Card f = board[from - 1].peek();
            Card t = board[to - 1].peek();
            if(f.getRank() == t.getRank() - 1 && !(f.getColor().equals(t.getColor()))){
                board[from - 1].pop();
                board[from - 1].flipTop();
                board[to - 1].push(f);
                System.out.println("Card moved");
            } else {
                System.out.println("Not a legal move");
            }
        }
    }

    public void moveStack(int from, int to){
        if(from >= 8 || from <= -1 || to <= -1 || to >= 8){
            throw new IllegalStateException("Not a valid number");
        }
        if(to == 0 || from == 0){
            throw new IllegalStateException("Not allowed to move to or from deck");
        }
        Pile temp = new Pile();
        int f = from - 1;
        int t = to - 1;
        while(board[f].peek().getFace()){
            temp.add(board[f].peek());
            board[f].pop();
            if(board[f].isEmpty()){
                break;
            }
        }
        Card fn = temp.peek();
        if(fn.getRank() == 12 && board[t].isEmpty()){
            while(!(temp.isEmpty())){
                board[t].push(temp.draw());
            }
            board[f].flipTop();
            System.out.println("Pile moved");
            return;
        }
        Card tn = board[t].peek();
        if(fn.getRank() == tn.getRank() - 1 && !(fn.getColor().equals(tn.getColor()))){
            while(!(temp.isEmpty())){
                board[t].push(temp.draw());
            }
            board[f].flipTop();
            System.out.println("Pile moved");
        } else {
            while(!(temp.isEmpty())){
                board[f].push(temp.draw());
            }
            System.out.println("Not a legal move");
        }
    }

    public void moveToSet(int f){
        if(f <= -1 || f >= 8){
            throw new IllegalStateException("Not a valid number");
        }
        Card c;
        if(f == 0){
            c = dQ.peek();
            if(c.getRank() == 0){
                dQ.dequeue();
                dQ.flipTop();
                sets[c.getSuit()].add(c);
                System.out.println("Card moved");
            } else if(c.getRank() == sets[c.getSuit()].peek().getRank() + 1){
                dQ.dequeue();
                dQ.flipTop();
                sets[c.getSuit()].add(c);
                System.out.println("Card moved");
            } else {
                System.out.println("Not a legal move");
            }
        } else {
            f = f - 1;
            c = board[f].peek();
            if(c.getRank() == 0){
                board[f].pop();
                board[f].flipTop();
                sets[c.getSuit()].add(c);
                System.out.println("Card moved");
            } else if(c.getRank() == sets[c.getSuit()].peek().getRank() + 1){
                board[f].pop();
                board[f].flipTop();
                sets[c.getSuit()].add(c);
                System.out.println("Card moved");
            } else {
                System.out.println("Not a legal move");
            }
        }
    }

    public boolean checkWin(){
        boolean result = true;
        for(Pile p : sets){
            if(p.isEmpty()){
                result = false;
                break;
            } else {
                if(p.peek().getRank() != 12){
                    result = false;
                }
            }
        }
        return result;
    }

    public void visualize(){
        System.out.print(dQ.peek().toString() + " ");
        for(int i = 0; i < dQ.getSize(); i++){
            System.out.print("x ");
        }
        System.out.println();
        for(DeckStack p : board){
            for(int i = 0; i < p.getCount(); i++){
                System.out.print(p.cardAt(i) + " ");
            }
            System.out.println();
        }
        System.out.print("Sets: ");
        for(int i = 0; i < 4; i++){
            if(sets[i].isEmpty()){
                System.out.print("x ");
            } else {
                System.out.print(sets[i].peek().getRank() + " ");
            }
        }
        System.out.println();
    }

}
