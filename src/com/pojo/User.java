package com.pojo;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User {

	private String id;
	private String name;
	private String password;
	private String email;
	private String avatar;
	private Set<Message> messageSet;
	private Set<Task> tasks;
	private Set<Chance> chances;
	private Set<Contact> contacts;
	private Set<Company> companies;
	private Set<ChanceComment> chanceComments;
	private Set<ChanceEvent> chanceEvents;
	private Set<ChanceExtra> chanceExtras;
	private Set<CompanyEvent> companyEvents;
	private Set<ContactEvent> contactEvents;
	private Set<ContactComment> contactComments;
	private List<CompanyExtra> companyExtras;
	private List<ContactExtra> contactExtras;
	private List<TaskExtra> taskExtras;
	
	@Id
	@GenericGenerator(name="pk",strategy="uuid")
	@GeneratedValue(generator="pk")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<Message> getMessageSet() {
		return messageSet;
	}
	public void setMessageSet(Set<Message> messageSet) {
		this.messageSet = messageSet;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<Chance> getChances() {
		return chances;
	}
	public void setChances(Set<Chance> chances) {
		this.chances = chances;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<ChanceComment> getChanceComments() {
		return chanceComments;
	}
	public void setChanceComments(Set<ChanceComment> chanceComments) {
		this.chanceComments = chanceComments;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<ChanceEvent> getChanceEvents() {
		return chanceEvents;
	}
	public void setChanceEvents(Set<ChanceEvent> chanceEvents) {
		this.chanceEvents = chanceEvents;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<ChanceExtra> getChanceExtras() {
		return chanceExtras;
	}
	public void setChanceExtras(Set<ChanceExtra> chanceExtras) {
		this.chanceExtras = chanceExtras;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<CompanyEvent> getCompanyEvents() {
		return companyEvents;
	}
	public void setCompanyEvents(Set<CompanyEvent> companyEvents) {
		this.companyEvents = companyEvents;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<ContactEvent> getContactEvents() {
		return contactEvents;
	}
	public void setContactEvents(Set<ContactEvent> contactEvents) {
		this.contactEvents = contactEvents;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	public Set<ContactComment> getContactComments() {
		return contactComments;
	}
	public void setContactComments(Set<ContactComment> contactComments) {
		this.contactComments = contactComments;
	}
	@OneToMany(mappedBy="user")
	public List<CompanyExtra> getCompanyExtras() {
		return companyExtras;
	}
	public void setCompanyExtras(List<CompanyExtra> companyExtras) {
		this.companyExtras = companyExtras;
	}
	@OneToMany(mappedBy="user")
	public List<ContactExtra> getContactExtras() {
		return contactExtras;
	}
	public void setContactExtras(List<ContactExtra> contactExtras) {
		this.contactExtras = contactExtras;
	}
	@OneToMany(mappedBy="user")
	public List<TaskExtra> getTaskExtras() {
		return taskExtras;
	}
	public void setTaskExtras(List<TaskExtra> taskExtras) {
		this.taskExtras = taskExtras;
	}
	
}
