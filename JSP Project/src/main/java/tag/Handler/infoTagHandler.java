package tag.Handler;

import java.io.IOException;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class infoTagHandler extends SimpleTagSupport {
	public void doTag() throws IOException, JspException {
		JspWriter out = getJspContext().getOut();
		out.println("SpaceBar를 눌러서 게임을 시작하세요! <br>");
		out.println("Jump: ↑ key");
	}
}
