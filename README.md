# android_app

实现一个登陆界面、注册界面、主界面、详情界面之间的跳转,参考qq；

1.登陆界面包含：用户名、密码、记住密码、注册按钮（必须是图片按钮）、登陆按钮1；具有一个action bar:包含刷新，搜索、更换背景三个选项；点击按钮1可以toast用户名+密码；

2.注册界面：姓名、性别（radiobutton）、年龄(number)、祖籍（spiner）、个人照片(image)、这学期学习的所有课程（使用checkbox,选择自己喜欢的2门课程）、登陆按钮2；点击按钮2可以logcat姓名+性别+年龄+足迹+课程；同时跳转到新的界面，在新的界面显示注册的内容；

3.添加显式启动；隐式启动：把自己的程序也作为可以显示的；

4.增加接收短信，界面弹出toast显示提示消息。

5.在任何一页界面：点击按钮，实现产生随机数，并将随机数显示在这个界面；
