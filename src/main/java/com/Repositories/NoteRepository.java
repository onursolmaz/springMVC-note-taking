package com.Repositories;

import com.Entities.Note;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@Repository
public class NoteRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Long insert(Note note) {
        Long id = (Long) sessionFactory.getCurrentSession().save(note);
        return id;
    }

    public void update(Note note) {
        sessionFactory.getCurrentSession().update(note);
    }

    public void delete(Note note) {
        sessionFactory.getCurrentSession().delete(note);
    }

    public void persist(Note note) {
        sessionFactory.getCurrentSession().persist(note);
    }

    public Note findById(Long id) {
        Note note = (Note) sessionFactory.getCurrentSession().createQuery("FROM Note WHERE id=:id").setLong("id", id).getSingleResult();
        return note;
    }

    public ArrayList<Note> getAll(Long user_id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Note WHERE user_id=:user_id ORDER BY id DESC").setLong("user_id", user_id);
        return (ArrayList<Note>) query.getResultList();
    }


    public List<Note> getAll() {
        List<Note> notes = sessionFactory.getCurrentSession().createQuery("FROM Note").list();
        return notes;
    }


}
