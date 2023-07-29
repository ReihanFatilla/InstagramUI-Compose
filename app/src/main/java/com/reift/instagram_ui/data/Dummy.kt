package com.reift.instagram_ui.data

import com.reift.instagram_ui.model.Story

object Dummy {
    val tags = listOf("Food", "Car", "Sport", "Technology", "Social", "Programming").shuffled().take((0..3).random())
    val caption = listOf(
        "Revving up my taste buds in style! 🚗🍔",
        "Pushing my athletic limits with the help of cutting-edge tech! 🏋️‍♂️🔧",
        "Coding, connecting, and creating amazing memories with friends! 💻🤝",
        "Exploring the world of gastronomy and tech innovations! 🌐🍽️",
        "Cruising with friends, making unforgettable memories on the road! 🚗🤝",
        "Sports, friends, and code - the ultimate trifecta of fun and growth! 🏀👫💻"
    )
    val profileUrl = listOf(
        "https://randomuser.me/api/portraits/men/1.jpg",
        "https://randomuser.me/api/portraits/women/2.jpg",
        "https://randomuser.me/api/portraits/men/3.jpg",
        "https://randomuser.me/api/portraits/women/4.jpg",
        "https://randomuser.me/api/portraits/men/5.jpg",
        "https://randomuser.me/api/portraits/women/6.jpg"
    )
    val username = listOf(
        "reihanfatilla",
        "emma_smith",
        "alex_walker",
        "sara_miller",
        "michael_brown",
        "olivia_johnson"
    )
    val imageUrl = listOf(
        "https://picsum.photos/500/300?random=1",
        "https://picsum.photos/500/300?random=2",
        "https://picsum.photos/500/300?random=3",
        "https://picsum.photos/500/300?random=4",
        "https://picsum.photos/500/300?random=5",
        "https://picsum.photos/500/300?random=6"
    )
    val highlight = listOf(
        "Travel",
        "Foodie",
        "Fitness",
        "Throwback",
        "Nature",
    )
    val CoverUrl = listOf(
        "https://picsum.photos/500/300?random=10",
        "https://picsum.photos/500/300?random=20",
        "https://picsum.photos/500/300?random=30",
        "https://picsum.photos/500/300?random=40",
        "https://picsum.photos/500/300?random=50",
        "https://picsum.photos/500/300?random=60",
    )
}