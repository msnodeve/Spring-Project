package ems.member.configration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDao;
import ems.member.service.EMSInformationService;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

@Configuration
public class MemberConfig {
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDao());
	}
	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
		DataBaseConnectionInfo inforDev = new DataBaseConnectionInfo();
		inforDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		inforDev.setUserId("scott");
		inforDev.setUserPw("tiger");
		return inforDev;
	}
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
		DataBaseConnectionInfo inforReal = new DataBaseConnectionInfo();
		inforReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
		inforReal.setUserId("masterid");
		inforReal.setUserPw("masterpw");
		return inforReal;
	}
	
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService info = new EMSInformationService();
		info.setInfo("Education Management System program was developed in 2015.");
		info.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		info.setVer("The version is 1.0");
		info.setsYear(2015);
		info.setsMonth(1);
		info.setsDay(1);
		info.seteYear(2015);
		info.seteMonth(2);
		info.seteDay(28);
		ArrayList<String> developers = new ArrayList<>();
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jasper.");
		developers.add("Dillon.");
		developers.add("Kian.");
		info.setDevelopers(developers);
		Map<String, String> administrators = new HashMap<>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "jasper@springPjt.org");
		info.setAdministrators(administrators);
		Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<>();
		dbInfos.put("dev", dataBaseConnectionInfoDev());
		dbInfos.put("real", dataBaseConnectionInfoReal());
		info.setDbInfos(dbInfos);
		return info;
	}
}

