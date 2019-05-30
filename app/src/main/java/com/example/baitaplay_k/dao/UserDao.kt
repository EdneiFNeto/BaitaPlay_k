package com.example.baitaplay_k.dao

import com.example.baitaplay_k.model.User

class UserDao {
    companion object {

        fun getUser():List<User>{
            return listOf(User("ednei", "123456", true))
        }
    }
}