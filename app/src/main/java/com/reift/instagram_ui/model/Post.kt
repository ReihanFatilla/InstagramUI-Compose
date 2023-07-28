package com.reift.instagram_ui.model

import com.reift.instagram_ui.data.Dummy

data class Post(
    val caption: String,
    val username: String,
    val imageUrl: String,
    val profileUrl: String,
    val tags: List<String>,
    val likedBy: List<Story>,
) {
    companion object {
        val listPost = arrayListOf<Post>().also { list ->
            repeat(15) {
                with(Dummy) {
                    list.add(

                        Post(
                            caption = caption.shuffled()[0],
                            username = username.shuffled()[0],
                            imageUrl = imageUrl.shuffled()[0],
                            profileUrl = profileUrl.shuffled()[0],
                            tags = tags.shuffled().take(3),
                            likedBy = Story.listStory.shuffled().take((1..3).random())
                        )
                    )
                }

            }
        }
    }
}
