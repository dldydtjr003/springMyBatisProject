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
	public void create(Board b) throws Exception {
		boardMapper.create(b);
	}

	@Override
	@Transactional(readOnly = true)
	public Board read(Board b) throws Exception {
		return boardMapper.read(b.getNo());
	}

	@Override
	@Transactional
	public void update(Board b) throws Exception {
		boardMapper.update(b);
	}

	@Override
	@Transactional
	public void delete(Board board) throws Exception {
			boardMapper.delete(board.getNo());
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
