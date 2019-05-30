package com.example.baitaplay_k.api

import com.example.baitaplay_k.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkAPI {

    @GET("posts/")
    fun getAllPosts(): Observable<List<Post>>
}