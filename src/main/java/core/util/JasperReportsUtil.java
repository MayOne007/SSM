package core.util;

import java.io.File;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Component
public class JasperReportsUtil {
	
	private Connection connection;
	
	public void setDataSource(DruidDataSource dataSource) throws SQLException {
		this.connection = dataSource.getConnection();
	}
	
	/**
	 * 
	 * @param jasperPath jasper文件全名
	 * @param outputStream 
	 */
	public void exportPdf(String jasperPath, OutputStream outputStream){
		jasperPath = this.getClass().getClassLoader().getResource("").getPath()+File.separator+"jasperreports"+File.separator+jasperPath;
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, null,connection);
			jasperPrint.setName("test.pdf");
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
