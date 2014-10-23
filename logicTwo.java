public class logicTwo {

    // We want to make a row of bricks that is goal inches long. We have a number of small bricks (1 inch each) and big bricks (5 inches each). Return true if it is possible to make the goal by choosing from the given bricks. This is a little harder than it looks and can be done without any loops. See also: Introduction to MakeBricks

    // makeBricks(3, 1, 8) → true
    // makeBricks(3, 1, 9) → false
    // makeBricks(3, 2, 10) → true

    public boolean makeBricks(int small, int big, int goal) {
        return (small + Math.min(big, goal / 5) * 5 >= goal);
    }


    // Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values, it does not count towards the sum.

    // loneSum(1, 2, 3) → 6
    // loneSum(3, 2, 3) → 2
    // loneSum(3, 3, 3) → 0

    public int loneSum(int a, int b, int c) {

    }


}