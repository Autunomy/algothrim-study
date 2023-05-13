func findMaxK(nums []int) int {
	set := make(map[int]bool)
	n := len(nums)
	for i := 0;i<n;i++{
		set[nums[i]] = true
	}

	res := -1
	for i := 0;i<n;i++{
		if nums[i] > 0 && set[-nums[i]]{
			res = max(res,nums[i])
		}
	}
	return res
}

func max(a int,b int) int{
    if a > b{
        return a
    }else{
        return b
    }
}