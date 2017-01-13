package cn.samoye.nsfw.user.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import cn.samoye.nsfw.user.bean.User;
import cn.samoye.nsfw.user.service.UserService;

public class UserAction extends ActionSupport {
	@Resource
	private UserService userService;
	private List<User> userList;
	private User user;
	private String[] selectedRow;
	//1.列表页面
	public String listUI(){
		userList = userService.queryUserList();
		return "listUI";
	}
	//2.新增页面
	public String addUI(){
		return "addUI";
	}
	
	//3.保存新增
	public String add(){
		userService.save(user);
		return "list";
	}
	//4.更新页面
	public String updateUI(){
		if(user != null && StringUtils.isNotBlank(user.getId())){
			user = userService.queryUserById(user.getId());
		}
		return "updateUI";
	}
	//5.保存更新
	public String update(){
		userService.update(user);
		return "list";
	}
	//6.删除
	public String delete(){
		if(user != null && StringUtils.isNotBlank(user.getId())){
			userService.delete(user.getId());
		}
		return "list";
	}
	//7.批量删除
	public String deletes(){
		if(selectedRow != null && selectedRow.length > 0){
			for (String id : selectedRow) {
				userService.delete(id);
			}
		}
		return "list";
	}

	
	/**
	 * ---------------------------------数据的封装
	 */
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String[] getSelectedRow() {
		return selectedRow;
	}
	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}
	
}
