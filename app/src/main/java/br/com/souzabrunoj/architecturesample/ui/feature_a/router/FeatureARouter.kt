package br.com.souzabrunoj.architecturesample.ui.feature_a.router

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.com.souzabrunoj.architecturesample.ui.feature_b.FeatureBActivity

class FeatureARouter(private val activity: AppCompatActivity) {

    fun openFeatureB(){
        activity.startActivity(Intent(activity, FeatureBActivity::class.java))
    }
}