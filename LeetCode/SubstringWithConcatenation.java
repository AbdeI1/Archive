class Solution {
    public List<Integer> findSubstring(String s, String[] words){
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i <= s.length() - words[0].length() * words.length; i++){
            if(containsSubstrings(s.substring(i, i + words[0].length() * words.length), words)){
                l.add(i);
            }
        }
        return l;
    }
    public boolean containsSubstrings(String s, String[] words){
        List<String> lb = Arrays.asList(words);
        List<String> l = new ArrayList<String>();
        l.addAll(lb);
        if(s.length() != words[0].length() * words.length){
            return false;
        }
        for(int i = 0; i < s.length(); i+=words[0].length()){
            String s1 = s.substring(i, i + words[0].length());
            if(l.contains(s1)){
                l.remove(s1);
            } else {
                return false;
            }
        }
        return true;
    }
}
