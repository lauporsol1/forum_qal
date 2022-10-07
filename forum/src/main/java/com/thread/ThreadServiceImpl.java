package com.thread;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadServiceImpl implements ThreadService{
	
	@Autowired
	private ThreadRepository threadRepository;
	
	public List<Thread> getThread() {
		return (List<Thread>) threadRepository.findAll();
	}

}
