package theorem_prover;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
	private List<Hypothesis> LeftExpression =  new ArrayList<Hypothesis>();
	private Conjecture RightExpression;
	// Assuming initially LeftExpression is null
	public InputParser(String conj){
		RightExpression = new Conjecture(conj);
	}
	public String getDeducedForm(){
		while(RightExpression.isDeducable()){
			Hypothesis temp = new Hypothesis(RightExpression.reduce());
			LeftExpression.add(temp);
//			System.out.println(RightExpression.getConjecture());
		}
		return getStringFromHypothesis()+"|-"+RightExpression.getConjecture();
	}
	
	private String getStringFromHypothesis(){
		String printableHypothesis = "";
		for(int i=0;i<LeftExpression.size();i++){
			if(i==0){
				printableHypothesis += LeftExpression.get(i).getHypothesis();
			}else{
				printableHypothesis += ","+LeftExpression.get(i).getHypothesis();
			}
		}
		return printableHypothesis;
	}
}
