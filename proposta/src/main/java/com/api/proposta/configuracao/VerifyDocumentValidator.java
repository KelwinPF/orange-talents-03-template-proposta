package com.api.proposta.configuracao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VerifyDocumentValidator implements ConstraintValidator<VerifyDocument,String>{
	
	@Override
    public void initialize(VerifyDocument verify) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context){
		if(value.matches("([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})")||
		   value.matches("([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})")){
			return true;
		}
		return false;
	}
}
