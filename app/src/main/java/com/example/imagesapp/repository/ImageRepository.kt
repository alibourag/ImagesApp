package com.example.imagesapp.repository

import com.example.imagesapp.api.ImageService
import javax.inject.Inject

class ImageRepository
@Inject
constructor(private val api : ImageService)
{
    suspend fun getAllImages()= api.getAllImage()
}