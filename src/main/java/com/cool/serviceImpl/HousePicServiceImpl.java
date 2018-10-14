package com.cool.serviceImpl;

import com.cool.dao.HousePicDAO;
import com.cool.entity.House;
import com.cool.entity.HousePicture;
import com.cool.entity.HouseUser;
import com.cool.service.HousePicService;
import com.cool.util.Tool;
import com.cool.util.Val;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

/**
 * @Auther: cjc 2018/8/31 0031
 */
@Service
public class HousePicServiceImpl implements HousePicService {

	@Resource
	private HousePicDAO housePicDAO;

	/*
	 * 1、判断house对应的文件夹是否存在
	 * 2、保存文件到指定的文件夹
	 * 3、把数据插入到数据库，即添加一条photoInfo记录
	 */
	@Override
	public void addPic(String[] imgBase64, Integer houseId) {
		createUserFolder(houseId);
		for (int i = 0; i < imgBase64.length; i++) {
			String rootPath = Val.REAL_PATH;
			String fileName = Tool.createUUID() + ".png";
			//   /upload/albumeInfo/1000/3232323.png
			String relativePath = "/upload/housePic/" + houseId + "/" + fileName;
			String fullPath = rootPath + relativePath;
			System.out.println(fullPath);
			try {
				Tool.writeImgBase64ToFile(imgBase64[i], fullPath);
			} catch (Exception e) {
				e.printStackTrace();
			}

			House h = new House();
			h.setHouseId(houseId);
			HousePicture hp = new HousePicture();
			hp.setUrl(relativePath);
			hp.setHouse(h);
			housePicDAO.addPic(hp);

		}
	}

	private void createUserFolder(Integer houseId){
		String fullPath = Val.REAL_PATH + "/upload/housePic/" + houseId;
		System.out.println(fullPath);
		File file = new File(fullPath);
		if(!file.exists()){
			file.mkdirs();
		}
	}

}
