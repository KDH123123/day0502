package nowon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import nowon.domain.dto.BoardDTO;
import nowon.domain.dto.BoardInsertDTO;
import nowon.domain.dto.BoardUpdateDTO;

@WebServlet(urlPatterns = { "/board/list", "/board/write", "/board/insert", "/board/detail", "/board/delete","/board/update" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SqlSessionFactory sqlSessionFactory;

	@Override // 입력 받을 때만 실행
	public void init() throws ServletException {
		sqlSessionFactory = (SqlSessionFactory) getServletContext().getAttribute("sqlSessionFactory");// object타입으로 저장했기
																										// 때문에 캐스팅 해야됨
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/board로 요청시 실행");

		String uri = request.getRequestURI();
		String[] strs = uri.split("/");
		String key = strs[strs.length - 1];// uri에서 맨 뒤에 글자 추출
		System.out.println(key);
		String path = null;
		if (key.equals("list")) {

			SqlSession sqlSession = sqlSessionFactory.openSession();// Session만들어주는 공장

			List<BoardDTO> list = sqlSession.selectList("boardMapper.all");// xml의 id에 맞추기, list에 board dto가 저장되어있음
			sqlSession.close();

			request.setAttribute("list", list);// list로 저장해서 포장. "list"로 불러오면 됨
			
			// list 페이지이동
			path = "/WEB-INF/board/list.jsp";

		} else if (key.equals("write")) {
			// write 페이지이동
			path = "/WEB-INF/board/write.jsp";

		} else if (key.equals("insert")) {
			request.setCharacterEncoding("utf-8");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			BoardInsertDTO dto = new BoardInsertDTO(subject, content, writer);

			SqlSession sqlSession = sqlSessionFactory.openSession(true);// true=auto commit

			// 쿼리실행
			int n = sqlSession.insert("boardMapper.save", dto);// mapper호출,데이터 넘겨주는 공간
			sqlSession.close();
			System.out.println(n + "개 저장완료!");

			// 저장된 내용 list페이지로 이동 : 응답처리
			response.sendRedirect("list");// 그냥 path로 긁어오면 데이터가 없으니까 서버에서 다시 요청
			
		} else if (key.equals("detail")) {
			String _no = request.getParameter("no");
			//DB의 no는 숫자
			int no=Integer.parseInt(_no);
			//DB접속 후 조회
			SqlSession sqlSession = sqlSessionFactory.openSession();
			BoardDTO result = sqlSession.selectOne("boardMapper.load", no);//"매퍼이름.id", no
			sqlSession.close();
			request.setAttribute("detail", result);
			System.out.println(result);
			path = "/WEB-INF/board/detail.jsp";
			
		}else if(key.equals("delete")) {
			//1.파리미터 받기
			String _no = request.getParameter("no");
			int no=Integer.parseInt(_no);
			//2.DB접속
			SqlSession sqlSession = sqlSessionFactory.openSession(true);//데이터가 변경되니까 true(commit)필수
			//3.삭제작업
			//BoardDTO result = sqlSession.selectOne("boardMapper.delete", no);//"매퍼이름.id", no
			//request.setAttribute("delete", delete);
			sqlSession.delete("boardMapper.delete",no);
			sqlSession.close();
			//4.list로 이동
			response.sendRedirect("list");
			
		}else if (key.equals("update")) {
			String _no = request.getParameter("no");
			int no=Integer.parseInt(_no);//no파라미터
			String sb = request.getParameter("subject");//subject파라미터
			String con = request.getParameter("content");//content파라미터
			
			BoardUpdateDTO dto=new BoardUpdateDTO(no, sb, con);
			
			SqlSession sqlSession = sqlSessionFactory.openSession(true);//commit
			sqlSession.update("boardMapper.update", dto);//
			
			sqlSession.close();
			response.sendRedirect("list");
		}
		// end if

		// 페이지이동 : 응답처리
		if (path != null) {
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
