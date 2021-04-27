package com.api.proposta.configuracao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.tomcat.util.codec.binary.Base64;

public class IsBase64Validator implements ConstraintValidator<IsBase64,String>{
	
	@Override
    public void initialize(IsBase64 base) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context){
		if(Base64.isBase64(value)){
			return true;
		}
		return false;
	}
}
