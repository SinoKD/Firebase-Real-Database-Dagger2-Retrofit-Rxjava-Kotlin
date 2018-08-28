package com.firbasedbdemo.base

import android.util.Log
import com.firbasedbdemo.data.Error
import com.firbasedbdemo.ui.components.LoaderDialogFragment
import dagger.android.support.DaggerAppCompatActivity


/**
 * @author Sino K D
 * @since 8/22/18.
 */
abstract class BaseActivity : DaggerAppCompatActivity(), IBaseView {

    private var mLoaderDialogFragment: LoaderDialogFragment? = null

    override fun onError(error: Error) {
        Log.d("Error", error.message)
    }

    override fun onInvalidSession(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoader() {
        if (mLoaderDialogFragment == null) this.mLoaderDialogFragment = LoaderDialogFragment()
        mLoaderDialogFragment!!.show(getSupportFragmentManager(), "Loader")
    }

    override fun hideLoader() {

        if (mLoaderDialogFragment != null && mLoaderDialogFragment!!.isVisible()) {
            mLoaderDialogFragment!!.dismiss()
        }
    }
}