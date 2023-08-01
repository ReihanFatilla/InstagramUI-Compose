package com.reift.instagram_ui.model

import com.reift.instagram_ui.data.Dummy

data class Reels(
    val caption: String,
    val user: User,
    val youtubeUrl: String,
    val likedBy: List<User>,
    val tags: List<String>,
    val listComment: List<Comment>
){
    companion object {
        val listReels = arrayListOf<Reels>().also { list ->
            repeat(35) {
                with(Dummy) {
                    list.add(
                        Reels(
                            caption = caption.shuffled()[0],
                            user = User.listUsers.shuffled()[0],
                            youtubeUrl = videoUrls.shuffled()[0],
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
