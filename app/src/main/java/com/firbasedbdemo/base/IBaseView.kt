package com.firbasedbdemo.base

import com.firbasedbdemo.data.Error

interface IBaseView {

    /**
     * callback to reflect error to view
     *
     * @param error
     */
    fun onError(error: Error)


    /**
     * callback to reflect session expired
     *
     * @param msg
     */
    fun onInvalidSession(msg: String)

    /**
     * to show overlay progress loader
     */
    fun showLoader()

    /**
     * to hide overlay progress loader
     */
    fun hideLoader()
}