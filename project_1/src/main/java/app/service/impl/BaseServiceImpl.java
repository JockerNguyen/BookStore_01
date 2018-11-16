package app.service.impl;

import app.DAO.AuthorDAO;
import app.DAO.UserDAO;

public class BaseServiceImpl {
	protected UserDAO userDAO;
	protected AuthorDAO authorDAO;

	public AuthorDAO getAuthorDAO() {
		return authorDAO;
	}

	public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
