package br.com.souzabrunoj.architecturesample.ui.feature_a.router

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import br.com.souzabrunoj.architecturesample.ui.feature_a.home.FeatureAHomeFragmentDirections
import br.com.souzabrunoj.architecturesample.ui.feature_b.FeatureBActivity

class FeatureARouter(private val activity: AppCompatActivity, private val navController: NavController) {

    fun openFeatureB(){
        activity.startActivity(Intent(activity, FeatureBActivity::class.java))
    }

    fun fromHomeToSecondScreen(){
        navController.navigate(FeatureAHomeFragmentDirections.actionFromHomeToSecondScreenFragment())
    }
}