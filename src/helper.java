public class helper {


public static int digitSum ( int A ) {
	int answer = 0;
	while ( A != 0 ) {
		answer += A % 10;
		A = A / 10;
	}
	return answer;
}

public static boolean isArmstrong ( int A ) {
	int num = A;
	int answer = 0;
	while ( A != 0 ) {
		answer += ( int ) Math.pow ( A % 10 , 3 );
		A = A / 10;
	}
	return answer == num;
}

public boolean prime ( int A ) {
	if ( A == 1 || A == 0 ) return false;
	for ( int i = 2 ; i <= ( int ) Math.sqrt ( A ) ; i++ ) {
		if ( A % i == 0 ) return false;
	}
	return true;
}

public boolean perfectNumber ( int A ) {
	int ans = 0;
	if ( A == 0 || A == 1 ) return false;
	for ( int i = 1 ; i <= A / 2 ; i++ ) {
		if ( A % i == 0 ) {
			ans += i;
		}
	}
	return ans == A;
}

public int numberOfDigits ( int A ) {
	if ( A == 0 || A == 1 ) return 1;
	int count = 0;
	while ( A != 0 ) {
		A = A / 10;
		count++;
	}
	return count;
}

public boolean isPalindrome ( int A ) {
	int num = A;
	int answer = 0;
	while ( A != 0 ) {
		answer = ( answer * 10 ) + A % 10;
		A = A / 10;
	}
	return answer == num;
}

public int getHCF ( int A , int B ) {
	int b = Math.min ( A , B );
	int a = Math.max ( A , B );

	if ( a % b == 0 ) return b;

	for ( int i = b ; i >= 1 ; i-- ) {
		if ( a % i == 0 && b % i == 0 ) return i;
	}
	return 0;
}
}
