package com.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ChanceTypeDao;
import com.opensymphony.xwork2.ActionContext;
import com.pojo.BookMarkCompany;
import com.pojo.BookMarkContact;
import com.pojo.Chance;
import com.pojo.ChanceExtra;
import com.pojo.ChanceType;
import com.pojo.Company;
import com.pojo.CompanyComment;
import com.pojo.CompanyEvent;
import com.pojo.CompanyExtra;
import com.pojo.Contact;
import com.pojo.ContactComment;
import com.pojo.ContactEvent;
import com.pojo.ContactExtra;
import com.pojo.User;
import com.service.BookMarkCompanyService;
import com.service.BookMarkContactService;
import com.service.ChanceService;
import com.service.CompanyCommentService;
import com.service.CompanyEventService;
import com.service.CompanyExtraService;
import com.service.CompanyService;
import com.service.ContactCommentService;
import com.service.ContactEventservice;
import com.service.ContactExtraService;
import com.service.ContactService;
import com.service.MessageService;
import com.service.UserService;
import com.util.TextShorten;
import com.util.Time;

@ParentPackage("mypackage")
public class ContactsAction {

	@Autowired
	private ContactService contactService;
	@Autowired
	private ContactEventservice contactEventservice;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private BookMarkContactService bookMarkContactService;
	@Autowired
	private ContactCommentService contactCommentService;
	@Autowired
	private ChanceService chanceService;
	@Autowired
	private ChanceTypeDao chanceTypeDao;
	@Autowired
	private BookMarkCompanyService bookMarkCompanyService;
	@Autowired
	private CompanyCommentService companyCommentService;
	@Autowired
	private CompanyEventService companyEventService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private ContactExtraService contactExtraService;
	@Autowired
	private CompanyExtraService companyExtraService;
	@Autowired
	private UserService userService;

	private User user=(User) ActionContext.getContext().getSession().get("user");
	private List<Contact> contacts;
	private List<Company> companies;
	private String contact_id;
	private Contact contact;
	private List<BookMarkContact> bookMarkContacts;
	private String contactEventInfo;
	private ContactEvent contactEvent;
	private List<ContactEvent> contactEvents;
	private String contacteventid;
	private List<ContactComment> contactComments;
	private String contactCommentId;
	private ContactComment contactComment;
	private List<Chance> contactChances;
	private List<Chance> companyChances;
	private Chance chance;
	private List<ChanceType> chanceTypes;
	private String chanceType;
	private Company company;
	private String companyid;
	private List<BookMarkCompany> bookMarkCompanies;
	private List<CompanyComment> companyComments;
	private List<CompanyEvent> companyEvents;
	private CompanyEvent companyEvent;
	private String companyEventId;
	private String companyeventinfo;
	private CompanyComment companyComment;
	private String companycommentid;
	private String optionscontact;
	private String optionscompany;
	

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@Action("contacts")
	public String execute(){
		contacts=contactService.getContacts(user);
		for (ContactExtra contactExtra  : contactExtraService.getContactExtras(user)) {
			contacts.add(contactExtra.getContact());
		}
		
		companies=companyService.getCompanies(user);
		for (CompanyExtra companyExtra  : companyExtraService.getCompanyExtras(user)) {
			companies.add(companyExtra.getCompany());
		}
		
		return "success";
	}
	
	@Action("tocontact")
	public String tocontact(){
		contact=contactService.findById(contact_id);
		bookMarkContacts=bookMarkContactService.getBookMarkContacts(contact);
		contactEvents=contactEventservice.getContactEvents(contact);
		
		contactChances=chanceService.getContactChances(contact);
		
		ActionContext.getContext().getSession().put("contact",contact);
		
		return "success";
	}
	
	@Action(value="addContactEventInfo",results={@Result(type="redirectAction",name="success",params={"actionName","tocontact","contact_id","${contact_id}"})})
	public String addContactEventInfo(){
		contact=contactService.findById(contact_id);
		contactEvent=new ContactEvent();
		contactEvent.setContact(contact);
		contactEvent.setCreatetime(Time.getTime());
		contactEvent.setInfo(contactEventInfo);
		contactEvent.setUser(user);
		
		contactEventservice.add(contactEvent);
		
		messageService.add(user, user.getName()+"添加了联系人事件"+TextShorten.shorten(contactEvent.getInfo()),"联系人事件" );
		
		return "success";
	}

