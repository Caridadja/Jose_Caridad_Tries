import java.util.*;

public class Trie {
    public Node root;
    public HashSet<Character> keys;
    
    public Trie() {
        this.root = new Node();
        this.keys = new HashSet<Character>();
    }
    
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            helper(currentLetter);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    public boolean isPrefixValid(String prefix) {
    	Node currentNode = this.root;
    	
    	for(int i = 0; i < prefix.length(); i++) {
    		Node currentLetter = currentNode.children.get(prefix.charAt(i));
    		
    		if(currentLetter == null) {
    			return false;
    		}
    		currentNode = currentLetter;
    	}
    	return true;
    }
    public boolean isWordValid(String word) {
    	Node currentNode = this.root;
    	int i = 0;
    	while(i < word.length()) {
    		Node currentLetter = currentNode.children.get(word.charAt(i));
    		if(i == word.length()-1) {
    		    if(currentLetter.isCompleteWord == true) {
    			return true;
    		}
    	}
    		currentNode = currentLetter;
    		i++;
    		
    	}
    	return false;
    }
    public void helper(Character ch){
    	keys.add(ch);
    	}
    public void printAllKeys() {
    		Set<Character> key1 = keys;
    		for(Character key : key1) {
    			System.out.println(key);
    		}
}
}