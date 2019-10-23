# AILaw
法律小智囊微信小程序

## 项目背景
```
在现实生活中，不少人民群众遇到法律问题时，因为法律意识淡薄或寻求法律援助困难，并没有使法律成为保护自身合法权益的有效武器
或不小心踏入法律的“雷区”。法律小智囊微信小程序立足法律智能为公众提供法律服务，包含法律智能问答，刑事案件罪名、所犯法律条
文和量刑期限推理以及法律条文搜索引擎等功能。
```

## 文件介绍
文件名|作用|
|:---|:---|
|LittleDemo|微信小程序源代码|
|criminal|法律条文搜索引擎服务源代码|
|kg|法律智能问答服务和热门法律知识浏览服务源代码|
|lawPredict|根据法律文书预测嫌疑人罪名、触犯法律条文和量刑期限服务源代码|

## 项目说明
```
此项目后台采用SpringBoot开发，用到了MySql、ElasticSearch和MongoDB三种存储技术，参考微服务的设计思想将程序功能水平分解，
并采用Nginx作为反向代理服务器。后台还用到了腾讯云的语音识别、手写体识别和印刷体识别三种API，这部分源代码并未提供。本项目未进
行商业化，但是用到的数据却是有价值的，所以并未提供，读者可以根据下一小节的内容自己去下载或爬取构建语料库。
```

## 数据获取
[刑事案件智能推理（预测罪名、量刑期限和所触犯的法律条文）数据集](https://github.com/cswangyuhui/CAIL)

[法律问答数据语料库](http://www.64365.com/zs/quanbufenlei/)

[法律条文语料库](https://www.66law.cn/tiaoli/)

### 项目成果

<div align=center><img width="1100" height="600" src="https://github.com/cswangyuhui/AILaw/blob/master/image/weixin1.png"/></div>

### 项目截图

<div align=center><img width="1100" height="600" src="https://github.com/cswangyuhui/AILaw/blob/master/image/weixin2.png"/></div>



