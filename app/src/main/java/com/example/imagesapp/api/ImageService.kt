package com.example.imagesapp.api

import com.bersyte.retrofitdaggerhilt.model.ImageItem
import com.example.imagesapp.utils.Constants.END_POINT
import com.example.imagesapp.utils.Constants.KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @Headers("Accept-Version: v1", "Authorization: Client-ID $KEY")
    @GET(END_POINT)
    suspend fun getAllImage(): Response<List<ImageItem>>
}