package com.irrigation.system.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "slots")
public class Slots implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -298667951635668609L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "plot_id", nullable = false)
	private Plot plot;

	private LocalDate date;
	
	private LocalTime startTime;

	private LocalTime endTime;

	@Column(name = "recurring", columnDefinition = "BOOLEAN")
	private boolean recurring;

	@Column(name = "is_active", columnDefinition = "BOOLEAN")
	private boolean active;

	@ManyToOne
	@JoinColumn(name = "sensor_id", nullable = false)
	private Sensor sensor;

}