	@Action(value="delcontactevent",results={@Result(type="redirectAction",name="success",params={"actionName","tocontact","contact_id","${contact_id}"})})
	public String contacteventid(){
		contactEvent=contactEventservice.findById(contacteventid);
		contactComments=contactCommentService.getComments(contactEvent);
		for (ContactComment contactComment : contactComments) {
			contactCommentService.del(contactComment.getId());
		}
		
		messageService.add(user, user.getName()+"删除了联系人事件"+TextShorten.shorten(contactEvent.getInfo()),"联系人事件" );
		
		contactEventservice.deleteById(contacteventid);
		
		return "success";
	}
	
	@Action(value="editcontactevent")
	public String editcontactevent(){
		contactEvent=contactEventservice.findById(contacteventid);
		
		return "success";
	}
	
	@Action(value="updateContactEvent",results={@Result(type="redirectAction",name="success",params={"actionName","tocontact","contact_id","${contact_id}"})})
	public String updateContactEvent(){
		contactEvent=contactEventservice.findById(contacteventid);
		contactEvent.setInfo(contactEventInfo);
		
		contactEventservice.add(contactEvent);
		
		messageService.add(user, user.getName()+"更新了联系人事件"+TextShorten.shorten(contactEvent.getInfo()),"联系人事件" );
		
		return "success";
	}
	
	@Action("contacteventcomment")
	public String contacteventcomment(){
		contactEvent=contactEventservice.findById(contacteventid);
		contactComments=contactCommentService.getComments(contactEvent);
		
		return "success";
	}
	
	@Action(value="delcontacteventcomment",results={@Result(type="redirectAction",name="success",params={"actionName","contacteventcomment","contacteventid","${contacteventid}"})})
	public String delcontacteventcomment(){
		messageService.add(user, user.getName()+"删除了对联系人事件"+TextShorten.shorten(contactCommentService.findById(contactCommentId).getContactEvent().getId())+"的评论","联系人事件评论" );
		
		contactCommentService.del(contactCommentId);
		
		return "success";
	}
	
	@Action(value="addcontactcomment",results={@Result(type="redirectAction",name="success",params={"actionName","contacteventcomment","contacteventid","${contacteventid}"})})
	public String addcontactcomment(){
		contactEvent=contactEventservice.findById(contacteventid);
		contactComment.setContactEvent(contactEvent);
		contactComment.setCreatetime(Time.getTime());
		contactComment.setUser(user);
		
		contactCommentService.add(contactComment);
		
		messageService.add(user, user.getName()+"对联系人事件"+TextShorten.shorten(contactEvent.getInfo())+"进行了评论","联系人事件评论" );
		
		return "success";
	}
	
	@Action(value="toaddcontactchance")
	public String toaddcontactchance(){
		contact=contactService.findById(contact_id);
		chanceTypes=chanceTypeDao.findAll();
		return "success";
	}
	
	@Action(value="addcontactchance",results={@Result(type="redirectAction",name="success",params={"actionName","tocontact","contact_id","${contact_id}"})})
	public String addContactChance(){
		contact=contactService.findById(contact_id);
		chance.setContact(contact);
		chance.setChanceType(chanceTypeDao.findById(chanceType));
		chance.setUser(user);
		chance.setStatus("跟踪");
		chance.setCreatetime(Time.getTime());
		
		chanceService.addChance(chance);
		
		messageService.add(user, user.getName()+"在联系人"+contact.getName()+"身上发现了机会"+chance.getName(),"联系人机会" );
		
		return "success";
	}
	
	@Action(value="toaddcontact")
	public String toaddcontact(){
		
		return "success";
	}
	
	@Action(value="toaddcompany")
	public String toaddcompany(){
		
		return "success";
	}
	
	@Action(value="addcontact",results={@Result(type="redirectAction",name="success",params={"actionName","contacts"})})
	public String addcontact(){
		contact.setAvatar("contact.png");
		contact.setCreatetime(Time.getTime());
		contact.setUser(user);
		
		contactService.add(contact);
		messageService.add(user, user.getName()+"添加了联系人"+contact.getName(),"联系人" );
		
		if ("all".equals(optionscontact)) {
			List<User> users=userService.getuOtherUsers();
			
			for (User user : users) {
				ContactExtra contactExtra=new ContactExtra();
				contactExtra.setContact(contact);
				contactExtra.setUser(user);
				
				contactExtraService.add(contactExtra);
			}
		}
		
		return "success";
	}
	
