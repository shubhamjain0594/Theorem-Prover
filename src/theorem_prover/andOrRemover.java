package theorem_prover;

public class andOrRemover {
	public static String Remover(String inp){
		String str=inp;
		int lastopen=-1;
		int lastclosed=-1;
		
		for(int i=0; i<inp.length(); i++){
			if(inp.charAt(i)=='v'){
				int prest=i-1;
				int preend;
				int ct=0;
				if(inp.charAt(i-1)==')')
					for(int j=i-1; j>=0; j--){
						if(inp.charAt(j)=='('){
							ct--;
							if(ct==0){
								prest=j;
								break;
							}
						}
						else if(inp.charAt(j)==')'){
							ct++;
						}
					}
				preend=i-1;
				
				int postst=i+1;
				int postend=i+1;
				ct=0;
				if(inp.charAt(i+1)=='(')
					for(int j=i+1; j<=inp.length(); j++){
						if(inp.charAt(j)==')'){
							ct--;
							if(ct==0){
								postend=j;
								break;
							}
						}
						else if(inp.charAt(j)=='('){
							ct++;
						}
					}
				
				str=str.substring(0,prest)+"(("+str.substring(prest,preend+1)+"->F)->"+Remover(str.substring(postst,postend+1)+")");
				i=i+postend-postst+1;
			}
			else if(inp.charAt(i)=='^'){
				int prest=i-1;
				int preend;
				int ct=0;
				if(inp.charAt(i-1)==')')
					for(int j=i-1; j>=0; j--){
						if(inp.charAt(j)=='('){
							ct--;
							if(ct==0){
								prest=j;
								break;
							}
						}
						else if(inp.charAt(j)==')'){
							ct++;
						}
					}
				preend=i-1;
				
				int postst=i+1;
				int postend=i+1;
				ct=0;
				if(inp.charAt(i+1)=='(')
					for(int j=i+1; j<=inp.length(); j++){
						if(inp.charAt(j)==')'){
							ct--;
							if(ct==0){
								postend=j;
								break;
							}
						}
						else if(inp.charAt(j)=='('){
							ct++;
						}
					}
				
				str=str.substring(0,prest)+"(("+str.substring(prest,preend+1)+"->("+Remover(str.substring(postst,postend+1)+"->F))->F)");
				i=i+postend-postst+1;
			}
			else if(inp.charAt(i)=='~'){
				int postst=i+1;
				int postend=i+1;
				int ct=0;
				if(inp.charAt(i+1)=='(')
					for(int j=i+1; j<=inp.length(); j++){
						if(inp.charAt(j)==')'){
							ct--;
							if(ct==0){
								postend=j;
								break;
							}
						}
						else if(inp.charAt(j)=='('){
							ct++;
						}
					}
				
				str=str.substring(0,i)+Remover(str.substring(postst,postend+1)+"->F");
				i=i+postend-postst+1;
			}
		}
		return str;
	}
	
}
