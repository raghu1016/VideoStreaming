package com.example.VideoStreaming.service

import com.example.VideoStreaming.storage.entities.Video
import com.example.VideoStreaming.storage.repository.VideoRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import java.util.*

@Service
class VideoService (private val videoRepository: VideoRepository) {

    fun getAllVideos() : List<Video> = videoRepository.findAll()

    fun getVideoByid(id : Long) : Optional<Video> = videoRepository.findById(id)

    fun searchVideosByTitle(title : String) : List<Video> = videoRepository.findByTitle(title)

    fun createVideo(video : Video) : Video = videoRepository.save(video)

    fun updateVideo(id:Long, video : Video) : Video{
        return if (videoRepository.existsById(id)){
            videoRepository.save(video)
        }
        else{
            throw RuntimeException("Video with id $id not found")
        }
    }

    fun deleteVideo(id:Long) : Unit = videoRepository.deleteById(id)

}