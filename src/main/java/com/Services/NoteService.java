package com.Services;

import com.Entities.Note;
import com.Repositories.NoteRepository;
import com.Security.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public Long createNote(Note note, HttpServletRequest request){
        note.setUser_id(LoginFilter.loggedInUser.getId());
        return noteRepository.insert(note);
    }

    public List<Note> getAll(){
        return noteRepository.getAll();
    }

    public ArrayList<Note> getAll(Long user_id){
        return noteRepository.getAll(user_id);
    }

    public Note findById(Long user_id){
        return noteRepository.findById(user_id);
    }

    public Long update(Note note, HttpServletRequest request){
        noteRepository.update(note);
        return 1l;
    }

    public Long delete(Note note, HttpServletRequest request){
        noteRepository.delete(note);
        return 1l;
    }


}
