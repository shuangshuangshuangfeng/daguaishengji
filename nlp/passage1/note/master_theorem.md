## 主定理方法(Master's theorem)

主定理方法主要是下面的这张图:<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/nlp/passage1/note/gongshi2.png?raw=true) <br>

### 简单的理解是:

**主方法适合:** <br>
``T(n) = a*T(n/b) + f(n)`` <br>
即把一个问题的复杂度分为若干个比它小的子问题来解决。


**具体求该复杂度的过程如下：** <br>

1. 首先计算出![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/nlp/passage1/note/gongshi3.png?raw=true) [用``n^logb_a``来表示]， 然后与``f(n)``进行比较。

    - 若``O(n^logb_a) > f(n)``， 则复杂度为``O(n^logb_a)``
    - 若``O(n^logb_a) < f(n)``， 则复杂度为``O(n^logb_a)*log(n)^k``
    - 若``O(n^logb_a) = f(n)``， 则复杂度为``O(f(n))``

因此核心就是计算出若``n^logb_a)``， 然后再计算出``f(n)``, 最后进行比较，得出时间复杂度。

### 例子

1. 
``T(n) = 3*(n/2) + n^2`` :
```
a = 3, b=2
n^logb_a = n^log2_3
f(n) = n^2
n^log2_3 < n^2
```
因此时间复杂度为``O(f(n)) = O(n^2)``

2. 
``T(n) = 4*T(n/2) + n^2`` :
```
a=4, b=2
n^logb_a = n^log2_4 = n^2
f(n) = n^2
n^2 = n^2
```
因此时间复杂度为``O(f(n)*(logn)^(k+1))``<br>
首先要看``f(n)``中有没有``k``的值， ``f(n) = n^2 = n^2 * (logn)^0``, 因此``k=0``。<br>
所以时间复杂度为``O(f(n)*(logn)^(k+1)) = O(f(n)) = O(n^2 * logn)`` 。

3. 
归并排序中，``T(n) = 2*T(n/2) +n``
```
a = 2, b = 2
n^logb_a = n^log2_2 = n
f(n) = n
n = n
```
``f(n)``中``k=0``， 因此时间复杂度为``O(f(n)*(logn)^(k+1)) = O(nlogn)``。

4. 
``T(n) = 16*T(n/4)+n``:
```
a=16, b=4
n^logb_a = n^2
f(n) = n
n^2>n
```
因此时间复杂度为``O(n^logb_a) = O(n^2)``。



-------------------------
**参考：** <br>
1. https://blog.csdn.net/weixin_40673608/article/details/85312414


