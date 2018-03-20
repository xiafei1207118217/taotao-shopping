package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemid) {

		//根据主键查询
		//TbItem item = itemMapper.selectByPrimaryKey(itemid);
		
		//根据查询条件查询
		TbItemExample example = new TbItemExample();
		//添加查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemid);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0 ) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

}
