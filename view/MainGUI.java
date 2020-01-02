package view;

import java.awt.*;
import java.awt.event.*;

public class MainGUI extends MouseAdapter{
	
	public static void main(String[] args) throws Exception {
		final Frame f = new Frame("学生管理系统");
		f.setLayout(new FlowLayout());
		f.setSize(800, 600);                  //设置窗口宽高
		f.setLocation(500,300);               //设置窗口出现在屏幕上的位置
		f.setVisible(true);                   //设置窗体可见
		
		Button but = new Button("Button");    //常见按钮对象
		f.add(but);                           //在窗口添加按钮组件
		//为按钮添加鼠标事件监听器
		
		{//实现窗口关闭
			MyWindowListener mw = new MyWindowListener();  //注册监听器
			f.addWindowListener(mw);                       //将窗口与监听器绑定，并关闭释放
		}
		CourseSelection.main();
	}

}
