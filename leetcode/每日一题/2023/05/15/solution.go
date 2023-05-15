func maxEqualRowsAfterFlips(matrix [][]int) int {
	n := len(matrix)
	m := len(matrix[0])

	res := 0

	ma := make(map[string]int)

	for i := 0;i<n;i++{
		var sb strings.Builder
		for j:=0;j<m;j++{
			if matrix[i][0] == 0{
				sb.WriteString(string(matrix[i][j]))
			}else{
				sb.WriteString(string(matrix[i][j] ^ 1))
			}
		}

		ma[sb.String()] ++

		res = max(res,ma[sb.String()])
	}
	return res
}

func max(a int,b int) int{
	if a > b {
		return a
	}else {
		return b
	}
}