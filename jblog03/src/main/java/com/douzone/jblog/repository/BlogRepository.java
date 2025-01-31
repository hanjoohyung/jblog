package com.douzone.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Repository
public class BlogRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public boolean update(BlogVo vo) {
		int count = sqlSession.update("blog.update", vo);
		return count == 1;
	}

	public BlogVo find(BlogVo vo) {
		return sqlSession.selectOne("blog.find", vo);
	}

	public boolean add(PostVo vo) {
		int count = sqlSession.insert("post.insert", vo);
		return count == 1;
	}

	public boolean insert(BlogVo vo) {
		int count = sqlSession.insert("blog.insert", vo);
		return count == 1;
	}

	public boolean addcg(CategoryVo vo) {
		int count = sqlSession.insert("category.insert", vo);
		return count == 1;
	}

	public List<CategoryVo> findCategory(CategoryVo cgvo) {
		return sqlSession.selectList("category.find", cgvo);
	}

	public List<PostVo> findPost(PostVo postvo) {
		return sqlSession.selectList("post.find", postvo);
	}

	public boolean delete(Long no) {
		int count = sqlSession.delete("category.delete", no);
		return count == 1;
	}

	public boolean postdelete(Long no) {
		int count = sqlSession.delete("post.delete", no);
		return count == 1;
	}

	public List<PostVo> findall(PostVo postvo) {
		return sqlSession.selectList("post.findall", postvo);
	}



}
