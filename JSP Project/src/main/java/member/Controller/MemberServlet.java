package member.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Domain.MemberVO;
import member.Persistence.MemberDAO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmdReq = request.getParameter("cmd");
		String message = "";
		
		if(cmdReq.equals("join")) 
			response.sendRedirect("register.html");
		else if(cmdReq.equals("game")) {

		}
		else if(cmdReq.equals("update")) {
			MemberDAO dao = new MemberDAO();
			MemberVO member = dao.read(request.getParameter("id"));
			
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("update.jsp");
			view.forward(request, response);
		}else if(cmdReq.equals("delete")) {
			MemberDAO dao = new MemberDAO();
			MemberVO member = dao.read(request.getParameter("id"));
			
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("delete.jsp");
			view.forward(request, response);
		} else if(cmdReq.equals("list")) {
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> memberList = dao.getMemberList();
			request.setAttribute("memberList", memberList);
			
			RequestDispatcher view = request.getRequestDispatcher("rating.jsp");
			view.forward(request, response);
		} 
	}	// doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmdReq = request.getParameter("cmd");
		String message = "";

		if(cmdReq.equals("join")) {
			MemberVO memberVO = new MemberVO();
			
			memberVO.setId(request.getParameter("id"));
			memberVO.setPasswd(request.getParameter("passwd"));
			memberVO.setUsername(request.getParameter("username"));
			memberVO.setNation(request.getParameter("nation"));
			memberVO.setOld(request.getParameter("old"));
			memberVO.setMobile(request.getParameter("mobile"));
			memberVO.setEmail(request.getParameter("email"));
			
			MemberDAO dao = new MemberDAO();
			
			
			if(dao.add(memberVO)) message = "가입 축하합니다";
			else message = "가입 실패입니다";
			
			request.setAttribute("greetings", message);
			request.setAttribute("student", memberVO);
			
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			view.forward(request, response);
		} 
		else if(cmdReq.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("passwd");
			
			MemberDAO dao = new MemberDAO();
			MemberVO login = dao.read(id);
			
			if(!id.equals(login.getId())) {
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('존재하지 않는 아이디입니다'); location.href='"+"home.jsp"+"';</script>");
				writer.close();
		
				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);
			} 
			
			else if(id.equals(login.getId()) && !pw.equals(login.getPasswd())) {
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('잘못된 비밀번호입니다'); location.href='"+"home.jsp"+"';</script>");
				writer.close();
				
				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);
			} 
			
			else if(id.equals(login.getId()) && pw.equals(login.getPasswd())) {
				request.setAttribute("member", login);

				RequestDispatcher view = request.getRequestDispatcher("main.jsp");
				view.forward(request, response);
			}
		} 
		else if(cmdReq.equals("game")) {
			String id = request.getParameter("id");
			
			request.setAttribute("id", id);
			RequestDispatcher view = request.getRequestDispatcher("gameFolder/game.jsp");
			view.forward(request, response);
		}
		
		// UPDATE
		else if(cmdReq.equals("update")) {
			MemberVO memberVO = new MemberVO();
			
			memberVO.setId(request.getParameter("id"));
			memberVO.setPasswd(request.getParameter("passwd"));
			memberVO.setUsername(request.getParameter("username"));
			memberVO.setNation(request.getParameter("nation"));
			memberVO.setOld(request.getParameter("olds"));
			memberVO.setMobile(request.getParameter("mobile"));
			memberVO.setEmail(request.getParameter("email"));
			memberVO.setScore(request.getParameter("score"));			
			MemberDAO dao = new MemberDAO();
			
			if(dao.update(memberVO)) message = "수정이 완료되었습니다.";
			else message = "수정 실패입니다";
			
			request.setAttribute("greetings", message);
			request.setAttribute("member", memberVO);
			
			RequestDispatcher view = request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
		} 
		// DELETE
		else if(cmdReq.equals("delete")) {
			String id = request.getParameter("id");
			MemberDAO dao = new MemberDAO();
			MemberVO del = dao.read(id);
			
			if(dao.delete(del)) {
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('회원 탈퇴되었습니다'); location.href='"+"home.jsp"+"';</script>");
				writer.close();
				
				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);
			}
			else {
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('알 수 없는 오류입니다'); location.href='"+"home.jsp"+"';</script>");
				writer.close();
				
				RequestDispatcher view = request.getRequestDispatcher("main.jsp");
				view.forward(request, response);
			}
		}
		// RATING
		else if(cmdReq.equals("rate")) {
			String id = request.getParameter("id");
			String score = request.getParameter("save");
			MemberDAO dao = new MemberDAO();
			MemberVO save = dao.read(id);
			
			save.setScore(score);
			
			if(dao.saveScore(save)) message = "수정이 완료되었습니다.";
			else message = "수정 실패입니다";
			
			ArrayList<MemberVO> memberList = dao.getMemberList();
			request.setAttribute("memberList", memberList);
			
			RequestDispatcher view = request.getRequestDispatcher("rating.jsp");
			view.forward(request, response);
			
			/*String id = request.getParameter("id");
			String score = request.getParameter("save");
			MemberDAO dao = new MemberDAO();
			MemberVO save = dao.read(id);
			
			save.setNation(score);
			save.setScore(score);
			
			if(dao.saveScore(save)) message = "수정이 완료되었습니다.";
			else message = "수정 실패입니다";
			
			ArrayList<MemberVO> memberList = dao.getMemberList();
			request.setAttribute("memberList", memberList);
			
			RequestDispatcher view = request.getRequestDispatcher("rating.jsp");
			view.forward(request, response);*/
		}

	}	// doPost

}
