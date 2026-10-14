class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        List<Integer> lis = new ArrayList<>();

        if (s.length() < p.length()) {
            return lis;
        }

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }

        if (pmap.equals(smap)) {
            lis.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            char chr = s.charAt(i - p.length());
            if (smap.get(chr) == 1) {
                smap.remove(chr);
            } else {
                smap.put(chr, smap.get(chr) - 1);
            }

            if (pmap.equals(smap)) {
                lis.add(i - p.length() + 1);
            }
        }

        return lis;
    }
}