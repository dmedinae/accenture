package com.accenture.test.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "contracts")
public class ContractModel extends BaseModel {

	private static final long serialVersionUID = 2830641070020345875L;
	private String type;
	private String employeName;
	private String months;
	private String company;	

}
