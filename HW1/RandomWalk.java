import edu.princeton.cs.algs4.*;

public class RandomWalk {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        String directions[] = new String[]{"RIGHT", "DOWN", "LEFT", "UP"};
        int dir = 0;
        int rightAngle = 1;

        while (steps < (2 * n + 1) * (2 * n + 1)) {
            for (int repeat = 0; repeat < 2; repeat++) {
                for (int i = 0; i < rightAngle; i++) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(x, y, 0.45);
                    switch (directions[dir]) {
                        case "RIGHT":
                            x++;
                            break;
                        case "DOWN":
                            y++;
                            break;
                        case "LEFT":
                            x--;
                            break;
                        case "UP":
                            y--;
                            break;
                    }
                    steps++;
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x, y, 0.45);
                    StdDraw.show();
                    StdDraw.pause(40);

                }
                dir = (dir + 1) % 4;
                if (steps == (2 * n + 1) * (2 * n + 1))
                    break;
            }
            rightAngle++;
        }

        StdOut.println("Total steps = " + steps);
    }

}
