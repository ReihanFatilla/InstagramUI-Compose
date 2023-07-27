package com.reift.instagram_ui.model

data class Story(
    val username: String,
    val profileUrl: String
){
    companion object {
        val listStory = arrayListOf<Story>().also{ list ->
            repeat(10){
                list.add(Story("reihanfatilla", "https://static.vecteezy.com/system/resources/previews/014/480/066/non_2x/man-avatar-icon-flat-style-vector.jpg"))
            }
        }
    }
}
