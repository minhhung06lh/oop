public class Deal {
    public static void main(String[] args) {
        String suit[] = {
                "Heart", "Diamond", "Club", "Spade"
        };

        String rank[] = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        int deckLength = suit.length * rank.length;

        String deck[] = new String[deckLength];
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                deck[i * rank.length + j] = suit[i] + " " + rank[j];
            }
        }

        int n = Integer.parseInt(args[0]);

        if (n * 5 > deckLength) {
            throw new IllegalArgumentException("Too many players!");
        }

        for (int i = 0; i < deckLength; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }

        for (int i = 0; i < n * 5; i++) {
            System.out.println(deck[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }
}
