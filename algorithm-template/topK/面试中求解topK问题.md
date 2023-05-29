在面试中会被经常问到topK的问题，接下给出四种解法
# 直接排序

直接将数组进行排序（降序），然后取出前k个元素，这是最容易想到的。

直接排序是对整个数组进行全局操作排序，通过如快速排序等效率较高的排序算法，时间复杂度至少是O(N*logN)。

# 局部排序

**冒泡排序**是一个全局排序，每执行一次，就会确定一个元素的最终位置，可以通过冒泡排序，执行K次便可以确定最终结果。时间复杂度是O(N*K)。当k<<n时，O(N*K)的性能会比O(N*logN)好。

```java
//求topK小的所有数
public int[] minTopK(int[] arr,int k){
    if(k <= 0 || k > arr.length){
        return null;
    }

    int n = arr.length;
    int[] res = new int[k];
    for(int i=0;i<k;++i){
        //注意：从后向前遍历
        for(int j=n-1;j>=1;--j){
            //使用 < 就是求topK大的数 使用 > 就是求topK小的数
            if(arr[j-1] < arr[j]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j-1] = temp;
            }
        }
        res[i] = arr[i];
    }

    return res;
}

//求topK大的所有数
public int[] minTopK(int[] arr,int k){
    if(k <= 0 || k > arr.length){
        return null;
    }

    int n = arr.length;
    int[] res = new int[k];
    for(int i=0;i<k;++i){
        //注意：从后向前遍历
        for(int j=n-1;j>=1;--j){
            //使用 < 就是求topK大的数 使用 > 就是求topK小的数
            if(arr[j-1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j-1] = temp;
            }
        }
        res[i] = arr[i];
    }

    return res;
}
```

**选择排序**也是一个全局排序，每执行依次，就会通过确定一个最大的或最小的放在一端，通过选择排序，执行K次就可以得到最大的K个数了。时间复杂度时O(N*K)。

```java
//求topK小的所有数
public int[] minTopK(int[] arr,int k){
    if(k <= 0 || k > arr.length){
        return null;
    }

    int n = arr.length;
    int[] res = new int[k];
    for(int i=0;i<k;++i){
        //注意：从后向前遍历
        for(int j=i+1;j<n;++j){
            //使用 < 就是求topK大的数 使用 > 就是求topK小的数
            if(arr[i] < arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        res[i] = arr[i];
    }

    return res;
}
//求topK大的所有数
public int[] minTopK(int[] arr,int k){
    if(k <= 0 || k > arr.length){
        return null;
    }

    int n = arr.length;
    int[] res = new int[k];
    for(int i=0;i<k;++i){
        //注意：从后向前遍历
        for(int j=i+1;j<n;++j){
            //使用 < 就是求topK大的数 使用 > 就是求topK小的数
            if(arr[i] > arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        res[i] = arr[i];
    }

    return res;
}
```

# 分治(快排)
快速排序的核心是分治思想，先通过分治partition把序列分为两个部分，再将两个部分进行再次递归

利用分治思想，即划分操作partition，根据主元素pivot调整序列，比pivot大的放在左端，比pivot小的放在右端，这样确定主元素pivot的位置pivotIndex，如果pivotIndex刚好是k-1，那么前k-1位置的数就是前k大的元素，即我们要求的top K。

利用分治算法中的特例——减治法（二分查找就是一种典型的减治法），判断如果pivotIndex大于k-1,那就只需进入pivotIndex的左端区域递归；如果pivotIndex小于k-1,那就只需进入pivotIndex的右端区域递归。

时间复杂度为O(N)。

注意：这里求出的topK并不是有序的

```java
import java.io.*;
import java.util.*;


public class Test{

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,8,4,7,6,9};
        int n = arr.length;
        int k = 8;

        //调用的时候注意需要传递的参数是0和n-1不是n
        int[] res = quickSort(arr,0,n-1,k);


        for(int i=0;i<k;++i){
            System.out.print(res[i] + " ");
        }
    }

    //求topk小的数
    public static int[] quickSort(int[] arr,int l,int r,int k){
        if(k <= 0 || k > arr.length){
            return null;
        }
        
        int i = l-1;
        int j = r+1;
        int mid = (l + r) / 2;

        while(i < j){
            //这两个大小于号如果是此时的状态就是求topK小,如果两个都与当前相反则求topK大
            do i++;while(arr[i] < arr[mid]);
            do j--;while(arr[j] > arr[mid]);

            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        if(mid == k-1){
            int[] res = new int[k];
            for(int z=0;z<k;++z) res[z] = arr[z];
            return res;
        }else if(l == r){
            return null;
        }else if(mid > k-1){
            return quickSort(arr,l,j,k);
        }else{
            return quickSort(arr,j+1,r,k);
        }
    }
}
```

# 堆排序

维护一个大小为k的堆，将所有元素都遍历一遍并放入堆中，如果堆中元素超过k就将堆顶弹出

```java
public int[] heapSort(int[] arr,int k){

    //默认是小根堆，求topK大
    PriorityQueue<Integer> q = new PriorityQueue<>();
    //大根堆 求的是topK小
    // PriorityQueue<Integer> q = new PriorityQueue<>((x,y)->(y-x));


    for(int i=0;i<arr.length;++i){
        q.offer(arr[i]);
        if(q.size() > k){
            q.poll();
        }
    }

    int[] res = new int[k];
    int i = 0;
    while(q.size() > 0){
        res[i ++ ] = q.poll();
    }
    return res;
}
```