package createBrick;

public class CreateBrick {

	/*
	 * [ BRICK TO THE WALL ] small - 1cm x "small" number brick big - 5cm x "big"
	 * number brick goal - size of the wall ableToBuildWall - it true when we have
	 * enough brick for build a wall
	 */

	public static boolean ableToBuildWall(int small, int big, int goal) {
		int s_size = 1;
		int b_size = 5;
		int sum = (small * s_size) + (big * b_size);

		if (sum > goal) {

		}

		return false;
	}

	public static void main(String[] args) {

		System.out.println("START");

	}

}
