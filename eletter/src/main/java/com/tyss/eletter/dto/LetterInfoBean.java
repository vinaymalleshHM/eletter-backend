package com.tyss.eletter.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="letter_info_bean")
public class LetterInfoBean implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sequence_number")
	private int  sequenceNumber;
	
	@Column(name = "generator_emp_id")
	private String generatorEmpId;
	
	@Column(name = "generated_date")
	private Date  generatedDate;
	
	@Column(name = "type_of_letter")
	private String typeOfLetter;
	
	@ElementCollection
	@CollectionTable(name="recieved_emails")
	@Column(name = "to_email")
	private List<String> toEmail;
	
	@Column(name = "mail_sent_time")
	private Date  mailSentTime;

}
