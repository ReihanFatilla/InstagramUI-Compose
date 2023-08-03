package com.reift.instagram_ui.`interface`

import com.reift.instagram_ui.model.Comment

interface CommentListener {
    fun onClick(listComment: List<Comment>)
}