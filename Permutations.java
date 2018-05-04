import java.util.ArrayList;


public class Permutations {
    
    public static void main(String[] args){
        
        
        System.out.println(permute("556").toString());
        
    }
    
    public static ArrayList<String> permute(String input){
        
        ArrayList<String> permutations = new ArrayList<String>();
        
        if(input.length()==1){
            permutations.add(input);
            return permutations;
        }
        
        for( int i =0; i<input.length(); i++){
            String newInput = input.substring(0, i) + input.substring(i+1);
            ArrayList<String> subPermutations = permute(newInput);
            for (int j =0; j < subPermutations.size(); j++){
                String permutation = input.charAt(i) + subPermutations.get(j);
                permutations.add(permutation);
            }
        }
        
        return permutations;
    }
    
}
