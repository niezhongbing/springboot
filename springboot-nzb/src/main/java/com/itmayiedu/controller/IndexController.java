
package com.itmayiedu.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.itmayiedu.entity.Gifts;
import com.itmayiedu.entity.UserEntity;
import com.itmayiedu.exception.MyException;
import com.itmayiedu.mapper.UserMapper;
import com.itmayiedu.test01.service.UserService1;
import com.itmayiedu.test02.service.UserService2;

@Controller
public class IndexController {
	private Logger logger =  LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService1 userService1;
	
	@Autowired
	private UserService2 userService2;
	
	@Autowired
	private	CacheManager cacheManager;
	
	
	@Value("${name}") //自定义参数
	private String name;
	
	@ResponseBody
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	
	@ResponseBody
	@RequestMapping(value = "getUserName", method = RequestMethod.GET)
	public UserEntity getUserName(String name) throws Exception {
		return userMapper.findName(name);
	}

	@ResponseBody
	@RequestMapping(value = "addUser", method = RequestMethod.GET)
	public String addUser() throws Exception {
		UserEntity userEntity = new UserEntity();
		userEntity.setAge(3);
		userEntity.setId(3L);
		userEntity.setName("王五3");
		int addUser1 = userService1.addUser1(userEntity);
		return "success";
		
	}
	
	@RequestMapping("/json")
	public String json() throws MyException {
		throw new MyException("发生错误2");
	}
	
	@ResponseBody
	@RequestMapping("/param")
	public String param(@RequestParam(name = "name", defaultValue = "1") String name) throws MyException {
		int i = 1 / 0;
		return "测试打印日志";
	}
	
	@ResponseBody
	@RequestMapping("/selectById")
	public String selectById(@RequestParam Long id){
		List<UserEntity> select = userService1.select(id);
		return select.toString();
	}
	
	@ResponseBody
	@RequestMapping("/clearCache")
	public String clearCache(){
		cacheManager.getCache("baseCache").clear();
		return "清除缓存成功";
	}
	
	@ResponseBody
	@RequestMapping("/threadAsync")
	public String threadAsync() throws Exception{
		logger.info("我是1");
		userService1.thearAsync();
		/* new Runnable() {
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
		};*/
		logger.info("我是4");
		return "测试异步";
	}
	
	@ResponseBody
	@RequestMapping(value="/getName")
	public String getName(){
		return name;
	}
	
//	@RequestMapping(value="/imgUrl")
//	public String imgUrl(){
//		return "vue/vue_test1";
//	}
	
	@RequestMapping(value="/vue")
	public String httpVue(){
		return "vue/vue";
	}
	
	@ResponseBody
	@RequestMapping("/selectAll")
	public String selecAll(){
		List<UserEntity> select = userService1.selectAll();
		return select.toString();
	}
	
	@ResponseBody
	@RequestMapping("/findByPage")
	public String findByPage(@RequestParam Map<String, Object> map){
		 Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
		 Integer pageSize = Integer.parseInt(map.get("pageSize").toString());

		 Page<UserEntity> select = userService1.findByPage(pageNo, pageSize);
		return select.toString();
	}
	
	@RequestMapping(value="/vueCart")
	public String vueCart(@RequestParam Map<String, Object> paramMap){
		List<Gifts> selectAllGifts = userService1.selectAllGifts(paramMap);
		for (Gifts gifts : selectAllGifts) {
			logger.info(gifts.getGiftsname());
		}
		return "vue/vue_cart";
	}
	
	@ResponseBody
	@RequestMapping(value="/inserGifts")
	public String inserGifts(){
		Gifts gifts = new Gifts();
		gifts.setGiftsname("张三");
		if(userService1.inserGifts(gifts) > 0)
			return "添加成功";
		else 
			return "添加失败";
	}
	
	@RequestMapping(value="/vueAddress")
	public String vueAddress(){
		return "vue/vue_address";
	}
}
