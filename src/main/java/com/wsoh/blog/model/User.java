package com.wsoh.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity // User 클래스가 MySQL에 테이블이 생성이 된다.
public class User {
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // 시퀀스(오라클),auto_increment(mysql)
	
	@Column(nullable = false, length = 30)
	private String username; // 아이디
	
	@Column(nullable = false, length = 100) //123456 => 해쉬(비밀번호 암호화)
	private String password; // 패스워드
	
	@Column(nullable = false, length = 50)
	private String email; // email
	
	@ColumnDefault("'user'")
	private String role; // Enum을 쓰는게 좋다. // admin, user, manager
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
}
