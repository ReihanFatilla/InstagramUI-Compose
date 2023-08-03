package com.reift.instagram_ui.model

import com.reift.instagram_ui.data.Dummy

data class User(
    val username: String,
    val profileUrl: String,
) {
    companion object {
        val listUsers = arrayListOf<User>().also { list ->
            repeat(15) {
                with(Dummy) {
                    list.add(
                        User(
                            username = username.shuffled()[0],
                            profileUrl = profileUrl.shuffled()[0]
                        )
                    )
                }
            }
        }

    }
}
