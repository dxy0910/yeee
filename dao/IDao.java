package dao;
import java.util.*;
import java.io.*;
import entity.IEntity;
public interface IDao {
	void insert(IEntity entity) throws Exception;        			  //增加
	void delete() throws Exception;                      			  //删除
	void update() throws Exception;                                   //更新修改
	public HashMap<String ,IEntity> getAllEntities() throws Exception;//双列集合 
	public IEntity getEntity(String Id);                  			  //查找
}
