2698. 求一个整数的惩罚数

```java
class Solution {
    public int punishmentNumber(int n) {
    	int[] arr = new int[1001];
    	for(int i=1;i<=1000;++i){
    		List<Integer> list1 = new ArrayList<>();
    		int temp = i*i;
    		while(temp > 0) {
    			list1.add(temp % 10);
    			temp /= 10;
    		}
    		List<Integer> list2 = new ArrayList<>();
    		for(int j=list1.size()-1;j>=0;--j){
    			list2.add(list1.get(j));
    		}

    		if(judge(list2,i,0,0)) {
    			arr[i] = arr[i-1] + i*i;
    		}else{
    			arr[i] = arr[i-1];
    		}
    	} 
        
        return arr[n];
    }
    boolean judge(List<Integer> arr,int i,int sum,int u){
    	int len = arr.size();
    	if(u == len){
    		if(sum == i){
    			return true;
    		}
    		return false;
    	}

    	boolean res = false;

    	for(int k = u;k<len;++k){
    		int temp = 0;
    		for(int z=u;z<=k;++z){
    			temp *= 10;
    			temp += arr.get(z);
    		}

    		res = res || judge(arr,i,sum + temp,k+1);
    	}

    	return res;
    }
}
```