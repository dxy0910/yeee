package view;

import java.awt.*;
import java.awt.event.*;

public class MainGUI extends MouseAdapter{
	
	public static void main(String[] args) throws Exception {
		final Frame f = new Frame("ѧ������ϵͳ");
		f.setLayout(new FlowLayout());
		f.setSize(800, 600);                  //���ô��ڿ��
		f.setLocation(500,300);               //���ô��ڳ�������Ļ�ϵ�λ��
		f.setVisible(true);                   //���ô���ɼ�
		
		Button but = new Button("Button");    //������ť����
		f.add(but);                           //�ڴ�����Ӱ�ť���
		//Ϊ��ť�������¼�������
		
		{//ʵ�ִ��ڹر�
			MyWindowListener mw = new MyWindowListener();  //ע�������
			f.addWindowListener(mw);                       //��������������󶨣����ر��ͷ�
		}
		CourseSelection.main();
	}

}
