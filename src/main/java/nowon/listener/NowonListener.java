package nowon.listener;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebListener
public class NowonListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
	}

	// Therefore the best scope of SqlSessionFactory is application scope.
	public void contextInitialized(ServletContextEvent sce) {
		String resource = "nowon/mybatis/mybatis-config.xml";// xml에 있는 정보를 읽어서
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);// 이곳에 저장
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			// application scope
			ServletContext sc = sce.getServletContext();
			sc.setAttribute("sqlSessionFactory", sqlSessionFactory);
			System.out.println("sqlSessionFactory -> ServletContext 저장");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
