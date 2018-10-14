package com.cool.util;

import java.util.List;

/**
 * @Auther: cjc 2018/8/26 0026
 */
/*

分页：
	1、减少等待时长
	2、方便用户查看
	3、查询片段数据
		a、limit n,m  (n : 起始数据的下标，m : 读取的最大行数)
		b、m：最大行数==》pageSize
		c、n: 起始数据的下标 firstRecord = (pageNo - 1) * pageSize = 3
		d、不同数据分页的手法不一样，mysql一般用limit关键字
	4、显示的相关信息：
		a、一共有多少页 (pageCount = 3)
		b、当前第几页
		c、总共多少条记录 (rowCount = 7)
		d、每页显示的记录数 （pageSize = 3）
	5、计算总页数的算法：
		a、要先知道每页多少行数据 3 pageSize
		b、要知道总记录数  7 rowCount
		c、总页数算法1 ：
			if(rowCount % pageSize == 0){
				pageCount = rowCount / pageSize;
			}else{
				pageCount = rowCount / pageSize + 1;
			}
		d、总页数算法2：
			pageCount = (rowCount - 1) / pageSize + 1;
			pageCount = (8 - 1) / 3 + 1 = 7 / 3 + 1 = 3
	6、总共多少条记录：这个呢，要使用另一个查询语句来查询
	7、因为分页对应的参数比较多，所以一般会用一个分页对象，分页实体来存储
	8、一定要加排序条件 order by

 */

public class PageResult<T> {
	private Integer pageNo = 1;	//表示当前第几页
	private Integer pageCount;	//表示总页数
	private Integer pageSize = 5;	//每页显示的行数
	private Integer rowCount;	//总记录数
	private List<T> data;	//装载数据

	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	//根据总记录数和每页显示的行数，计算出总页数
	public Integer getPageCount() {
		return (rowCount - 1) / pageSize + 1;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}

	//获取当前页第一条记录的下标 firstResult
	public Integer getFirstResult(){
		return (pageNo-1) * pageSize;
	}
}