	@Action(value="addcompany",results={@Result(type="redirectAction",name="success",params={"actionName","contacts"})})
	public String addcompany(){
		company.setUser(user);
		company.setCreatetime(Time.getTime());
		company.setAvatar("company.png");
		
		companyService.add(company);
		messageService.add(user, user.getName()+"添加了公司"+company.getName(),"公司" );
		
		if ("all".equals(optionscompany)) {
			List<User> users=userService.getuOtherUsers();
			
			for (User user : users) {
				CompanyExtra companyExtra=new CompanyExtra();
				companyExtra.setCompany(company);
				companyExtra.setUser(user);
				companyExtraService.add(companyExtra);
			}
		}
		
		return "success";
	}
	
	@Action("toeditcontact")
	public String toeditcontact(){
		contact=contactService.findById(contact_id);
		
		return "success";
	}
	
	@Action(value="updatecontact",results={@Result(type="redirectAction",name="success",params={"actionName","tocontact","contact_id","${contact_id}"})})
	public String updatecontact(){
		Contact c=contactService.findById(contact_id);
		c.setAddress(contact.getAddress());
		c.setBg_info(contact.getBg_info());
		c.setEmail(contact.getEmail());
		c.setIm(contact.getIm());
		c.setName(contact.getName());
		c.setPhone(contact.getPhone());
		c.setPost(contact.getPost());
		c.setWebsite(contact.getWebsite());
		c.setWeibo(contact.getWeibo());
		c.setCompanyname(contact.getCompanyname());
		
		contactService.add(c);
		
		messageService.add(user, user.getName()+"更新了联系人"+c.getName(),"联系人" );
		
		return "success";
	}
	
	@Action("tocompany")
	public String tocompany(){
		company=companyService.findById(companyid);
		bookMarkCompanies=bookMarkCompanyService.getBookMarkCompanies(company);
		
		companyEvents=companyEventService.getCompanyEvents(company);
		companyChances=chanceService.getCompanyChances(company);
		contacts=contactService.getCompanyContacts(company);
		
		ActionContext.getContext().getSession().put("company", company);
		
		return "success";
	}
	
	@Action(value="addcompanyevent",results={@Result(type="redirectAction",name="success",params={"actionName","tocompany","companyid","${companyid}"})})
	public String addcompanyevent(){
		company=companyService.findById(companyid);
		companyEvent.setCompany(company);
		companyEvent.setCreatetime(Time.getTime());
		companyEvent.setUser(user);
		
		companyEventService.add(companyEvent);
		
		messageService.add(user, user.getName()+"为公司"+company.getName()+"添加了事件"+TextShorten.shorten(companyEvent.getInfo()),"公司事件" );
		
		return "success";
	}
	
	@Action(value="delcompanyevent")
	public void delcompanyevent(){
		companyEvent=companyEventService.findById(companyEventId);
		companyComments=companyCommentService.getCompanyComments(companyEvent);
		for (int i = 0; i < companyComments.size(); i++) {
			companyCommentService.del(companyComments.get(i).getId());
		}
		
		messageService.add(user, user.getName()+"删除了公司事件"+TextShorten.shorten(companyEvent.getInfo()),"公司事件" );
		
		companyEventService.delete(companyEventId);
	}
	
	@Action("editcompanyevent")
	public String editcompanyevent(){
		companyEvent=companyEventService.findById(companyEventId);
		
		return "success";
	}
	
	@Action(value="updatecompanyevent",results={@Result(type="redirectAction",name="success",params={"actionName","tocompany","companyid","${company.id}"})})
	public String updatecompanyevent(){
		
		company=(Company) ActionContext.getContext().getSession().get("company");
		
		companyEvent=companyEventService.findById(companyEventId);
		companyEvent.setInfo(companyeventinfo);
		
		companyEventService.add(companyEvent);
		
		messageService.add(user, user.getName()+"更新了公司事件"+TextShorten.shorten(companyEvent.getInfo()),"公司事件" );
		
		return "success";
	}
	
	@Action("companyeventcomment")
	public String companyeventcomment(){
		companyEvent=companyEventService.findById(companyEventId);
		companyComments=companyCommentService.getCompanyComments(companyEvent);
		
		return "success";
	}
	
