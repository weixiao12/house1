package com.cool.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Auther: cjc 2018/8/24 0024
 */
@Entity
@Table(name = "HOUSE_USER")
@Data
public class HouseUser implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PKGen")
	@SequenceGenerator(name="PKGen", sequenceName="seq_user")
	private Integer userId;
	private String userName;
	private String password;
	private String telephone;
	private String realName;
	private String isAdmin;


}
