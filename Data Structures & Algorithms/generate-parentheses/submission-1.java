class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        backtracking(s,res,0,0,n);
        return res;
    }

    public void backtracking(StringBuilder s, List<String> res,int left, int right, int n){
        //结束条件
        if(left == right && left == n){
            res.add(s.toString());
            return;
        }

        if(left < n){
            s.append("(");
            backtracking(s,res,left+1,right,n);
            s.deleteCharAt(s.length()-1);
        }

        if(right<left){
            s.append(")");
            backtracking(s,res,left,right+1,n);
            s.deleteCharAt(s.length()-1);
        }
    }
}

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<>();
//         dfs("",res,0,0,n);
//         return res;
//     }

//     public void dfs(String s, List<String> res,int left, int right, int n){
//         if(s.length() == n*2){
//             res.add(s);
//             return;
//         }
        
//         if(left < n){
//             dfs(s + "(", res, left + 1, right, n);
//         }

//         if(right < left){
//             dfs(s + ")", res, left, right+1,n);
//         }
//     }
// }
