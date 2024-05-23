# 安卓期末大作业

这个项目是我在数媒学专业大二下学期的安卓课程的期末大作业。它是一个普通的安卓应用，旨在展示我在安卓开发方面的学习成果。

## 项目简介

该APP分别包含启动页、首页、智游和个人中心四大模块。其中，首页、智游和个人中心三大模块构成了主程序模块。
启动页模块采用了动态的gif图作为背景，通过第三方库实现，并增加了按钮跳转功能，方便用户快速进入主程序模块。
主程序模块则采用底部导航栏和fragment实现了首页、智游和个人中心三大模块。首页模块包括轮播图、概况、初识度假区、精彩活动、门票预订和通知公告列表等功能。轮播图使用ViewPager控件和PagerAdapter适配器实现，概况、初识度假区和精彩活动则通过TabLayout和ViewPage2配合实现，而门票预订则需要用户选择数量、日期和时间段，并将购票信息保存数据传送到个人订单中。通知公告列表则简单通过TextView实现。
智游模块包括美食、住宿、游玩、娱乐和乡村五个小模块，通过模块化设计实现了点击某个模块后显示其具体内容的功能。具体实现方式是，点击相应图片通过相关方法实现activity跳转。
个人中心模块则包括用户注册、登录和订单三大模块。用户注册信息包括账号、姓名、性别、电话、职业、兴趣和日期等，点击注册按钮后将账号密码传入登录模块。用户登录则是通过注册模块传入相应数据实现的，用户购票记录则通过接收购票模块传入的数据实现订单加载。


## 如何使用

进入Relase下载安装包体验

## 截图

- ![住](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/住.gif)
- ![初识度假区](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/初识度假区.gif)
- ![吃](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/吃.gif)
- ![启动页](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/启动页.gif)
- ![娱](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/娱.gif)
- ![我的订单](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/我的订单.gif)
- ![概况](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/概况.gif)
- ![注册](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/注册.gif)
- ![游](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/游.gif)
- ![登录](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/登录.gif)
- ![登录](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/登录.gif)
- ![行](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/行.gif)
- ![购票](https://cdn.jsdelivr.net/gh/H-Bole/Picture-home/blob/main/Andriod/购票.gif)

## 技术栈

- Java
- Android SDK


## 许可证

[MIT License](LICENSE)
