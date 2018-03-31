package com.taotao.controller;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 
 * @author xiafei
 * Title:ItemCatController.java
 * Company:
 * @date 2018年3月31日
 */
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<EasyUITreeNode> list = itemCatService.getItemCatList(parentId);
		return list;
		
	}
	
}