	@Action(value="addcompanycomment",results={@Result(type="redirectAction",name="success",params={"actionName","companyeventcomment","companyEventId","${companyEventId}"})})
	public String addcompanycomment(){
		companyEvent=companyEventService.findById(companyEventId);
		
		companyComment.setCreatetime(Time.getTime());
		companyComment.setUser(user);
		companyComment.setCompanyEvent(companyEvent);
		
		companyCommentService.add(companyComment);
		
		messageService.add(user, user.getName()+"为公司事件"+TextShorten.shorten(companyEvent.getInfo())+"添加了评论","公司事件评论" );
		
		return "success";
	}
	
	@Action(value="delcompanycomment")
	public void delcompanycomment(){
		
		messageService.add(user, user.getName()+"删除了对公司事件"+TextShorten.shorten(companyCommentService.find(companycommentid).getCompanyEvent().getInfo())+"的评论","公司事件评论" );
		
		companyCommentService.del(companycommentid);
		//return "success";
	}
	
	@Action("toeditcompany")
	public String toeditcompany(){
		return "success";
	}
	
	@Action(value="updatecompany",results={@Result(type="redirectAction",name="success",params={"actionName","tocompany","companyid","${companyid}"})})
	public String updatecompany(){
		Company cmp=new Company();
		cmp=companyService.findById(companyid);
		
		cmp.setAddress(company.getAddress());
		cmp.setBg_info(company.getBg_info());
		cmp.setEmail(company.getEmail());
		cmp.setIm(company.getIm());
		cmp.setName(company.getName());
		cmp.setPhone(company.getPhone());
		cmp.setWebsite(company.getWebsite());
		cmp.setWeibo(company.getWeibo());
		
		companyService.add(cmp);
		
		messageService.add(user, user.getName()+"更新了公司"+cmp.getName()+"的资料","公司" );
		
		return "success";
	}
	
	@Action("toaddcompanychance")
	public String toaddcompanychance(){
		chanceTypes=chanceTypeDao.findAll();
		return "success";
	}
	
	@Action(value="addcompanychance",results={@Result(type="redirectAction",name="success",params={"actionName","tocompany","companyid","${companyid}"})})
	public String addcompanychance(){
		chance.setChanceType(chanceTypeDao.findById(chanceType));
		chance.setCreatetime(Time.getTime());
		chance.setStatus("跟踪");
		chance.setUser(user);
		company=companyService.findById(companyid);
		chance.setCompany(company);
		
		chanceService.addChance(chance);
		
		messageService.add(user, user.getName()+"在公司"+company.getName()+"上发现了商机"+chance.getName(),"公司机会" );
		
		return "success";
	}
	
	@Action("toaddcompanycontact")
	public String toaddcompanycontact(){
		
		return "success";
	}
	
