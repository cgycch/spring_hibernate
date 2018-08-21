package com.cch.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //　　如果我们当前这个bean要设置成实体对象，就需要加上Entity这个注解
@Table(name="t_ano_entity") //　设置数据库的表名
public class AnoEntity {
	private String id;
	private String name;
	private Date  startDate;
	private long endTime;
	
	@Id
	//定义为数据库的主键ID　　(建议不要在属性上引入注解，
	//因为属性是private的，如果引入注解会破坏其封装特性，
	//所以建议在getter方法上加入注解)
	@GeneratedValue//ID的生成策略为自动生成
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="cur_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Column中的name属性对应了数据库的该字段名字，
	//里面还有其他属性，例如length，nullable等等
	@Column(name="start_date")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name="end_time")
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
	

}
