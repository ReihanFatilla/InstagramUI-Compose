package com.reift.instagram_ui.model

import com.reift.instagram_ui.data.Dummy

data class User(
    val username: String,
    val profileUrl: String,
) {
    companion object {
        val listUsers = arrayListOf<User>().also { list ->
            repeat(10) {
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
        val listHighlight = arrayListOf<User>().also { list ->
            repeat(10) {
                with(Dummy) {
                    list.add(
                        User(
                            username = highlight.shuffled()[0],
                            profileUrl = CoverUrl.shuffled()[0]
                        )
                    )
                }
            }
        }
    }
}
