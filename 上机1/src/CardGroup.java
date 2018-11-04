import java.util.ArrayList;
import java.util.List;

public class CardGroup {
    protected Card c1;
    protected Card c2;
    protected Card c3;

    public CardGroup(Card c1, Card c2, Card c3) {
        // TODO 3.1
        this.c1=c1;
        this.c2=c2;
        this.c3=c3;
    }

    /*
     * Return the number of cards with the same number
     */
    public int numOfSameNumber() {
        // TODO 3.2
        int i=0;
        if(c1.number==c2.number)i++;
        if(c1.number==c3.number)i++;
        if(c2.number==c3.number)i++;
        return i; // to be replaced
    }

    /*
     * Return the sum of all 3 numbers.
     */
    public int sumOfNumbers() {
        // TODO 3.3
        int i=0;
        i=c1.number+c2.number+c3.number;
        return i; // to be replaced
    }

    /*
     * Compare if it is bigger than CardGroup c
     * @param c another CardGroup
     * @return 1: bigger than c; 0: the same; -1: smaller than c.
     */
    public int compare(CardGroup c) {
        // TODO 3.4
        int i=0,j=0,z=0;
        if(this.c1.suit==this.c2.suit&&this.c1.suit==this.c3.suit&&this.c2.suit==this.c3.suit)i=3;
          else if((this.c1.number==this.c2.number)&&(this.c1.number==this.c3.number)&&(this.c2.number== this.c3.number))i=2;
            else if((this.c1.number==this.c2.number)||(this.c1.number==this.c3.number)||(this.c2.number== this.c3.number))i=1;
        if((c.c1.suit==c.c2.suit)&&(c.c1.suit==c.c3.suit)&&(c.c2.suit==c.c3.suit))j=3;
          else if((c.c1.number==c.c2.number)&&(c.c1.number==c.c3.number)&&(c.c2.number== c.c3.number))j=2;
          else if((c.c1.number==c.c2.number)||(c.c1.number==c.c3.number)||(c.c2.number== c.c3.number))j=1;
        if(i>j)z=1;
          else if(i<j)z=-1;

        return z; // to be replaced
    }

}
