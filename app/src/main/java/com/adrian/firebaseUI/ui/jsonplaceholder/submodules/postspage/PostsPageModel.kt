package com.adrian.firebaseUI.ui.jsonplaceholder.submodules.postspage

import com.adrian.firebaseUI.data.ApiService

/**
 * Created by cadri on 2017. 08. 05..
 */

class PostsPageModel constructor(val apiService: ApiService) {

    fun callApiService() = apiService.fakeApiCall()

}