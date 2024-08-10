import java.util.ArrayList;
import java.util.List;

public class helper {

	public static int digitSum(int A) {
		int answer = 0;
		while (A != 0) {
			answer += A % 10;
			A = A / 10;
		}
		return answer;
	}

	public static boolean isArmstrong(int A) {
		int num = A;
		int answer = 0;
		while (A != 0) {
			answer += (int) Math.pow(A % 10, 3);
			A = A / 10;
		}
		return answer == num;
	}

	public boolean prime(int A) {
		if (A == 1 || A == 0)
			return false;
		for (int i = 2; i <= (int) Math.sqrt(A); i++) {
			if (A % i == 0)
				return false;
		}
		return true;
	}

	public boolean perfectNumber(int A) {
		int ans = 0;
		if (A == 0 || A == 1)
			return false;
		for (int i = 1; i <= A / 2; i++) {
			if (A % i == 0) {
				ans += i;
			}
		}
		return ans == A;
	}

	public int numberOfDigits(int A) {
		if (A == 0 || A == 1)
			return 1;
		int count = 0;
		while (A != 0) {
			A = A / 10;
			count++;
		}
		return count;
	}

	public boolean isPalindrome(int A) {
		int num = A;
		int answer = 0;
		while (A != 0) {
			answer = (answer * 10) + A % 10;
			A = A / 10;
		}
		return answer == num;
	}

	public int getHCF(int A, int B) {
		int b = Math.min(A, B);
		int a = Math.max(A, B);

		if (a % b == 0)
			return b;

		for (int i = b; i >= 1; i--) {
			if (a % i == 0 && b % i == 0)
				return i;
		}
		return 0;
	}

	public int get_largest(int a[]) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

	// Reverse an array list within given range
	public ArrayList<Integer> solve(ArrayList<Integer> A, int B, int C) {
		for (int i = B, j = C; i < j; i++, j--) {
			int a = A.get(i);
			int b = A.get(j);
			A.set(i, b);
			A.set(j, a);
		}
		return A;
	}

	// Reverse the array list when input is in read only
	public ArrayList<Integer> solve(final List<Integer> A) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.addAll(A);
		for (int i = 0, j = A.size() - 1; i <= j; i++, j--) {
			int a = A.get(i);
			int b = A.get(j);
			answer.set(i, b);
			answer.set(j, a);
		}
		return answer;
	}

	// Get largest from Array List
	public int get_largest(ArrayList<Integer> A) {
		int max = A.get(0);
		for (int i = 1; i < A.size(); i++) {
			if (max < A.get(i)) {
				max = A.get(i);
			}
		}
		return max;
	}

	// Get Smallest from array list
	public int get_smallest(ArrayList<Integer> A) {
		int min = A.get(0);
		for (int i = 1; i < A.size(); i++) {
			if (min > A.get(i)) {
				min = A.get(i);
			}
		}
		return min;
	}
}