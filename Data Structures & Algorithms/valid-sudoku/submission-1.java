// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         for(int row=0;row<9;row++){
//             Set<Character> seen = new HashSet<>();
//             for(int i=0;i<9;i++){
//                 if(board[row][i] == '.') continue;
//                 if(seen.contains(board[row][i])) return false;
//                 seen.add(board[row][i]);
//             }
//         }

//         for(int col=0;col<9;col++){
//             Set<Character> seen = new HashSet<>();
//             for(int i=0;i<9;i++){
//                 if(board[i][col] == '.') continue;
//                 if(seen.contains(board[i][col])) return false;
//                 seen.add(board[i][col]);
//             }
//         }

//         for(int block=0;block<9;block++){
//             Set<Character> seen = new HashSet<>();
//             for(int i=0;i<3;i++){
//                 for(int j=0;j<3;j++){
//                     int row=(block/3)*3 + i;
//                     int col=(block%3)*3 + j;
//                     if(board[row][col] == '.') continue;
//                     if(seen.contains(board[row][col])) return false;
//                     seen.add(board[row][col]);                
//                 }
//             }
//         }
//         return true;
//     }
// }


class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> blocks = new HashMap<>();

        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col] == '.') continue;

                String blockKey = (row/3) + "," + (col/3);

                if(rows.computeIfAbsent(row, k-> new HashSet<>()).contains(board[row][col]) || 
                    cols.computeIfAbsent(col, k-> new HashSet<>()).contains(board[row][col]) ||
                    blocks.computeIfAbsent(blockKey, k-> new HashSet<>()).contains(board[row][col])){
                        return false;
                    }

                rows.get(row).add(board[row][col]);
                cols.get(col).add(board[row][col]);
                blocks.get(blockKey).add(board[row][col]);
            }
        }
        return true;
    }
}
