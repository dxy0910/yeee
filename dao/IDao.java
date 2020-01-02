package dao;
import java.util.*;
import java.io.*;
import entity.IEntity;
public interface IDao {
	void insert(IEntity entity) throws Exception;        			  //����
	void delete() throws Exception;                      			  //ɾ��
	void update() throws Exception;                                   //�����޸�
	public HashMap<String ,IEntity> getAllEntities() throws Exception;//˫�м��� 
	public IEntity getEntity(String Id);                  			  //����
}
