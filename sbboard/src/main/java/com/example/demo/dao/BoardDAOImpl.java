package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BoardBean;

@Repository
public class BoardDAOImpl implements BoardDao{

	@Autowired
	private SqlSession session;

	
	/* 게시판 저장 */
	public void insertBoard(BoardBean b) throws Exception {
		session.insert("boardns.board_insert", b);
	}

	
	/* 게시물 목록  */
	public List<BoardBean> getBoardList(int page) throws Exception {
		List<BoardBean> list = session.selectList("boardns.board_list", page);

		return list;
	}

	
	/* 게시판 총 갯수  */
	public int getListCount() throws Exception {
		int count = 0;	
		count = ((Integer) session.selectOne("boardns.board_count")).intValue();

		return count;
	}

	
	/* 게시판 글내용보기  */
	public BoardBean getBoardCont(int board_num) throws Exception {
		return (BoardBean) session.selectOne("boardns.board_cont",board_num);
	}

	
	/* 게시판 조회수 증가  */
	public void boardHit(int board_num) throws Exception {
		session.update("boardns.board_hit", board_num);		
	}

	
	/* 게시물 수정  */
	public void boardEdit(BoardBean b) throws Exception {
		session.update("boardns.board_edit", b);		
	}

	
	/* 게시물 삭제  */
	public void boardDelete(int board_num) throws Exception {
		session.delete("boardns.board_del", board_num);				
	}

	
	/* 답변글 레벨 증가  */
	public void refEdit(BoardBean b) throws Exception {
		session.update("boardns.board_Level", b);		
	}

	
	/* 답변글 저장  */
	public void boardReplyOk(BoardBean b) throws Exception {
		session.insert("boardns.board_reply", b);		
	}

}
