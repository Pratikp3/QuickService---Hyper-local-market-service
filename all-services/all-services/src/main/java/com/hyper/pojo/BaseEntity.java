package com.hyper.pojo;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
	
	@Column(name = "User_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "Created_On")
	@CreationTimestamp
	private LocalDate CreatedOn;
	
	@UpdateTimestamp
	@Column(name = "Updated_On" )
	private LocalDate UpdatedOn;
	

}
