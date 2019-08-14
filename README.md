# ConstraintSample
This project contains android ConstraintLayout2.0 usages and MotionLayout usage, includes xml tools attributes as well.

> 主要用来练习和扩展一些关于 ***`ConstraintLayout`***、***`MotionLayout`***  的用法，还包含 Google 新推的 Android 工具 — ***`sample data`*** 等。

## 最新进展

- **ConstraintLayout 1.x** 功能大致实践完毕

- **sample data** 用法应用完毕

- **MotionLayout** 入门版实践完毕

- 结合 MD 系列组件实现部分复杂交互效果

- 结合 **Lottie** 实现联动效果（目前停滞），暂时用 ViewPager 配合 Lottie 实现联动效果

- Alpha version preview:

  ![alpha-preview](https://github.com/Moosphan/ConstraintSample/blob/86e8ee00637364a1274ebf22db5ff92e9cfb4ce1/arts/motion_preview1.gif)



## 问题收集

- 官方提供的demo在通过 DrawerMotion 与 CoordinatorLayout 中已有 Motion 交互时出现 NestedScrollView 滑动问题
- android.support 版 ConstrintLayout：2.0.0-beta2 包在运行demo代码时出现 motion 的 progress 无效问题，并且设置 debugMode 会闪退。问题详见：[#95](https://github.com/googlesamples/android-ConstraintLayoutExamples/issues/95)

## 接下来

- 解决上述问题
- 优化和重构 Motion 交互和逻辑代码
- **MotionLayout** 等进一步熟悉和进阶用法以及效果实现
- 将 **MotionLayout** 与 **Material design** 系列控件组合使用，实现复杂效果
- 实战demo的制作以及相关文章编撰
- 补充相关参考文档和国外相关文章
- 文档说明和相关效果图的实时跟进

## Learn more

> *[Using MotionLayout to Animate Android Apps](https://codelabs.developers.google.com/codelabs/motion-layout/index.html?index=..%2F..index#0)*
>
> *[MotionLayout官方介绍](https://developer.android.com/training/constraint-layout/motion-layout)*

## What's more?

每日一道面试题，挖掘更加强大的自己👉：[**Android Daily Interview**](https://github.com/Moosphan/Android-Daily-Interview)