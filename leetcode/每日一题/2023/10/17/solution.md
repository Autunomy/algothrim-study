2652. 倍数求和

```java
class Solution {
    public int sumOfMultiples(int n) {
        int cnt3 = n / 3;
        int cnt5 = n / 5;
        int cnt7 = n / 7;
        int cnt35 = n / 15;
        int cnt37 = n / 21;
        int cnt57 = n / 35;
        int cnt357 = n / 105;

        return fun(3,cnt3)+fun(5,cnt5)+fun(7,cnt7)-fun(15,cnt35)-fun(21,cnt37)-fun(35,cnt57)+fun(105,cnt357);
    }

    public int fun(int a1,int n){
        return a1*n + n*(n-1)*a1/2;
    }
}
```