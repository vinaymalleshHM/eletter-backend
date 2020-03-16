package com.tyss.eletter.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "test_time")
public class TimeTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	 private Integer id;
	 @Convert(converter = LocalDateTimeConverter.class)
	 @Column(name = "mail_sent_time")
	 private LocalDateTime mailSentTime;
	 @Convert(converter = LocalDateTimeConverter.class)
	 @Column(name = "generated_date")
	 private LocalDateTime generatedDate;
	}
