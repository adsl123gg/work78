package com.pojo;

import java.util.List;
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
@Table(name="contact")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Contact {

	private String id;
	private String name;
	private String post;
	private String companyname;
	private String phone;
	private String email;
	private String im;
	private String website;
	private String address;
	private String weibo;
	private String bg_info;
	private String createtime;
	private String avatar;
	private User user;
	private Company company;
	/*private String user_id;
	private String company_id;*/
	private Set<BookMarkContact> bookMarkContacts;
	private Set<ContactEvent> contactEvents;
	private Set<Chance> chances;
	private List<ContactExtra> contactExtras;
	
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
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIm() {
		return im;
	}
	public void setIm(String im) {
		this.im = im;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	public String getBg_info() {
		return bg_info;
	}
	public void setBg_info(String bg_info) {
		this.bg_info = bg_info;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	@JoinColumn(name="company_id")
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@OneToMany(mappedBy="contact",fetch=FetchType.LAZY)
	public Set<BookMarkContact> getBookMarkContacts() {
		return bookMarkContacts;
	}
	public void setBookMarkContacts(Set<BookMarkContact> bookMarkContacts) {
		this.bookMarkContacts = bookMarkContacts;
	}
	@OneToMany(mappedBy="contact",fetch=FetchType.LAZY)
	public Set<ContactEvent> getContactEvents() {
		return contactEvents;
	}
	public void setContactEvents(Set<ContactEvent> contactEvents) {
		this.contactEvents = contactEvents;
	}
	@OneToMany(mappedBy="contact",fetch=FetchType.LAZY)
	public Set<Chance> getChances() {
		return chances;
	}
	public void setChances(Set<Chance> chances) {
		this.chances = chances;
	}
	@OneToMany(mappedBy="contact")
	public List<ContactExtra> getContactExtras() {
		return contactExtras;
	}
	public void setContactExtras(List<ContactExtra> contactExtras) {
		this.contactExtras = contactExtras;
	}
	
	
	
}
