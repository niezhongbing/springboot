package com.itmayiedu.test01.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itmayiedu.entity.UserEntity;
import com.itmayiedu.test01.mapping.UserMapper1;
import com.itmayiedu.test02.mapping.UserMapper2;

@Service
public class UserService1 {
   // private static final Logger log = LoggerFactory.getLogger(UserService1.class);
   private static final Logger logger = LoggerFactory.getLogger(UserService1.class);
	@Autowired
	private UserMapper1 userMapper1;
	
	@Autowired
	private UserMapper2 userMapper2;
	
	@Transactional
	 public int addUser1 (UserEntity userEntity){
		 userMapper2.addUser(userEntity.getName(), userEntity.getAge());
		 userMapper1.addUser(userEntity.getName(), userEntity.getAge());
		 return 1;
	 }
	
	public List<UserEntity> select(Long id){
		List<UserEntity> select = userMapper1.select(id);
		return select;
	}
	
	@Async
	public void thearAsync() throws Exception{
		logger.info("我是2");
		for (int i = 0; i < 5; i++) {
			logger.info("循环中" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("我是3");
		//new TheardDemo().start();
	}
	/*class TheardDemo extends Thread{
		@Override
		public void run() {
			logger.info("我是2");
			for (int i = 0; i < 5; i++) {
				logger.info("循环中" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			logger.info("我是3");

		}
	}*/
	
	public List<UserEntity> selectAll(){
		return   userMapper1.selectAll();
	}
	
	 public Page<UserEntity> findByPage(int pageNo, int pageSize) {
	        PageHelper.startPage(pageNo, pageSize);
	        int i = 1;
	        i = 2;
	        return userMapper1.selectPageHelper();
	    }
}
