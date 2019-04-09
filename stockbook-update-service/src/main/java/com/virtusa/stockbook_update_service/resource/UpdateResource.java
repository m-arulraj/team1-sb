package com.virtusa.stockbook_update_service.resource;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.stockbook_update_service.domain.User;
import com.virtusa.stockbook_update_service.service.UpdateService;

@RestController
public class UpdateResource {

	@Autowired
	UpdateService updateService;

	final static Logger logger = Logger.getLogger(UpdateResource.class);
	
	@RequestMapping(value = "/api/user/updateuserpassword", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUserPassword( @RequestBody User user) throws URISyntaxException {
		logger.info("entered UpdateResource");
		
				URI uri=new URI("/api/getUser/" + updateService.updateUserPassword(user).getId());
				HttpHeaders headers=new HttpHeaders();
				headers.setLocation(uri);
				return new ResponseEntity<String>(headers,HttpStatus.OK);
	}

	@RequestMapping(value = "/api/user/updateusername", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUserName( @RequestBody User user) throws URISyntaxException {
		logger.info("entered UpdateResource");
		
				URI uri=new URI("/api/getUer/" + updateService.updateUserName(user).getId());
				HttpHeaders headers=new HttpHeaders();
				headers.setLocation(uri);
				return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/user/updateuserprofile", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUserProfile( @RequestBody User user) throws URISyntaxException {
		logger.info("entered UpdateResource");
		
				URI uri=new URI("/api/getUer/" + updateService.updateUserProfile(user).getId());
				HttpHeaders headers=new HttpHeaders();
				headers.setLocation(uri);
				return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
}
