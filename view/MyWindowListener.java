package view;

import java.awt.*;

import java.awt.event.*;

class MyWindowListener extends WindowAdapter{ //ͨ���̳к��ʵ���������ʵ�ּ������ӿڣ�����������ô���
	//�����������¼�������������
	//��ʵ���������Źرմ��ڣ�
	public void windowClosing(WindowEvent e){  //�رմ��ڷ���
		Window window = e.getWindow();
		window.setVisible(false);  
		window.dispose();                  //�ͷŴ���
	}
}
