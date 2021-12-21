package com.btec.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.btec.validator.Phone;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	@Id
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "phoneNumber")
	@Phone(message = "Phone Number is invalid")
	private String phoneNumber;

	@Column(name = "fullName") @NotNull(message = "is required")
	private String fullName;
	
	@Column(name = "dob")
	@DateTimeFormat(pattern="dd/MM/yyyy") @NotNull(message = "is required")
	@Past
	private Date dob;

	@Column(name = "email") @Email(message = "Invalid email! Please enter valid email") @NotNull(message = "is required")
	private String email;
	
	@Column(name = "gender", columnDefinition="char(1)")
	@NotNull
	private String gender;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "avatar")
	private String avatar;

	@Column(name = "status")
	@NotNull
	private Integer status;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<RoleEntity> roles = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "user_class", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "classId"))
	private Set<ClassEntity> classuser = new HashSet<>();
	
	@OneToMany(mappedBy = "user")
	private List<SubasmEntity> subasmuser = new ArrayList<>();
		
	public Set<ClassEntity> getClassuser() {
		return classuser;
	}

	public void setClassuser(Set<ClassEntity> classuser) {
		this.classuser = classuser;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public List<SubasmEntity> getSubasmuser() {
		return subasmuser;
	}

	public void setSubasmuser(List<SubasmEntity> subasmuser) {
		this.subasmuser = subasmuser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	
}
