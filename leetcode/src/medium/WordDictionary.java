package medium;

public class WordDictionary {
	WordNode root;
	public WordDictionary() {
		root = new WordNode(' ');
	}
	public void addWord(String word) {
		WordNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (node.sons[word.charAt(i) - 'a'] == null) {
				node.sons[word.charAt(i) - 'a'] = new WordNode(word.charAt(i));
			}
			node = node.sons[word.charAt(i) - 'a'];
		}
		node.isWord = true;
	}

	public boolean search(String word) {
		return helper(word,0,root);
	}

	public boolean helper(String word,int index,WordNode root){
		int len = word.length();
		if(root==null){
			return false;
		}
		if(index==len){
			return root.isWord;
		}
		if(word.charAt(index)!='.'){
			return helper(word,index+1,root.sons[word.charAt(index)-'a']);
		}else{
			for (int i = 0; i < 26; i++) {
				if(root.sons[i]!=null){
					if(helper(word,index+1,root.sons[i])){
						return true;
					}
				}
			}
			return false;
		}
	}
	class WordNode {
		char c;
		WordNode[] sons = new WordNode[26];
		boolean isWord = false;
		public WordNode(char c) {
			this.c = c;
		}
	}
    public static void main(String[] args) {
		WordDictionary dict=new WordDictionary();
		dict.addWord("hello");
		dict.addWord("world");
		System.out.println(dict.search("he..o"));
		System.out.println(dict.search("world"));
	}
}
