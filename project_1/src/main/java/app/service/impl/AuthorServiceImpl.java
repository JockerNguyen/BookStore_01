package app.service.impl;

import app.model.Author;
import app.service.AuthorService;

import java.io.Serializable;
import java.util.List;

public class AuthorServiceImpl extends BaseServiceImpl implements AuthorService {
    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Override
    public Author findById(Serializable key) {
        return null;
    }

    @Override
    public Author saveOrUpdate(Author entity) {
        return null;
    }

    @Override
    public boolean delete(Author entity) {
        return false;
    }
}
