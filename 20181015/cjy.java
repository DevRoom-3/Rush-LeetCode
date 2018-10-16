class Solution {
    public List<List<String>> groupAnagrams(String[] input) {
        Map<String, List<String>> map = new HashMap<>();
        for(String value : input) {
            List<Character> list = new ArrayList<>();
            char[] array = value.toCharArray();
            for(char ch : array) {
                list.add(ch);
            }
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for(char ch : list) {
                sb.append(ch);
            }
            List<String> exists = new ArrayList<>();
            if(map.containsKey(sb.toString())) {
                exists = map.get(sb.toString());
                exists.add(value);
            } else {
                exists.add(value);
                map.put(sb.toString(), exists);
            }
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}
