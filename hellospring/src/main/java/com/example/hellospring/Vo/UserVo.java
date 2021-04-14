package com.example.hellospring.Vo;

public class UserVo {
	// 필드
	private Long age;
	private String name;
	private String email;
	private String password;
	private String gender;
	
	// 생성자 -> EJB 규약상 반드시 기본 생성자 필요
	
	// getters and setters
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	// 출력 포맷
	@Override
	public String toString() {
		return "UserVo [age=" + age + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + "]";
	}	
}
