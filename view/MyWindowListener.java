package view;

import java.awt.*;

import java.awt.event.*;

class MyWindowListener extends WindowAdapter{ //通过继承合适的适配器来实现监听器接口，避免大量无用代码
	//监听器监听事件对象作出处理
	//（实现鼠标点击叉号关闭窗口）
	public void windowClosing(WindowEvent e){  //关闭窗口方法
		Window window = e.getWindow();
		window.setVisible(false);  
		window.dispose();                  //释放窗口
	}
}
