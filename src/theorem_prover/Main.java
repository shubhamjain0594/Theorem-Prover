package theorem_prover;

public class Main {
	public static void main(String[] args){
		String input = "(p&q)->(p|q)";
		InputParser ip = new InputParser(input);
		System.out.println(ip.getDeducedForm());
	}
}
