package com.mvp_clean.ny_times_articles.core.view.activities

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.kaopiz.kprogresshud.KProgressHUD
import com.mvp_clean.ny_times_articles.R
import com.mvp_clean.ny_times_articles.core.callback.IRetryCallBack
import com.mvp_clean.ny_times_articles.core.view.IBaseView


open class BaseActivity : AppCompatActivity(), IBaseView {


    private var progressDialog: KProgressHUD? = null

    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        try {
//            if (canBack()) {
//                if (item.itemId == android.R.id.home) {
//                    onBackPressed()
//                    return true
//                }
//            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun startServerApiErrorScreen(error: String?) {

        AlertDialog.Builder(this)
            .setTitle(getString(R.string.error))
            .setCancelable(false)
            .setMessage(error)
            .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                dialog.dismiss()
            }
            .show()
    }

    override fun isNetworkAvailable(context: Context?): Boolean {
        try {
            val connectivityManager =
                context!!.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                return activeNetworkInfo != null && activeNetworkInfo.isConnected
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return false
    }

    override fun startServerApiRetryScreen(error: String?, context: IRetryCallBack?) {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.error))
            .setCancelable(false)
            .setMessage(error)
            .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                dialog.dismiss()
            }
            .show()
    }

    override fun showProgress() {
        try {
            progressDialog = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("   " + getString(R.string.loading) + "   ")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun hideProgress() {
        try {
            if (progressDialog != null) {
                progressDialog!!.dismiss()
                progressDialog = null
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}