	@Action(value="addcompanycontact",results={@Result(type="redirectAction",name="success",params={"actionName","tocompany","companyid","${companyid}"})})
	public String addcompanycontact(){
		contact.setAvatar("contact.png");
		contact.setCreatetime(Time.getTime());
		contact.setUser(user);
		company=companyService.findById(companyid);
		contact.setCompany(company);
		
		contactService.add(contact);
		
		messageService.add(user, user.getName()+"为公司"+company.getName()+"添加了联系人"+contact.getName(),"公司联系人" );
		
		return "success";
	}
	
	
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public String getContact_id() {
		return contact_id;
	}

	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}


	public List<BookMarkContact> getBookMarkContacts() {
		return bookMarkContacts;
	}

	public void setBookMarkContacts(List<BookMarkContact> bookMarkContacts) {
		this.bookMarkContacts = bookMarkContacts;
	}

	public String getContactEventInfo() {
		return contactEventInfo;
	}

	public void setContactEventInfo(String contactEventInfo) {
		this.contactEventInfo = contactEventInfo;
	}

	public ContactEvent getContactEvent() {
		return contactEvent;
	}

	public void setContactEvent(ContactEvent contactEvent) {
		this.contactEvent = contactEvent;
	}
	public void setContactEventservice(ContactEventservice contactEventservice) {
		this.contactEventservice = contactEventservice;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public List<ContactEvent> getContactEvents() {
		return contactEvents;
	}

	public void setContactEvents(List<ContactEvent> contactEvents) {
		this.contactEvents = contactEvents;
	}

	public String getContacteventid() {
		return contacteventid;
	}

	public void setContacteventid(String contacteventid) {
		this.contacteventid = contacteventid;
	}

	public void setBookMarkContactService(
			BookMarkContactService bookMarkContactService) {
		this.bookMarkContactService = bookMarkContactService;
	}

	public List<ContactComment> getContactComments() {
		return contactComments;
	}

	public void setContactComments(List<ContactComment> contactComments) {
		this.contactComments = contactComments;
	}

	public void setContactCommentService(ContactCommentService contactCommentService) {
		this.contactCommentService = contactCommentService;
	}

	public String getContactCommentId() {
		return contactCommentId;
	}

	public void setContactCommentId(String contactCommentId) {
		this.contactCommentId = contactCommentId;
	}

	public ContactComment getContactComment() {
		return contactComment;
	}

	public void setContactComment(ContactComment contactComment) {
		this.contactComment = contactComment;
	}

	public void setChanceService(ChanceService chanceService) {
		this.chanceService = chanceService;
	}

	public List<Chance> getContactChances() {
		return contactChances;
	}

	public void setContactChances(List<Chance> contactChances) {
		this.contactChances = contactChances;
	}

	public Chance getChance() {
		return chance;
	}

	public void setChance(Chance chance) {
		this.chance = chance;
	}

	public List<ChanceType> getChanceTypes() {
		return chanceTypes;
	}

	public void setChanceTypes(List<ChanceType> chanceTypes) {
		this.chanceTypes = chanceTypes;
	}

	public void setChanceTypeDao(ChanceTypeDao chanceTypeDao) {
		this.chanceTypeDao = chanceTypeDao;
	}

	public String getChanceType() {
		return chanceType;
	}

	public void setChanceType(String chanceType) {
		this.chanceType = chanceType;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public void setBookMarkCompanyService(
			BookMarkCompanyService bookMarkCompanyService) {
		this.bookMarkCompanyService = bookMarkCompanyService;
	}

	public List<BookMarkCompany> getBookMarkCompanies() {
		return bookMarkCompanies;
	}

	public void setBookMarkCompanies(List<BookMarkCompany> bookMarkCompanies) {
		this.bookMarkCompanies = bookMarkCompanies;
	}

	public void setCompanyCommentService(CompanyCommentService companyCommentService) {
		this.companyCommentService = companyCommentService;
	}

	public List<CompanyComment> getCompanyComments() {
		return companyComments;
	}

	public void setCompanyComments(List<CompanyComment> companyComments) {
		this.companyComments = companyComments;
	}

	public List<CompanyEvent> getCompanyEvents() {
		return companyEvents;
	}

	public void setCompanyEvents(List<CompanyEvent> companyEvents) {
		this.companyEvents = companyEvents;
	}

	public void setCompanyEventService(CompanyEventService companyEventService) {
		this.companyEventService = companyEventService;
	}

	public CompanyEvent getCompanyEvent() {
		return companyEvent;
	}

	public void setCompanyEvent(CompanyEvent companyEvent) {
		this.companyEvent = companyEvent;
	}

	public String getCompanyEventId() {
		return companyEventId;
	}

	public void setCompanyEventId(String companyEventId) {
		this.companyEventId = companyEventId;
	}

	public String getCompanyeventinfo() {
		return companyeventinfo;
	}

	public void setCompanyeventinfo(String companyeventinfo) {
		this.companyeventinfo = companyeventinfo;
	}

	public CompanyComment getCompanyComment() {
		return companyComment;
	}

	public void setCompanyComment(CompanyComment companyComment) {
		this.companyComment = companyComment;
	}

	public String getCompanycommentid() {
		return companycommentid;
	}

	public void setCompanycommentid(String companycommentid) {
		this.companycommentid = companycommentid;
	}

	public List<Chance> getCompanyChances() {
		return companyChances;
	}

	public void setCompanyChances(List<Chance> companyChances) {
		this.companyChances = companyChances;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void setContactExtraService(ContactExtraService contactExtraService) {
		this.contactExtraService = contactExtraService;
	}

	public void setCompanyExtraService(CompanyExtraService companyExtraService) {
		this.companyExtraService = companyExtraService;
	}

	public String getOptionscontact() {
		return optionscontact;
	}

	public void setOptionscontact(String optionscontact) {
		this.optionscontact = optionscontact;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getOptionscompany() {
		return optionscompany;
	}

	public void setOptionscompany(String optionscompany) {
		this.optionscompany = optionscompany;
	}
	
}
