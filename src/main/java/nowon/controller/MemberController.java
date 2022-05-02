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
import nowon.domain.dto.MemberInsertDTO;

@WebServlet(urlPatterns = { "/member/join", "/member/insert", "/member/login" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SqlSessionFactory sqlSessionFactory;//리스너에 있는 서블릿 컨테스트에 저장된 상태
	
	@Override
	public void init() throws ServletException {
		sqlSessionFactory = (SqlSessionFactory) getServletContext().getAttribute("sqlSessionFactory");//다형성!
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		///member/join에 대한 처리
		//주소 가져오는걸 간단히 처리하기 위해 하는 과정
		StringBuffer url = request.getRequestURL();
		System.out.println(url);//url정보
		String uri = request.getRequestURI();//url->full주소 vs uri->
		System.out.println(uri);//uri정보
		String[] strs=uri.split("/");
		String key = strs[strs.length-1];//uri의 마지막 문자열 값
		System.out.println(key);
		
		String path = null;//실제 보여줄 페이지 jsp정보
		if (key.equals("join")) {
			
			// list 페이지이동
			path="/WEB-INF/member/join.jsp";//배포가 여기서 부터 되기 때문에 주소 수정 필요. 아직도 / 넣고 안 넣고 의미 모르겠음.
		}else if(key.equals("insert")) {
			request.setCharacterEncoding("utf-8");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			MemberInsertDTO dto = new MemberInsertDTO(email, name, pass);

			SqlSession sqlSession = sqlSessionFactory.openSession(true);// true=auto commit

			// 쿼리실행
			sqlSession.insert("membermapper.join", dto);// mapper호출,데이터 넘겨주는 공간
			sqlSession.close();
			
			String msg=name + "님의 회원가입이 완료되었습니다";
			request.setAttribute("msg", msg);
			
			//로그인 페이지로 이동
			path="/WEB-INF/member/login.jsp";// "/"넣고 안 넣고 의미 모르겠음.
		}else if(key.equals("login")) {
			path="/WEB-INF/member/login.jsp";
		}
		//페이지 이동
		if(path!=null) {
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
