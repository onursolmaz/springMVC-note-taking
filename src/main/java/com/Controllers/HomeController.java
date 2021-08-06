package com.Controllers;

import com.Entities.Note;
import com.Entities.User;
import com.Security.LoginFilter;
import com.Services.MailService;
import com.Services.NoteService;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
@RequestMapping("")
public class HomeController {

    public static String url = "http://localhost:8080";

    @Autowired
    NoteService noteService;

    @Autowired
    MailService mailService;


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("notes", noteService.getAll(1l));
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createNote")
    public String createNote() {
        return "addNote";
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model) {
        User loggedInUser= LoginFilter.loggedInUser;

        model.addAttribute("user",loggedInUser);
        model.addAttribute("id", id);
        return "detail";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/addNote")
    public ResponseEntity<String> addNote(@RequestBody Note note, HttpServletRequest request) {
        noteService.createNote(note, request);
        System.out.println(note.toString());
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateNote")
    public ResponseEntity<String> updateNote(@RequestBody Note note, HttpServletRequest request) {

        Note oldNote = noteService.findById(note.getId());
        oldNote.setTitle(note.getTitle());
        oldNote.setContent(note.getContent());

        noteService.update(oldNote, request);

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteNote")
    public ResponseEntity<String> deleteNote(@RequestBody Note note, HttpServletRequest request) {

        Note oldNote = noteService.findById(note.getId());
        noteService.delete(oldNote, request);

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/getNotes")
    public ResponseEntity<ArrayList<Note>> getNotes(HttpServletRequest request) {
        User loggedInUser = LoginFilter.loggedInUser;

        if (loggedInUser != null) {
            return new ResponseEntity<>(noteService.getAll(loggedInUser.getId()), HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity("ERROR", HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getNote")
    public ResponseEntity<Note> getNote(@RequestBody String id, HttpServletRequest request) {

        Note note = noteService.findById(Long.valueOf(id));

        if (note.getUser_id().equals(LoginFilter.loggedInUser.getId())) {
            return new ResponseEntity<>(noteService.findById(Long.valueOf(id)), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
    }

}
