## 典型相关分析

### 1. 问题: 

在线性回归中，我们经常使用直线来拟合样本点，寻找``n``维特征向量``X``和输出结果``Y``之间的**线性关系**。其中 ``X∈R(n)， Y∈R``. ``Y``也可以是多维，我们希望分析出``X ``和``Y``的关系。<br>
<br>
假设``X∈R(n)， Y∈R(m)``， 那么可以建立等式``Y = AX``如下:<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongshi.jpg?raw=true) <br>
其中![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongshi2.png?raw=true),形式和线性回归一样，需要训练``m``次得到``m``个``W(i)``。<br>
<br>
这样做的缺点是： ``Y``中每一个特征都与``X``的所有特征相关联，``Y``中的特征之间没有什么联系。

也就是说将``X``和``Y``看作各自的整体，考察这两个整体之间的关系，我们将整体表示成X和Y各自特征间的线性组合， 也就是考察``aTx``和``bTy``之间的关系。

**例子：**<br>
考察一个人解题能力X（解题速度x1, 接替正确率x2）与他的阅读能力（阅读速度y1,理解程度y2）之间的关系，那么形式化为：<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongsh3.png?raw=true) <br>
然后使用皮尔逊相关系数(Pearson相关系数)：<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongsh4.png?raw=true) 来度量``u``和``v``的关系，我们期望寻求一组最优的解``a``和``b``，使得``Corr(u,v)``最大，这样得到的``a``和``b``就是使得``u``和``v``就有最大关联的权重，

### 典型相关分析(Canonical correlation Analysis， CCA)

1. 首先寻找两组变量的线性组合，被称为典型变量，而他们之间的相关性是最大的。
2. 然后，再寻找第二对典型变量，使他们之间的相关性是第二大的，以此类推，知道相关性被提取完。即典型变量对的数目等于较短的数据集的变量数目。

这样，原本研究两组变量之间的相关性，现在就转换成研究提取出的这些典型变量之间的相关性，减少了研究变量的个数，大大提升了计算速率，从而被大家广泛使用。







## 基于典型相关分析的SSVEP分类








--------------------------------------
参考: <br>
1. https://blog.csdn.net/u012990623/article/details/39274513
2. https://www.doc88.com/p-6377755807426.html