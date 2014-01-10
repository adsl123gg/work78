package com.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="chance")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Chance {

	private String id;
	private String name;
	private String info;
	private double money;
	private String status;
	private String createtime;
	private User user;
	private ChanceType chanceType;
	private Set<ChanceEvent> chanceEvents;
	private Set<ChanceExtra> chanceExtras;
	private Contact contact;
	private Company company;

	
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="chance_type")
	public ChanceType getChanceType() {
		return chanceType;
	}
	public void setChanceType(ChanceType chanceType) {
		this.chanceType = chanceType;
	}
	@OneToMany(mappedBy="chance",fetch=FetchType.LAZY)
	public Set<ChanceEvent> getChanceEvents() {
		return chanceEvents;
	}
	public void setChanceEvents(Set<ChanceEvent> chanceEvents) {
		this.chanceEvents = chanceEvents;
	}
	@OneToMany(mappedBy="chance",fetch=FetchType.LAZY)
	public Set<ChanceExtra> getChanceExtras() {
		return chanceExtras;
	}
	public void setChanceExtras(Set<ChanceExtra> chanceExtras) {
		this.chanceExtras = chanceExtras;
	}
	@ManyToOne
	@JoinColumn(name="contact_id")
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@ManyToOne
	@JoinColumn(name="company_id")
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
