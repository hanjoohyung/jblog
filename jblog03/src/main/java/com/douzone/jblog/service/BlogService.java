package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public boolean update(BlogVo vo) {
		return blogRepository.update(vo);
		
	}

	public BlogVo getBlog(BlogVo vo) {
		return blogRepository.find(vo);
	}

	public boolean addPost(PostVo vo) {
		return blogRepository.add(vo);
		
	}

	public boolean addblog(BlogVo vo) {
		return blogRepository.insert(vo);
	}

	public boolean addCategory(CategoryVo vo) {
		return blogRepository.addcg(vo);
	}

	public List<CategoryVo> findCategory(CategoryVo cgvo) {
		return blogRepository.findCategory(cgvo);
	}

}
