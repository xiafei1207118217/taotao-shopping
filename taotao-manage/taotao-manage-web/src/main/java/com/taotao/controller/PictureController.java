package com.taotao.controller;
/**
 * 上传图片处理
 * @author xiafei
 * Title:PictureController.java
 * Company:
 * @date 2018年8月6日
 */

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;

public class PictureController {

	@Autowired
	PictureService pictureService;
	
	@RequestMapping("/pic/upload" )
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) {
		Map result = pictureService.uploadPicture(uploadFile);
		//为了保证功能的兼容性，需要把result转换成json格式的字符串
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}
