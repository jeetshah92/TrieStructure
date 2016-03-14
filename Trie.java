
import java.util.*;

public class Trie {
	
	
	public char key;
	
	public Integer number;
	
	public HashMap<Character,Trie> dictionary = new HashMap<>();
	
	public void add(String s, Integer phoneNum, Trie root) {
		
		char[] charArray = s.toCharArray();
		
		Trie currentNode = root;
		
		for(char i : charArray) {
			
			
			if(currentNode != null) {
				
			     Trie associatedNode = currentNode.dictionary.get(i);
			     
			     if(associatedNode == null) {
			    	 
			    	Trie newNode = new Trie();
			    	newNode.dictionary = new HashMap<Character,Trie>();
			    	newNode.key = i;
			    	currentNode.dictionary.put(i, newNode);
			    	currentNode = newNode;
					
			    	 
			     } else {
			    	 
			    	 currentNode = associatedNode;
			     }
			
			}
		
		}
		
		
		currentNode.number = phoneNum;
		
		
	}
	
	public Trie findPrefix(String s, Trie root) {
		
		char[] charArray = s.toCharArray();
		
		Trie currentNode = root;
		
		for(char i : charArray) {
			
			
			if(currentNode != null) {
				
				
				currentNode = currentNode.dictionary.put(i, new Trie());
				
			} else {
				
				break;
			}
			
		}
		
		return currentNode;
		
		
	}
	
	public void traverse(Trie root) {
		
		System.out.println(root.key);
		if(root.number != null)
		System.out.println(root.number);
			
		
		Set<Character> keys = root.dictionary.keySet();
		
		for(Character c : keys) {
			
			traverse(root.dictionary.get(c));
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trie root = new Trie();
		
		root.add("rihanna", 3456788, root);
		root.add("riya",789909, root);
		root.add("rnkal",899087,root);
		
		Trie prefix = root.findPrefix("ri", root);
		root.traverse(prefix);
		

	}

}
