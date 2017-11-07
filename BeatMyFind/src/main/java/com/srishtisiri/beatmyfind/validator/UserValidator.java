package com.srishtisiri.beatmyfind.validator;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import com.srishtisiri.beatmyfind.model.User;

@Component
public class UserValidator {
	
	public void validateLoginScreen(User user,  ValidationContext context){
		MessageContext messages = context.getMessageContext();
		if (user.isNewUser() && !user.getEmailAddress().contains("@")) {
			System.out.println("Inside validator"); 
			messages.addMessage(new MessageBuilder().error().source("emailAddress").
			 defaultText("Enter a valid email address").build());
		} 

	}

}
