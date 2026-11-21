class PrefixTree {
   class Node{
    Node[] children = new Node[26];
    boolean isEnd = false;
   }
   Node root;
    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
     Node curr = root;
     for(int i = 0;i<word.length();i++){
      int index = word.charAt(i)-'a';
      if(curr.children[index]==null){
          curr.children[index] = new Node();
      }
      curr = curr.children[index];
     }
     curr.isEnd = true;
    }

    public boolean search(String word) {
    Node curr = root;
    for(int i = 0;i<word.length();i++){
        int index = word.charAt(i)-'a';
        if(curr.children[index]==null){
            return false;
        }
      curr =   curr.children[index];
    }
      return curr.isEnd;
    }


    public boolean startsWith(String prefix) {
      Node  curr = root;
       for (int i = 0; i < prefix.length(); i++) {

            int idx = prefix.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }
}
