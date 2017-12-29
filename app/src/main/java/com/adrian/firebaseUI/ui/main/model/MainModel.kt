package com.adrian.firebaseUI.ui.main.model

import com.adrian.firebaseUI.data.ApiService

/**
 * Created by cadri on 2017. 08. 03..
 */

class MainModel constructor(val apiService: ApiService) {

    fun callApiService() {
        apiService.fakeApiCall()
    }

}