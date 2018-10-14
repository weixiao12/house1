package com.cool.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
public class District {
	@Id
	private Integer districtId;
	private String districtName;

	@OneToMany(mappedBy="district", cascade={ CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<Street> streets = new HashSet<Street>();

}
