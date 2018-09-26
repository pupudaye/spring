package org.pl.blockchain.entity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Friend {

	private Integer id;
	@Autowired
	private Person friendDetail;
	private Date makeTime;
	
	
}
