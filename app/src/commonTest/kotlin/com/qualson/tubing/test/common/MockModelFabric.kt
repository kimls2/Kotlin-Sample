package com.qualson.tubing.test.common

import com.qualson.tubing.data.model.Category
import com.qualson.tubing.data.model.CategoryResponse
import com.qualson.tubing.data.model.Channel
import java.util.*

/**
 * Created by ykim on 2017. 4. 20..
 */
object MockModelFabric {
    @JvmStatic fun randomString(): String {
        return UUID.randomUUID().toString()
    }

    @JvmStatic fun randomInt(): Int {
        return Random().nextInt()
    }

    @JvmStatic fun randomBoolean(): Boolean {
        return randomInt() % 2 == 0
    }

    @JvmStatic fun newCategoryResponse(): CategoryResponse {
        val categoryResponse = CategoryResponse()
        categoryResponse.code = 200
        categoryResponse.result = newChannelList(4)
        return categoryResponse
    }

    @JvmStatic fun newChannel(): Channel {
        val channel = Channel()
        channel.id = Random().nextInt(4)
        channel.priority = Random().nextInt(4)
        channel.deleted = true
        channel.released = true
        channel.categories = newCategory(3)
        return channel
    }

    @JvmStatic fun newCategory(): Category {
        val category = Category()
        category.released = randomBoolean()
        category.id = randomInt()
        category.released = randomBoolean()
        category.priority = randomInt()
        category.channelCount = randomInt()
        category.groupCount = randomInt()
        category.level = randomBoolean()
        category.mobileLink = randomString()
        return category
    }

    @JvmStatic fun newChannelList(size: Int): MutableList<Channel> {
        val list = ArrayList<Channel>()
        for (i in 0..size - 1) {
            list.add(newChannel())
        }
        return list
    }

    @JvmStatic fun newCategory(size: Int): MutableList<Category> {
        val list = ArrayList<Category>()
        for (i in 0..size - 1) {
            list.add(newCategory())
        }
        return list
    }
}