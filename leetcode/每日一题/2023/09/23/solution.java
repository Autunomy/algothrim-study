//1993. 树上的操作
//根据题目进行模拟即可
class LockingTree {

    Map<Integer,Integer> fa = new HashMap<>();
    Map<Integer,List<Integer>> son = new HashMap<>();
    int[] isLock;
    public LockingTree(int[] parent) {
        for(int i=0;i<parent.length;++i){
            fa.put(i,parent[i]);
            if(son.get(parent[i]) == null) son.put(parent[i],new ArrayList<>());
            son.get(parent[i]).add(i);
        }
        isLock = new int[parent.length + 1];

        Arrays.fill(isLock,-1);
    }


    
    public boolean lock(int num, int user) {
        if(isLock[num] == -1){
            isLock[num] = user;
            return true;
        }

        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(isLock[num] != -1 && isLock[num] == user){
            isLock[num] = -1;
            return true;
        }

        return false;
    }
    
    public boolean upgrade(int num, int user) {
        boolean flag1 = true;
        int temp = num;
        while(temp != -1){
            if(isLock[temp] != -1){
                flag1 = false;
                break;
            }
            temp = fa.get(temp);
        }

        boolean flag2 = false;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(num);

        while(queue.size() != 0){
            
            int size = queue.size();
            while(size -- > 0){
                int val = queue.poll();
                List<Integer> list = son.get(val);
                if(list != null){
                    for(Integer i : list){
                        if(isLock[i] != -1){
                            flag2 = true;
                            break;
                        }

                        queue.offer(i);
                    }
                }
                if(flag2) break;
            }
            if(flag2) break;
        }
        
        
        if(flag1 && flag2 && isLock[num] == -1){
            isLock[num] = user;

            queue = new LinkedList<>();
            queue.offer(num); 
            while(queue.size() != 0){
                int size = queue.size();
                while(size -- > 0){
                    int val = queue.poll();
                    List<Integer> list = son.get(val);
                    if(list != null){
                        for(Integer i : list){
                            isLock[i] = -1;
                            queue.offer(i);
                        }
                    }
                }
            }
            return true;
        }

        return false;
    }
}