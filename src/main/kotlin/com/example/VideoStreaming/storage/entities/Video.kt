package com.example.VideoStreaming.storage.entities

import jakarta.persistence.*
import java.time.Instant

@Entity
class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null

    @Column(nullable=false)
    val title : String? = null

    @Column(nullable=false)
    val description : String? = null

    @Column(nullable=false)
    val url : String? = null

    @Column(nullable=false)
    val duration : Long? = null

    @Column(nullable=false)
    val createdAt : Instant? = Instant.now()

    @Column(nullable=false)
    val uploadedAt : Instant? = Instant.now()

}