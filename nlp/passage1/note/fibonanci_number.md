## 斐波那契数列

斐波那契数列为``1, 1, 2, 3, 5, 8, 13, 21, ...``<br>
**问题:** 怎样求出序列中第N个数？？ (上帝密码)
```
def fib(n):
    # base case
    if n<3: 
        return 1
    
    return fib(n-2)+fib(n-1)

```

**时间复杂度:** 为 ``2^n``， （根据一棵树）<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/nlp/passage1/note/gongshi4.png?raw=true) <br>


因此需要知道这棵树到底有多深？？
```
n = 8 --> h=6
n = ... --> h=n-2
```
所以时间复杂度依赖于``2^n``，为``O(2^n)``。


### 空间复杂度
主要是为了介绍**递归方式下的空间复杂度** 。<br>
当一个函数调用另一个函数的适合，要进行上下文的切换，每次上下文切换都需要有内存空间的使用，我们称使用一个单位内存空间。




---------------------------
**参考:**<br>
1. https://blog.csdn.net/liu_zhen_kai/article/details/82630060



