package theorem_prover;

// Conjecture is something to be proved
public class Conjecture {
	private String conjecture;
	public Conjecture(String conj){
		conjecture = conj;
	}
	// Checks if conjecture is deducable further
	public boolean isDeducable(){
		return conjecture.contains("->");
	}
	
	// reduces the conjecture and returns left expression of it and conjecture is right expression itself if
	public String reduce(){
		int num_open_brackets=0;
		boolean remove = false;
		for(int i=0;i<conjecture.length();i++){
			if(conjecture.charAt(i)=='('){
				num_open_brackets++;
				if(i==0){
					remove=true;
				}
			}else if(conjecture.charAt(i)==')'){
				num_open_brackets--;
				if(num_open_brackets==0&&i!=conjecture.length()-1){
					remove=false;
					break;
				}
			}
		}
		if(remove){
			conjecture=conjecture.substring(1, conjecture.length()-1);
		}
		String leftExp = "";
		num_open_brackets = 0;
		for(int i=0;i<conjecture.length();i++){
			if(conjecture.substring(i, i+2).equals("->")&&num_open_brackets==0){
				conjecture=conjecture.substring(i+2);
				return leftExp;
			}
			if(conjecture.charAt(i)=='('){
				num_open_brackets++;
			}else if(conjecture.charAt(i)==')'){
				num_open_brackets--;
			}
			leftExp += conjecture.charAt(i);
		}
		return leftExp;
	}
	
	public String getConjecture(){
		return conjecture;
	}
	
}
