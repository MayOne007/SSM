package com;

import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/** 声明用的是Spring的测试类 **/
@RunWith(SpringJUnit4ClassRunner.class)
/** 声明spring主配置文件位置 **/
@ContextConfiguration(locations={"classpath*:applicationContext*.xml"})
/** 事务自动回滚  **/
/*@Rollback*/
public class SpringJunitTest {

	@Autowired
	DruidDataSource dataSource;

	@Test
	public void test() throws SQLException {
		// 1.设定模板二进制文件路径，一定要可以通过该路径找到该文件
		String reportPath = "D://workspace/ssm/resources/jasperreports/test.jasper";

		// 2.设定报表的外部参数，map集合，这里要注意map的key值一定要与模板里Parameters的名字一致
		HashMap<String, Object> map = new HashMap<>();
		/*map.put("yuwen", "10");
		map.put("shuxue", "100");
		map.put("yingyu", "40");*/
		try {
			// 3.通过JasperFillManager工具进行填充报表，填充成功后会生成一个JasperPring文件，该文件用于输出
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, null,dataSource.getConnection());
			// 4.设定目标文件输出的路径
			String desFilePath = "D://workspace/ssm/src/main/java/com/test.pdf";
			// 5.通过JasperExportManager管理工具进行报表输出文档，此处设定为输出Html文件.
			//JasperExportManager.exportReportToHtmlFile(jasperPrint, desFilePath);
			JasperExportManager.exportReportToPdfFile(jasperPrint, desFilePath);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
}
