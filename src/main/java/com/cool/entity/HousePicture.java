package com.cool.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Auther: cjc 2018/8/24 0024
 */
@Entity
@Table(name = "HOUSE_PICTURE")
@Getter
@Setter
@RequiredArgsConstructor
public class HousePicture {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PKGen")
	@SequenceGenerator(name="PKGen", sequenceName="seq_pic")
	private Integer pictureId;
	private String title;
	private String url;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="houseId")
	private House house;


}
