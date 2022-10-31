package com.mcb.assessment.controller;

import com.mcb.assessment.model.Group;
import com.mcb.assessment.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/groups")
public class GroupController {
	@Autowired
	GroupService groupService;

	@PostMapping("/")
	public ResponseEntity<Group> insertGroup (@RequestBody Group group) {

		Group groupObj = groupService.addGroup (group);
		return ResponseEntity.status (HttpStatus.CREATED).body (groupObj);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Group> getGroupById (@PathVariable long id) {
		Group group = groupService.getGroupById (id);
		return ResponseEntity.status (HttpStatus.OK).body (group);

	}


}
