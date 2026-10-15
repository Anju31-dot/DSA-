class Solution {
    class Pair{
        String s ;
        int dist;
        Pair(String s , int dist){
            this.s = s;
            this.dist = dist;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> st = new HashSet<>(wordList);
        q.add(new Pair(beginWord,1));
        st.remove(beginWord);
        while(!q.isEmpty()){
            Pair p = q.poll();
            String word = p.s;
            int steps = p.dist;
            if(word.equals(endWord)){
                return steps;
            }
            char [] arr = word.toCharArray();
            for(int i =0;i<arr.length ;i++){
                char original = arr[i];
                for(char c ='a';c<='z';c++){
                    arr[i]=c;
                    String newWord = new String(arr);
                    if(st.contains(newWord)){
                        q.add(new Pair(newWord,steps +1));
                        st.remove(newWord);
                    }
                }
                arr[i]= original;

            }
        }
        return 0;
        
    }
}