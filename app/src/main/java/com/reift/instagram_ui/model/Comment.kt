package com.reift.instagram_ui.model

import com.reift.instagram_ui.data.Dummy

data class Comment(
    val user: User,
    val message: String,
) {
    companion object {
        val listComment = arrayListOf<Comment>().also { list ->
            repeat(30) {
                list.add(
                    Comment(
                        user = User.listUsers.shuffled()[0],
                        message = Dummy.comments.shuffled()[0]
                    )
                )
            }
        }
    }
}