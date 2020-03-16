package com.tyss.eletter.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="letter_info_bean")
public class LetterInfoBean implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sequence_number")
	private int  sequenceNumber;
	
	@NotEmpty(message = "please enter value")
	@Column(name = "generator_emp_id",length = 6)
	@Size(max = 6)
	private String generatorEmpId;
	
	@Column(name = "generated_date")
	private LocalDateTime  generatedDate;
	
	@NotEmpty(message = "please enter value")
	@Pattern(regexp = "^[a-zA-Z ]*$",message = "name should contaan character only")
	@Size(min = 4 , max = 30)
	@Column(name = "type_of_letter")
	private String typeOfLetter;
	
	@ElementCollection
	@CollectionTable(name = "recived_emails")
	@Column(name = "to_email")
	private List<String> toEmail;
	
	@Column(name = "mail_sent_time")
	private LocalDateTime  mailSentTime;

	@Column(name = "is_active")
	private boolean isActive;

}
