package com.hyper.pojo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Services")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services extends BaseEntity implements Serializable{
	
	@Column(name = "servicename", nullable = false, length = 100)
	private String servicename;
	
	@Column(name = "category", nullable = false, length = 300)
	private String category;
	@Column(name = "description", nullable = false, length = 255)
	private String description;
	@Column(name = "isapproved", nullable = false)
	private boolean isApproved;
	@Column(name = "price", nullable = false)
	private Double price;
	@Column(name = "Provider_Id", nullable = false)
	private Long providerid;
	
	

}
