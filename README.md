# XPort [![](https://jitpack.io/v/BearCsxiong/xPort.svg)](https://jitpack.io/#BearCsxiong/xPort)
## 🔥快速构建App的基础代码,提供优质脚手架。快速构建
> **努力成为一个高级Android开发**
### 关于构建一个项目的一些想法和思想
---
- Q:为什么要基础架构？
- A:在接触很多开发者并且和他人开发者合作的时候发现,其实基础架构就意味着**沟通成本**,一个高效的基础架构是自带指导性质
    的模板,他存在**约束**,只有存在约束,在多人合作的时候才能高效。因项目差异可差异化部分内容,但绝大多数结构都**类似**
---
- Q:怎么样才算一个基础架构？
- A:这个是存在指标的,由多方评估一个基础架构的优劣,比较重要的两点就是健壮性和拓展性。架构很多,但是适合自己的才是最重要
    不要闭门造车,只有适合自己的轮子才能跑的舒服。
---
- Q:为什么要写这个项目?
- A:我的感觉是,只有在不断的记录和维护一段代码,才能逐渐完善思路并保证框架的健壮性.更希望能得到场景验证。另一方面主要是
    学习使用。
   
## 主要结构性框架
- 主要选择**Jetpack**下的基础框架,但是因为很多框架的实用性和现在部分开发冲突很大,暂时选择性的使用.
 
~DI~|UI DI|响应式编程|屏幕适配方案|数据库|网络请求|消息机制|基础结构
:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:
~Dagger2~|DataBinding|RxJava2|AndroidAutoSize|Room|OkHttp3<br>Retrofit|LiveData|Mvvm

## 结构性的框架主打拓展性和在未来一段时间内的稳定性,尽量在选择上更加追求稳定高效

### ~**DI**~
  > ~是一个控制反转的一个思想 解耦类间依赖的一个**控制器**,把某个类的依赖转移剥离出来。达到即插即用的一中思想~<br>
  > 放弃了DI注入的使用 初始构建类型的DI还是太重了
  
### **UI DI**
  > UI注入其实是一个帮助Android做findViewById的工具,DataBinding只是谷歌在知道性框架Architecture的一个UI DI的框架,<br>
    因为原生所以使用,同性质可查看ButterKnife
  
### ~**响应式编程**~
  > ~如大家所知,Java是一个静态语言,那么我们希望使用一个响应式的特性该怎么做呢,我们借助RxJava对流的封装达到响应式编程的效果~<br>
    ~RxJava其实也在Android纳入源码的思考当中,提供了诸多的帮助。~<br>
  > 学习成本太高,其实在日常中 使用的成本很高 不简易大范围使用。门槛很高
  
### **屏幕适配方案**
  > 主要是针对Android市场品种繁多屏幕碎片化严重而引入的解决框架,之前都是sw适配方案,此方案本人还待观察使用
  
### **数据库** 
  > 相对市面上其他的如GreenDao Realm ObjectBox等一系列主流数据库,Room仅存在一点优势,JetPack成员之一
  
### **网络请求** 
  > Android4.4开始HttpUrlConnection底层实现已经切换成OkHttp,我们有理由信任它,Retrofit其实是一套对OkHttp实现Restful风格Api的框架,<br>
  其中使用大量设计模式完善对Api的封装.
  
### **消息机制** 
  > 消息机制是一个相对泛的机制,种类也是五花八门,主流EventBus,RxBus这类,实现无非观察者模式实现内部带线程切换的一套机制.<br>
  LiveData本质并不是为了传递消息而设计的框架,但是其特点非常适合传递消息,作为消息机制使用,有很多的优点,也是JetPack成员之一
  
### **基础结构** 
  > 尽管市场上大多的应用还是主流的Mvp结构,但是响应Google结合DataBinding+ViewModel策略下实现的一套Mvvm结构的框架,我们决定使用Mvvm替代Mvp成为框架中主流的基础结构
  
## 更多大型项目的方案使用

|目的|框架|出处|Stars
|:-:|:-:|:-:|:-:
|模块化|[ARouter](https://github.com/alibaba/ARouter)| Alibaba|1w+
|RecycleView适配器|[xPort](https://github.com/csxiong/xPort)|[csxiong](https://www.jianshu.com/u/9022fb039221)|3
|权限管理|[IPermission](https://github.com/csxiong/IPermission)|[csxiong](https://www.jianshu.com/u/9022fb039221)|1

## 以上属于结构框架因为工作原因 暂时未在项目中补充完整 
## 下面记录一些软性框架的思想和业务的关系,只是自己的理解
 > 一个业务对另一个业务需要屏蔽细节代码 隔离代码</br>
 > 保持对外结构开放 包装细节</br>
 > 确定要写的【目标代码】,具体思考流程是怎么走的</br>
 > 保持对层的理解 确定某一层的【封装程度】,保持拓展性的关键
 
# 新世界
- 计划替代Dagger2集成Google开发者大会 新推出的基于Dagger的DI组件 Hilt
- Kotlin DSL封装
- AndroidX版本
- Kotlin 版本发布
