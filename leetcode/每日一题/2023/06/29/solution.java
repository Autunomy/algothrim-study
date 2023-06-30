//1253. 重构 2 行二进制矩阵
class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> lists = new ArrayList<>();
        int sum = 0;
        for (int col : colsum){
            sum += col;
        }
        //如果和不相等 则直接返回空
        if (upper + lower != sum){
            return lists;
        }
        //初始化lists
        for (int i = 0;i < 2;i++){
            lists.add(new ArrayList<>());
        }
        for (int col : colsum){
            if (col == 0){//如果等于0 则第0行和第1行都是0
                lists.get(0).add(0);
                lists.get(1).add(0);
            } else if (col == 2) {//如果等于1 则第0行和第1行都是1
                //如果upper或者lower小于等于0了 证明当前的列不能分配了 直接返回空
                if (upper <= 0 || lower <= 0){
                    return new ArrayList<>();
                }
                lists.get(0).add(1);
                lists.get(1).add(1);
                upper--;
                lower--;
            } else {//如果等于1 则根据upper和lower的大小选择
                if (upper >= lower){//第0行为1
                    lists.get(0).add(1);
                    lists.get(1).add(0);
                    upper--;
                } else {//第1行为1
                    lists.get(0).add(0);
                    lists.get(1).add(1);
                    lower--;
                }
            }
        }
        return lists;
    }
}