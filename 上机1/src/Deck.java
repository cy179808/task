import java.util.ArrayList;
import java.util.Random;
    public class Deck {
        protected ArrayList<Card> cards;
        Random random;
        static String[] suit={"Heart", "Spade", "Diamond", "Club"};
        static int[] value={1,2,3,4,5,6,7,8,9,10,11,12,13};
        public Deck() {
            this.cards = new ArrayList<Card>();
            this.random = new Random();
            // create all the cards
            this.generateDeck();
        }

        /*
         * Generate all the cards for a deck
         * the cards are stored in the member variable - cards
         */
        protected void generateDeck() {
            // TODO 3.1
            Card card[]=new Card[52];
            for(int i=0;i<value.length;i++)
                for(int j=0;j<suit.length;j++)
                {
                    card[i*4+j]=new Card(value[i],suit[j]);
                    cards.add(card[i*4+j]);
                }
        }

        /*
         * Return a random card, remove it from the deck
         */
        public Card getRandomCard() {
            int index = this.random.nextInt(this.cards.size());
            return this.cards.remove(index);
        }

        /*
         * Create a CardGroup by picking 3 cards randomly
         */
        public CardGroup createRandomCardGroup() {
            // TODO 3.1
            CardGroup c = new CardGroup(getRandomCard(), getRandomCard(), getRandomCard());
            /*int index1 = this.random.nextInt(this.cards.size());
            Card card1=this.cards.remove(index1);
            int index2 = this.random.nextInt(this.cards.size());
            Card card2=this.cards.remove(index2);
            int index3 = this.random.nextInt(this.cards.size());
            Card card3=this.cards.remove(index3);
            CardGroup c=new CardGroup(card1,card2,card3);*/
            return c;
        }
        protected void Cardcompare(CardGroup i,CardGroup j){
            if(i.compare(j)==1)
            {
                System.out.println(i.c1.getNumber()+i.c1.getSuit());
                System.out.println(i.c2.getNumber()+i.c2.getSuit());
                System.out.println(i.c3.getNumber()+i.c3.getSuit());
            }
            else if(i.compare(j)==-1){
                System.out.println(j.c1.getNumber()+j.c1.getSuit());
                System.out.println(j.c2.getNumber()+j.c2.getSuit());
                System.out.println(j.c3.getNumber()+j.c3.getSuit());
            }
            else {
                System.out.println("They are equal");
            }
        }


        public static void main(String[] args) {
            Deck deck = new Deck();
            CardGroup cg1 = deck.createRandomCardGroup();
            CardGroup cg2 = deck.createRandomCardGroup();
            CardGroup cg3 = deck.createRandomCardGroup();
            deck.Cardcompare(cg1,cg2);
            deck.Cardcompare(cg2,cg3);
            deck.Cardcompare(cg1,cg3);

            // TODO 3.4
        }

}