package theorem_prover;

// Hypothesis we assume are correct
public class Hypothesis {
	private String hypothesis;
	
	public Hypothesis(String hy){
		hypothesis = hy;
	}
	
	public String getHypothesis(){
		return hypothesis;
	}
}
