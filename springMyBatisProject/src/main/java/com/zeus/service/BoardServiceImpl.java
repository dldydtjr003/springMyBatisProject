package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Board;
import com.zeus.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	@Transactional
	public int create(Board b) throws Exception {
		return boardMapper.create(b);
	}

	@Override
	@Transactional(readOnly = true)
	public Board read(Board b) throws Exception {
		return boardMapper.read(b);
	}

	@Override
	@Transactional
	public int update(Board b) throws Exception {
		return boardMapper.update(b);
	}

	@Override
	@Transactional
	public int delete(Board board) throws Exception {
			return boardMapper.delete(board);
	}

	@Override
	@Transactional
	public List<Board> list() throws Exception {
		return boardMapper.list();
		}

	@Override
	@Transactional(readOnly = true)
	public List<Board> search(Board board) throws Exception {
		return boardMapper.search(board);
	}

}
