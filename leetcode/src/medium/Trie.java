package medium;

import java.util.HashMap;
import java.util.Map;
/**
 * 改进：可以利用hashmap来加快查找速度
 * 或：自定义的hash，letter存储到对应位置
 * @author xiaohu
 *
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if(word==null){
    		return;
    	}
    	TrieNode prev=root;
    	TrieNode cur;
        for (int i = 0; i < word.length(); i++) {
        	if(prev.children.containsKey(word.charAt(i))){
        		cur=prev.children.get(word.charAt(i));
        	}else{
        		cur=new TrieNode();
        		prev.children.put(word.charAt(i),cur);
        	}
        	prev=cur;
		}
        prev.isWordEnd=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node=root;
        for (int i = 0; i < word.length(); i++) {
        	if(node.children.containsKey(word.charAt(i))){
        		node=node.children.get(word.charAt(i));
        	}else{
        		return false;
        	}
		}
        return node.isWordEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for (int i = 0; i < prefix.length(); i++) {
        	if(node.children.containsKey(prefix.charAt(i))){
        		node=node.children.get(prefix.charAt(i));
        	}else{
        		return false;
        	}
		}
        return true;
    }
    public static void main(String[] args) {
		Trie root=new Trie();
		root.insert("hello");
		root.insert("hi");
		root.insert("");
		System.out.println(root.search("hi"));
		System.out.println(root.search("hello"));
		System.out.println(root.startsWith(""));
		System.out.println(root.search(""));
	}
}
class TrieNode {
    // Initialize your data structure here.
	Map<Character,TrieNode> children;
	char val;
	boolean isWordEnd;
    public TrieNode() {
        children=new HashMap<Character,TrieNode>();
    }
}