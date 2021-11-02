package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.PostVo;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public boolean update(BlogVo vo) {
		return blogRepository.update(vo);
		
	}

	public BlogVo getBlog() {
		return blogRepository.find();
	}

	public boolean addPost(PostVo vo) {
		return blogRepository.add(vo);
		
	}

}
