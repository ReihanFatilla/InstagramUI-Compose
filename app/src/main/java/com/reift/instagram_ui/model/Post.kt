package com.reift.instagram_ui.model

import com.reift.instagram_ui.data.Dummy

data class Post(
    val caption: String,
    val user: User,
    val imageUrl: String,
    val tags: List<String>,
    val likedBy: List<User>,
    val listComment: List<Comment>,
) {
    companion object {
        val listPost = arrayListOf<Post>().also { list ->
            repeat(35) {
                with(Dummy) {
                    list.add(
                        Post(
                            caption = caption.shuffled()[0],
                            user = User.listUsers.shuffled()[0],
                            imageUrl = imageUrl.shuffled()[0],
                            tags = tags.shuffled().take(3),
                            likedBy = User.listUsers.shuffled().take((1..3).random()),
                            listComment = Comment.listComment.take((3..15).random())
                        )
                    )
                }

            }
        }
    }
}
