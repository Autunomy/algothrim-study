2642. 设计可以求最短路径的图类

```java
class Graph {
int [][]f;
   int n;
    public Graph(int k, int[][] e) {
        n=k;
        f=new int [n][n];
      
        for(int i=0;i<n;i++)
            Arrays.fill(f[i],Integer.MAX_VALUE);
        for(int i=0;i<n;i++)
            f[i][i]=0;
        for(int []x:e){
            f[x[0]][x[1]]=x[2];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int p=0;p<n;p++)
                {
                    if(f[j][i]!=Integer.MAX_VALUE&&f[i][p]!=Integer.MAX_VALUE){
                        f[j][p]=Math.min(f[j][p],f[j][i]+f[i][p]);
                    }
                }
            }
        }
        
        
    }
    
    public void addEdge(int[] e) {
        f[e[0]][e[1]]=Math.min(e[2],f[e[0]][e[1]]);
          for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int p=0;p<n;p++)
                {
                    if(f[j][i]!=Integer.MAX_VALUE&&f[i][p]!=Integer.MAX_VALUE){
                        f[j][p]=Math.min(f[j][p],f[j][i]+f[i][p]);
                    }
                }
            }
        }
    }
    
    public int shortestPath(int n1, int n2) {
        return f[n1][n2]==Integer.MAX_VALUE?-1:f[n1][n2];
    }
}

```