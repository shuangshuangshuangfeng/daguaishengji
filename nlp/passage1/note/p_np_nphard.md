
## P and NP and NP hard and NP complete

问题按照时间复杂度来分类，可以分为两类:
- ``O(p^n)``， 被称为指数级复杂度，理论上理解为不可解决的问题， (``NP hard,``和``NP complete``属于不可解决的问题)
- ``O(n^p)``， 被称为多项式复杂度，可以解决的问题, (``P``, ``NP``问题属于可以解决的问题)

``p``看作是常数。

**他们的关系如下：**<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/nlp/passage1/note/gongshi6.png?raw=true) <br>


不能解决的问题又分为三种:
1. 小型问题，仍可以采用
2. 大型问题， 采用``Approximate algorithm``(近似算法), 不保证获得精确解
3. 量化计算机(量子计算机去计算)


例子： 对于``n! ≈ 2^n``， 所以也算是指数级复杂度。


-----------------------
**参考:** <br>
- https://blog.csdn.net/huang1024rui/article/details/49154507




