package com.Onesoft.springdemo.Contoller;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "auth")
@AllArgsConstructor
@NoArgsConstructor
public class BasicEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	@OneToOne(targetEntity = BasicDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_fkey", referencedColumnName = "id")
	private List<BasicDetails> b;
}
