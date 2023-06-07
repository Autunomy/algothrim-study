class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<reward2.length;++i) {
		    sum += reward2[i];
		    list.add(reward2[i] - reward1[i]);
		}
		Collections.sort(list);
		for(int i=0;i<k;++i){
		    sum -= list.get(i);
		}
		return sum;
    }
}