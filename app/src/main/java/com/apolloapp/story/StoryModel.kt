package com.apolloapp.story

import java.util.*

/**
 * Created by fredbraga on 20/03/18.
 */
class StoryModel(
     val uuid: String? = null,
     val title: String? = null,
     val subtitle: String?= null,
     val description: String? = null,
     val content : String? = null,
     val author : String? = null,
     val image: String? = null,
     val type: String? = null,
     val published: Any? = null,
     val viewers: Long? = null,
     val url: String? = null,
     val _id: Any? = null
)