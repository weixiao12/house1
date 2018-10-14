package com.cool.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Auther: cjc 2018/8/24 0024
 */
@Entity
@Data
public class Street {
	@Id
	private Integer streetId;
	private String streetName;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="districtId")
	private District district = new District();


}
