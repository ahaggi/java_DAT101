package arv_joined_table;

import java.util.Scanner;

import javax.persistence.*;

public class Klient {

	public static void main(String[] args) {
        
		Scanner tast = new Scanner(System.in);
		double x =-2;
		
		for (int i = 0; i < 10
				; i++) {
			x=x-( ((x*x*x)-4*x+1)/ ((3*x*x)-4));
			System.out.println(x);
		}
	}

}
