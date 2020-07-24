package br.com.souzabrunoj.architecturesample.di.module

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import br.com.souzabrunoj.architecturesample.ui.feature_a.home.view_model.FeatureAViewModel
import br.com.souzabrunoj.architecturesample.ui.feature_a.router.FeatureARouter
import br.com.souzabrunoj.architecturesample.ui.feature_b.home.view_model.FeatureBViewModel
import br.com.souzabrunoj.architecturesample.ui.feature_b.router.FeatureBRouter
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val presentationModules = module {
    factory { (activity: AppCompatActivity, navController: NavController) ->
        FeatureARouter(
            activity,
            navController
        )
    }
    factory { (activity: AppCompatActivity) -> FeatureBRouter(activity) }

    viewModel { (activity: AppCompatActivity) -> FeatureBViewModel(get { parametersOf(activity) }) }
    viewModel { (activity: AppCompatActivity, navController: NavController) ->
        FeatureAViewModel(get {
            parametersOf(
                activity,
                navController
            )
        })
    }
}
