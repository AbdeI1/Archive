final class Card {
    private static final String [] rankName =
            {
                    "ace",       //   0
                    "two",       //   1
                    "three",     //   2
                    "four",      //   3
                    "five",      //   4
                    "six",       //   5
                    "seven",     //   6
                    "eight",     //   7
                    "nine",      //   8
                    "ten",       //   9
                    "jack",      //  10
                    "queen",     //  11
                    "king"       //  12
            };
    private static final String [] suitName =
            {
                    "clubs",     //  0
                    "diamonds",  //  1
                    "hearts",    //  2
                    "spades"     //  3
            };

    private int rank;
    private int suit;
    private boolean faceUp;

    public Card(int rank, int suit)
    {
        if (0 <= rank && rank <= 12 && 0 <= suit && suit <= 3)
        {
            this.rank = rank;
            this.suit = suit;
            faceUp = false;
        }
        else
        {
            throw new IllegalArgumentException("Illegal rank or suit.");
        }
    }

    public int getRank()
    {
        return rank;
    }

    public int getSuit()
    {
        return suit;
    }

    public void flip(){
        faceUp = !faceUp;
    }

    public boolean getFace(){
        return faceUp;
    }

    public String getColor(){
        String color = "unknown";
        if(suit == 0 || suit == 3){
            color = "black";
        }
        else if(suit == 1 || suit == 2){
            color = "red";
        }
        return color;
    }

    public String toString()
    {
        if(faceUp) {
            return rankName[rank] + " (" + rank + ") of " + suitName[suit];
        } else {
            return "x";
        }
    }
}
