package com.reift.instagram_ui.model

import com.reift.instagram_ui.data.Dummy

data class Story(
    val user: User,
    val imageUrl: String,
){
    companion object{
        val listStory = arrayListOf<Story>().also { list ->
            repeat(10) {
                with(Dummy) {
                    list.add(
                        Story(User(
                            username = username.shuffled()[0],
                            profileUrl = profileUrl.shuffled()[0]
                        ),
                        imageUrl = imageUrl.shuffled()[0])
                    )
                }
            }
        }
        val listHighlight = arrayListOf<Story>().also { list ->
            repeat(10) {
                with(Dummy) {
                    list.add(
                        Story(User(
                            username = highlight.shuffled()[0],
                            profileUrl = CoverUrl.shuffled()[0]
                        ),
                        imageUrl = imageUrl.shuffled()[0])
                    )
                }
            }
        }
    }
}
