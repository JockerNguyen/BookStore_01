package app.DAO.impl;

import app.DAO.AuthorDAO;
import app.DAO.GenericDAO;
import app.model.Author;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDAOImpl extends GenericDAO<Integer, Author> implements AuthorDAO {
    public AuthorDAOImpl() {
        super(Author.class);
    }

    public AuthorDAOImpl(SessionFactory sessionfactory) {
        setSessionFactory(sessionfactory);
    }

    @Override
    public List<Author> findAll() {
        Query query = getSession().createQuery("FROM Author");
        List<Author> authors = query.list();
        return  authors;
    }
}
