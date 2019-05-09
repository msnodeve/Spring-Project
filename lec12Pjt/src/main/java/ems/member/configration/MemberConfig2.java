package ems.member.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;

@Configuration
public class MemberConfig2 {
	
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
	
}

