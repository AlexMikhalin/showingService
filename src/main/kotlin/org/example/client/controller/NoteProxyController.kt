package org.example.client.controller

import org.example.client.model.NoteResponse
import org.example.client.service.NoteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/proxy/notes")
class NoteProxyController(private val noteService: NoteService) {

    @GetMapping
    fun getNotes(): List<NoteResponse> = noteService.getAllNotes()

    @PostMapping
    fun createNote(@RequestParam text: String): NoteResponse? = noteService.addNote(text)
}
