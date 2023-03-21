package principal;


import vista.Welcome;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello word");
		
		Welcome home = new Welcome();
		home.setVisible(true);
		home.setLocationRelativeTo(null);
		home.setResizable(false);
		
	}
}
