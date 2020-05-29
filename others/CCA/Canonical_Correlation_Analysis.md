## 典型相关分析(Canonical correlation Analysis， CCA)

### 1. 概述

- 简单相关系数描述两组变量的相关关系的缺点:只是孤立考虑单个X与单个Y间的相关，没有考虑X、Y变量组内部各变量间的相关。两组间有许多简单相关系数，使问题显得复杂，难以从整体描述。
- 典型相关是简单相关、多重相关的推广。典型相关是研究两组变量之间相关性的一种统计分析方法。也是一种降维技术。

### 2. 问题: 

在线性回归中，我们经常使用直线来拟合样本点，寻找``n``维特征向量``X``和输出结果``Y``之间的**线性关系**。其中 ``X∈R(n)， Y∈R``. ``Y``也可以是多维，我们希望分析出``X ``和``Y``的关系。<br>
<br>
假设``X∈R(n)， Y∈R(m)``， 那么可以建立等式``Y = AX``如下:<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongshi.jpg?raw=true) <br>
其中![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongshi2.png?raw=true),形式和线性回归一样，需要训练``m``次得到``m``个``W(i)``。<br>
<br>
这样做的缺点是： ``Y``中每一个特征都与``X``的所有特征相关联，``Y``中的特征之间没有什么联系。

也就是说将``X``和``Y``看作各自的整体，考察这两个整体之间的关系，我们将整体表示成``X``和``Y``各自特征间的线性组合， 也就是考察``aTx``和``bTy``之间的关系。

**例子：**<br>
考察一个人解题能力``X``（解题速度x1, 接替正确率x2）与他的阅读能力``Y``（阅读速度y1,理解程度y2）之间的关系，那么形式化为：<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongshi3.png?raw=true) <br>
然后使用皮尔逊相关系数(Pearson相关系数)：<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongshi4.png?raw=true) <br>
来度量``u``和``v``的关系，我们期望寻求一组最优的解``a``和``b``，使得``Corr(u,v)``最大，这样得到的``a``和``b``就是使得``u``和``v``就有最大关联的权重。

### 3. 典型相关分析

-  首先寻找两组变量的线性组合，被称为典型变量，而他们之间的相关性是最大的。
-  然后，再寻找第二对典型变量，使他们之间的相关性是第二大的，以此类推，知道相关性被提取完。即典型变量对的数目等于较短的数据集的变量数目。

这样，原本研究两组变量之间的相关性，现在就转换成研究提取出的这些典型变量之间的相关性，减少了研究变量的个数，大大提升了计算速率，从而被大家广泛使用。

**典型相关分析的实质是：**<br>
在两组随机变量中选择若干个有代表性的综合指标（变量的线性组合），用这些综合指标的相关关系来表示原来的两组变量的相关关系。当典型相关系数足够大时，可以像回归分析那样，由一组变量的数值预测另一组变量的线性组合的数值。



## 基于典型相关分析的SSVEP分类

当CCA应用于提取SSVEP响应频率时，两组多变量分别定义为``X``和``Y``， 其中``X``是``EEG``的多``channel``信号。<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongshi5.png?raw=true) <br>
式子中，``channel``的下标表示不同信道的编号，``Y``是与刺激频率``f``相关的参考信号:<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongshi6.png?raw=true) <br>

式中，``N``是``f``的谐波个数，``X``中``channel``数量也是``N``。<br>
![gongshi](https://github.com/shuangshuangshuangfeng/daguaishengji/blob/master/others/CCA/gongshi7.png?raw=true) <br>
通过计算出``X``和``Y``的相关系数``ρ``的最大值，选取不同的``f``，计算``ρ``，则最大``ρ``对应的频率被认为是SSVEP的响应频率。




--------------------------------------
参考: <br>
1. https://blog.csdn.net/u012990623/article/details/39274513
2. https://www.doc88.com/p-6377755807426.html
3. https://zhuanlan.zhihu.com/p/37609917