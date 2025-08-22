package org.example.client.service

import org.example.client.model.NoteResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class NoteService {

    private val client = WebClient.create("http://localhost:9090") // адрес первого сервиса

    fun getAllNotes(): List<NoteResponse> {
        return client.get()
            .uri("/notes")
            .retrieve()
            .bodyToMono(Array<NoteResponse>::class.java)
            .block()
            ?.toList() ?: emptyList()
    }

    fun addNote(text: String): NoteResponse? {
        val body = mapOf("text" to text)
        return client.post()
            .uri("/notes")
            .bodyValue(body)
            .retrieve()
            .bodyToMono(NoteResponse::class.java)
            .block()
    }
}
