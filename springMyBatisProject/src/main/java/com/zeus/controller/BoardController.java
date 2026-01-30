package com.zeus.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.Board;
import com.zeus.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.zeus.mapper")
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/insertForm")
	public String boardInsertForm(Model model) {
		return "board/insertForm";
	}

	@PostMapping("/insert")
	public String boardRegister(Board board, Model model) {
		try {
			int count = boardService.create(board);
			if (count > 0) {
				model.addAttribute("message", "등록이 완료되었습니다.");
				return "board/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "등록이 실패했습니다.");
		return "board/failed";
	}

	@GetMapping("/boardList")
	public String boardList(Board board, Model model) {
		try {
			List<Board> boardList = boardService.list();
			model.addAttribute("boardList", boardList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/boardList";
	}

	@GetMapping("/detail")
	public String boardDetail(Model model, Board b) {
		try {
			Board board = boardService.read(b);
			if (board != null) {
				model.addAttribute("board", board);
				model.addAttribute("message", "상세정보 조회 성공했습니다.");
				return "board/detail";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "상세정보 조회 실패했습니다.");
		return "board/failed";
	}

	@GetMapping("/delete")
	public String boardDelete(Model model, Board board) {
		try {
			int count = boardService.delete(board);
			if (count > 0) {
				model.addAttribute("message", " 삭제 성공했습니다.");
				return "board/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", " 삭제 실패했습니다.");
		return "board/failed";
	}

	@GetMapping("/updateForm")
	public String boardUpdateForm(Model model, Board b) {
		Board board;
		try {
			board = boardService.read(b);
			if (board != null) {
				model.addAttribute("board", board);
				return "board/updateForm";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "고객님의 정보가 없습니다.");
		return "board/failed";
	}

	@PostMapping("/update")
	public String boardUpdate(Model model, Board board) {
		try {
			int count = boardService.update(board);
			if (count > 0) {
				model.addAttribute("message", "수정이 완료되었습니다.");
				return "board/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "수정이 실패했습니다.");
		return "board/failed";
	}

	@GetMapping("/search")
	public String boardSearch(Board board, Model model) {
		try {
			List<Board> boardList = boardService.search(board);
			model.addAttribute("boardList", boardList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/boardList";
	}
}
