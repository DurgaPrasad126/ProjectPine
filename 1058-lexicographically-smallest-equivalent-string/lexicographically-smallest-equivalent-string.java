class Solution {
        int[] parent = new int[26];
        int[] size = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {


        for(int i=0;i<26;i++) parent[i]=i;
        Arrays.fill(size, 1);

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for(int i=0;i<s1.length();i++) {
            int c1parent = find(c1[i]-'a');
            int c2parent = find(c2[i]-'a');

            if(c1parent == c2parent) continue;

            if(c1parent > c2parent) {
                parent[c1parent] = c2parent;
                size[c2parent]+=size[c1parent];
            }
            else if(c1parent < c2parent) {
                parent[c2parent] = c1parent;
                size[c1parent]+=size[c2parent];
            }
        }
        StringBuilder sb = new StringBuilder();
        char[] tar = baseStr.toCharArray();
        for(int i=0;i<baseStr.length();i++) {
            int parent = find(tar[i]-'a');
            sb.append((char)('a'+parent));
        }
        return sb.toString();
    }

    public int find(int index) {
        if(index != parent[index]) parent[index] = find(parent[index]);
        return parent[index];
    }
}