package com.example.VideoStreaming.storage.repository

import com.example.VideoStreaming.storage.entities.Video
import org.springframework.data.jpa.repository.JpaRepository

interface VideoRepository : JpaRepository<Video, Long> {

    fun findByTitle(videoTitle: String): List<Video>


}