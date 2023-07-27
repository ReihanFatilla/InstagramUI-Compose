package com.reift.instagram_ui.model

import com.reift.instagram_ui.data.Dummy

data class Story(
    val username: String,
    val profileUrl: String,
) {
    companion object {
        val listStory = arrayListOf<Story>().also { list ->
            repeat(10) {
                with(Dummy) {
                    list.add(
                        Story(
                            username = username.shuffled()[0],
                            profileUrl = profileUrl.shuffled()[0]
                        )
                    )
                }
            }
        }
    }
}
