package com.example.baitaplay_k.dao

import com.example.baitaplay_k.model.User

class UserDao() {

    var list = ArrayList<User>()

    fun save(user: User) {
        list.add(user)
    }

    companion object {

        /*fun getUser():ArrayList<User>{
            return lis
        }*/
    }
}