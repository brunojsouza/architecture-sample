package br.com.souzabrunoj.architecturesample.ui.feature_b.router

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.com.souzabrunoj.architecturesample.ui.feature_a.FeatureAActivity

class FeatureBRouter(private val activity: AppCompatActivity) {

    fun openFeatureA(){
        activity.startActivity(Intent(activity, FeatureAActivity::class.java))
    }
}