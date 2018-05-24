# CheckExperimentSimilarity
检查实验报告内容的相似度。
=====
实验报告以word文档形式存在，doc或docx为扩展名。 使用simhash算法检测。

#### 程序入口
<p> cn.sdkd.ccse.cise.ces.Main</p>


#### 说明
<p> 使用hanlp分词。</p>
<p> 采用单线程和多线程两种方式运行，默认采用单线程方式运行。</p>
<p> 多线程方式借鉴jay-bill/check-similarity</p>

#### 修改日志
<p>2018-05-24 处理从蓝墨云班课中导出的文件夹，每个文件夹对应一个学生，一个文件夹中可能有多个提交文档</p>
<p>2018-05-20 按照相似度从大到小的顺序排序，按照（文档1， 文档2， 相似度）格式，若相似度为1，则非常大的概率是雷同文档。
           相似度为0.98的文档中也可能存在一些雷同的，比文档1是文档2的子集。</p>
