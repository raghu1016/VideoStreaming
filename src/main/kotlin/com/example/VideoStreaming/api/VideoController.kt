package com.example.VideoStreaming.api

import com.example.VideoStreaming.service.VideoService
import com.example.VideoStreaming.storage.entities.Video
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/videos")
class VideoController (private val videoService : VideoService){

    @GetMapping
    fun getAllVideos(): List<Video> = videoService.getAllVideos()

    @GetMapping("/{id}")
    fun getVideoByTd(@PathVariable id:Long) : Optional<Video> =videoService.getVideoByid(id)

    @GetMapping("/search")
    fun searchVideos(@RequestParam("q", defaultValue = "") q:String) :List<Video> = videoService.searchVideosByTitle(q)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createVideo(@RequestBody video: Video) : Video = videoService.createVideo(video)

    @PutMapping("/{id}")
    fun updateVideo(@PathVariable id: Long, @RequestBody video: Video) : Video = videoService.updateVideo(id, video)

    @DeleteMapping("/{id}")
    fun deleteVideo(@PathVariable id: Long){
        videoService.deleteVideo(id)
    }

}