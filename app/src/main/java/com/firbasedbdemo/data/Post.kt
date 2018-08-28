package com.firbasedbdemo.data

import com.google.firebase.database.Exclude


/**
 * @author Sino K D
 * @since 8/23/18.
 */
class Post {

    var key: String? = null
    var id: String? = null
    var content: String? = null

    constructor() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    constructor(content: String) {
        this.content = content
        this.id = System.currentTimeMillis().toString()
    }

    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result.put("content", content!!)
        return result
    }
}