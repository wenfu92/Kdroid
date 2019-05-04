## Kdroid 架构清单
#### 工具 
   * Kotlin 
   * Kotlin Android Extensions
   * KTX 
#### 基础 
   * Jetpack 
   * Lifecyc>le 
   * ViewModel 
   * LiveData 
   * Room 
   * Paging 
   * Data binding 
 
#### 网络
   * OKHttp 
   * Retrofit 
   * Glide 
#### 事件分发 
   * EventBus 
#### 屏幕适配
   * autoSize
#### 辅助开发 
   * LeakCanary 
   * BlockCanary 
   * StrictMode 
   * STETHO 
 
#### 测试相关 
   * Esspresso 
 
#### 异步处理 
   * RxJava 
   * RxAndroid 
 
#### 图片 
   * 确认服务器端是否支持缩放操作 
   * 如果支持,根据imageView的高度,动态调整缩放参数,确保不加载大分辨率的图片 
#### 其他 
   * RxPermissions 
   * RxBinding 
#### 性能优化测试 
   * 使用Stetho分析profile 
 
#### 规避 
   * 慎用dagger。明白依赖注入思想可以手动来处理 
 
 
#### 约定和规范 
   * 凡是IO的操作,都要加上checkThread的检查 
   * 命名规范应该遵守 
https://blog.mindorks.com/android-code-style-and-guidelines-d5f80453d5c7 
   * 不要吞掉异常,最低要打印出来 
 
