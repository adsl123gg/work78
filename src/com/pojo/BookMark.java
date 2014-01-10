package com.pojo;

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
@Table(name="bookmark")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class BookMark {

	private String id;
	private String content;
	private Set<BookMarkContact> bookMarkContacts;
	private Set<BookMarkCompany> bookMarkCompanies;
	
	@Id
	@GenericGenerator(name="pk",strategy="uuid")
	@GeneratedValue(generator="pk")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@OneToMany(mappedBy="bookMark",fetch=FetchType.LAZY)
	public Set<BookMarkContact> getBookMarkContacts() {
		return bookMarkContacts;
	}
	public void setBookMarkContacts(Set<BookMarkContact> bookMarkContacts) {
		this.bookMarkContacts = bookMarkContacts;
	}
	@OneToMany(mappedBy="bookMark",fetch=FetchType.LAZY)
	public Set<BookMarkCompany> getBookMarkCompanies() {
		return bookMarkCompanies;
	}
	public void setBookMarkCompanies(Set<BookMarkCompany> bookMarkCompanies) {
		this.bookMarkCompanies = bookMarkCompanies;
	}
	
	
}
