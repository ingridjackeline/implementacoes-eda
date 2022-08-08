import java.util.Scanner;


class TeoremaMestre {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int ord = sc.nextInt();
		
		int logaritmo = log(b, a);
		String theta = "";
		
		if (ord < logaritmo) {
			theta += "T(n) = theta(n**" + logaritmo + ")";
		} else if (ord > logaritmo) {
			theta += "T(n) = theta(n**" + ord + ")";
		} else {
			theta += "T(n) = theta(n**" + ord + " * log n)";
		}
		
		System.out.println(theta);
	}
	
	public static int log(int base, int logaritmando) {
		int logaritmo = (int) (Math.log(logaritmando) / Math.log(base));
		return logaritmo;
	}

}