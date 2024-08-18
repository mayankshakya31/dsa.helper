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

	// Get the Prefix sum in given range query(Array List B) for data (Array List A)
	public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
		ArrayList<Long> C = new ArrayList<Long>(); // Create a new long ArrayList to avoid test case failure
		C.add((long) A.get(0)); // Adding intial element to new ArrayList
		for (int i = 1; i < A.size(); i++) {
			C.add((long) (C.get(i - 1) + A.get(i))); // Adding prefix sum to new ArrayList
		}
		ArrayList<Long> answer = new ArrayList<Long>(); // return answer array list
		for (int i = 0; i < B.size(); i++) {
			ArrayList<Integer> index = B.get(i);
			int start_index = index.get(0); // start index for prefix sum
			int end_index = index.get(1); // end index fro prefix sum
			if (start_index == 0) {
				answer.add((long) C.get(end_index)); // add the C[end_index] if start index is 0
			} else {
				long SUM = (long) (C.get(end_index) - (C.get(start_index - 1))); // Calculate the sum if start index is
																					// not 0
				answer.add(SUM);
			}
		}
		return answer; // return answer array list
	}

	// find the equilibrium index of Array
	public int equilibrium_index(ArrayList<Integer> A) {
		// Calculate prefix sum
		ArrayList<Integer> prefixSums = new ArrayList<>(A.size());
		prefixSums.add(A.get(0));
		for (int i = 1; i < A.size(); i++) {
			prefixSums.add(prefixSums.get(i - 1) + A.get(i));
		}

		// Calculate equilibrium index
		// check for the corner case of index 0 as equilibrim index
		if ((prefixSums.get(A.size() - 1) - prefixSums.get(0)) == 0)
			return 0;
		for (int i = 1; i < A.size(); i++) {
			// find the equilibrium index for remaining indexes
			if (prefixSums.get(i - 1) == (prefixSums.get(A.size() - 1) - prefixSums.get(i)))
				return i;
		}
		return -1;
	}

	// Get number of subsequent A and G in a string
	public int calculateSubsequestAG(String A) {
		int M = 1000000007; // For modulus of answer
		long answer = 0;
		long count = 0;
		int N = A.length();
		if (A.charAt(N - 1) == 'G')
			count = 1;
		else
			count = 0;
		for (int i = N - 2; i >= 0; i--) {
			if (A.charAt(i) == 'G')
				count += 1;
			if (A.charAt(i) == 'A')
				answer += count;
			answer = answer % M;
		}
		return (int) answer;
	}

	// Calculate leader element in a Array
	public ArrayList<Integer> leaderElement(ArrayList<Integer> A) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int N = A.size();
		int max = A.get(N - 1);
		answer.add(max);
		for (int i = N - 2; i >= 0; i--) {
			if (A.get(i) > max) {
				max = A.get(i);
				answer.add(A.get(i));
			}
		}
		return answer;
	}

	// Smallest sized array containing maximum and minimum element of array
	public int smallestArrayWithMaxAndMin(ArrayList<Integer> A) {
		int N = A.size();
		int min = get_smallest(A);
		int max = get_largest(A);
		int minID = -1;
		int maxID = -1;
		int answer = N;
		for (int i = 0; i < N; i++) {
			if (A.get(i) == min) {
				if (maxID != -1)
					answer = Math.min(answer, i - maxID + 1);
				minID = i;
			}
			if (A.get(i) == max) {
				if (minID != -1)
					answer = Math.min(answer, i - minID + 1);
				maxID = i;
			}
		}
		return answer;
	}

}