package com.cool.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Auther: cjc 2018/8/24 0024
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class House {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PKGen")
	@SequenceGenerator(name="PKGen", sequenceName="seq_house")
	private Integer houseId;
	private String title;
	private String description;
	private Double price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pubdate;
	private Date adddate;
	private Double floorage;
	private String contact;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private HouseUser houseUser;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="htypeId")
	private HouseType houseType;
	@ManyToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="streetId")
	private Street street;

	@OneToMany(mappedBy="house", cascade={ CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<HousePicture> housePictures = new HashSet<HousePicture>();

	private Integer isDelete;

	//价格区间
	@Transient
	private  String priceScore;
	//面积区间
	@Transient
	private String floorageScore;



}
