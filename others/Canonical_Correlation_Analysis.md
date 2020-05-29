## 典型相关分析

### 1. 问题: 

在线性回归中，我们经常使用直线来拟合样本点，寻找``n``维特征向量``X``和输出结果``Y``之间的**线性关系**。其中 ``X∈R(n)， Y∈R``. ``Y``也可以是多维，我们希望分析出``X ``和``Y``的关系。<br>
假设``X∈R(n)， Y∈R(m)``， 那么可以建立等式``Y = AX``如下:<br>
![gongshi](https://raw.githubusercontent.com/shuangshuangshuangfeng/daguaishengji/master/others/CCA/gongshi.jpg?token=AFQPI7LS4PGOXOJFRGGREJC62DJFA)
其中![gongshi](https://raw.githubusercontent.com/shuangshuangshuangfeng/daguaishengji/master/others/CCA/gongshi2.png?token=AFQPI7OW7Q5IBFXPL3OECE262DJDM),形式和线性回归一样，需要训练``m``次得到``m``个``W(i)``。<br>


典型相关分析(Canonical correlation Analysis， CCA)

1. 首先寻找两组变量的线性组合，被称为典型变量，而他们之间的相关性是最大的。
2. 然后，再寻找第二对典型变量，使他们之间的相关性是第二大的，以此类推，知道相关性被提取完。即典型变量对的数目等于较短的数据集的变量数目。

这样，原本研究两组变量之间的相关性，现在就转换成研究提取出的这些典型变量之间的相关性，减少了研究变量的个数，大大提升了计算速率，从而被大家广泛使用。







## 基于典型相关分析的SSVEP分类








--------------------------------------
参考: <br>
1. https://blog.csdn.net/u012990623/article/details/39274513
2. https://www.doc88.com/p-6377755807426.html