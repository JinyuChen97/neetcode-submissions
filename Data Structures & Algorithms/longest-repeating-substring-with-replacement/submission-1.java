class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> check = new HashMap<>();
        int L = 0;
        int R = 0;
        int maxSameValueAmount = 0;
        int longest = 0;
        while(R<s.length()){
            //通过右标不断探测，不断去记录每个字符的次数，并且记录相同字符出现的最大次数
            check.put(s.charAt(R), check.getOrDefault(s.charAt(R),0)+1);
            maxSameValueAmount = Math.max(maxSameValueAmount,check.get(s.charAt(R)));
            //然后检查从右标到左标的长度减去相同字符出现的最大次数，是否大于k次，大于的话则表示
            //窗口该缩小了，因为出现了多余k次的修改，当前窗口里的内容不符合，所以左标需要一直缩小
            //直到内容重新符合
            while((R-L+1)-maxSameValueAmount>k){
                check.put(s.charAt(L), check.getOrDefault(s.charAt(L),0)-1);
                L++;
            }

            if((R-L+1)-maxSameValueAmount<=k){
                longest = Math.max(longest, R-L+1);
            }
            R++;
        }
        return longest;
    }
}

// 情况 1： maxSameValueAmount 比实际值大：
// 窗口会更早收缩，因为条件看起来“被违反”了。
// 结果： 不会漏掉合法窗口，只是可能忽略一些“较短”的窗口。
// 情况 2： 如果我们强制更新 maxSameValueAmount：
// 代码会更复杂且运行时间增加，但找到的结果是一样的。
