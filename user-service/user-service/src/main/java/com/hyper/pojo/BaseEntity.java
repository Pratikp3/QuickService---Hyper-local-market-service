package com.hyper.pojo;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
	
	@Column(name="User_id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long Id;
	
	@Column(name="Created_on")
	@CreationTimestamp
	private LocalDate CreatedOn;
	
	@UpdateTimestamp
	@Column(name="Update_on")
	private LocalDate UpdatedOn;
	
	
	

}
