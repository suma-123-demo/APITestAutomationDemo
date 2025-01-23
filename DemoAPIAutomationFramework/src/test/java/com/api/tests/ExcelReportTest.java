package com.api.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.ReportService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class ExcelReportTest {

	@Test
	public void excelReport() throws IOException
	{
		//byte[] file = new File("C:\\Users\\DELL\\git\\repository\\DemoAPIAutomationFramework\\src\\test\\resources\\testfiles");
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("uday1234","uday1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token=loginResponse.getToken();
		
		//FileOutputStream os = new FileOutputStream(new File("./testfiles"));
		ReportService reportService = new ReportService();
		byte[] downloadfile=reportService.excelreport(token, "accountNumber", "5224855672").asByteArray();
		//System.out.println(downloadfile);
		FileOutputStream os = new FileOutputStream(new File("C:\\\\Users\\\\DELL\\\\git\\\\repository\\\\DemoAPIAutomationFramework\\\\src\\\\test\\\\resources\\\\testfiles/test.xls"));
		os.write(downloadfile);
		os.close();
		//System.out.println(response);
	}
}
