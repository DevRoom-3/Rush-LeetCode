class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        int len = s.length();
        if (len < 10){
            return list;
        }
        String str = s.substring(0, 10);
        Map<String, Integer> map = new HashMap<>();
        map.put(str, 1);
        for (int i = 1; i < len; ++ i){
            if (i + 10 > len){
                break;
            }
            str = s.substring(i, i + 10);
            if (map.containsKey(str)){
                int index = map.get(str);
                if (index == 1){
                    list.add(str);
                }
                map.put(str, index + 1);
            }
            else {
                map.put(str, 1);
            }
        }
        return list;
    }
}
