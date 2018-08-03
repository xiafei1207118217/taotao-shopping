package com.taotao.controller;

import java.util.List;

import org.apache.tomcat.util.http.mapper.Mapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
public class TestPageHelper {
	@Test
	public void testPageHelper() {
		//创建一个spring容器
	  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得Mapper的代理对象
	  TbItemMapper mapper =  applicationContext.getBean(TbItemMapper.class);
	  //执行查询并分页
	  TbItemExample example = new TbItemExample();
	  //分页处理
	  PageHelper.startPage(2, 10);
	  List<TbItem> list= mapper.selectByExample(example);
	  //取商品列表
	  for(TbItem tbItem : list) {
	  	System.out.println(tbItem.getTitle());
	  }
	  //取分页信息
	  PageInfo pageInfo = new PageInfo(list);
	  long total = pageInfo.getTotal();
	  System.out.println("一共有商品信息："+total);
	}

}
