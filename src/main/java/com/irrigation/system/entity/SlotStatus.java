package com.irrigation.system.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "slot_status")
public class SlotStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 350714937849179859L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "slot_id", nullable = false)
	private Slots slot;

	private String status;

	private LocalDate date;

	private LocalTime time;

}
