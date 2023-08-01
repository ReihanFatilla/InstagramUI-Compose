package com.reift.instagram_ui.data

object Dummy {
    val tags = listOf("Food", "Car", "Sport", "Technology", "Social", "Programming").shuffled()
        .take((0..3).random())
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
    val comments = listOf(
        "Great work!",
        "Well done!",
        "Impressive!",
        "Fantastic effort!",
        "You nailed it!",
        "Awesome job!",
        "Keep up the good work!",
        "Outstanding performance!",
        "Bravo!",
        "You're doing great!",
        "You're on fire!",
        "Incredible!",
        "Superb!",
        "You've got this!",
        "Very impressive!",
        "I'm amazed!",
        "You're a star!",
        "Thumbs up!",
        "Excellent!",
        "I'm proud of you!",
    )
    val videoUrls = listOf(
        "wlgOUsTlYQU",
        "E2b3S3kn6B0",
        "SIYx4vN-ei4",
        "ZgBOgw5Xq_I",
        "c7c4d37u5_A",
    )
}