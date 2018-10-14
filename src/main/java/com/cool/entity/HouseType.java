package com.cool.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Auther: cjc 2018/8/24 0024
 */
@Entity
@Table(name = "HOUSE_TYPE")
@Data
public class HouseType {
	@Id
	private Integer htypeId;
	private String htypeName;


}
