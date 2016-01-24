import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.glodon.dao.MenuDao;
import com.glodon.model.Menu;
import com.glodon.model.Page;
import com.glodon.model.QueryEntity;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		MenuDao menuDao = (MenuDao)ctx.getBean("menuDao");
		QueryEntity queryEntity = new QueryEntity(new String[]{"id"}, new String[]{"<"}, new Object[]{30});
		List<Menu> all = menuDao.findByPropertiesByPage(queryEntity, new Page(1, 10), null, null);
		//List<Menu> all = menuDao.findByProperties(queryEntity, null, null);
		System.out.println(menuDao.getTotlaCount(queryEntity));
		System.out.println(all.size());
		for (Menu menu : all) {
			System.out.println(menu.getId() + "  " + menu.getDescription());
		}
	}
}
