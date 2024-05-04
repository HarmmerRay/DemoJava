回溯法模板  
public void xxx(参数){
    if(终止条件){
        存放结果;
        return ...;
    }

    for(item : 当前层的所有节点){
        相应操作;
        backtracking(路径,选择列表);
        触达叶子节点后值的处理;
    }
}