package br.com.souzabrunoj.architecturesample.ui.feature_a.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.souzabrunoj.architecturesample.R
import br.com.souzabrunoj.architecturesample.databinding.FragmentFeatureAHomeBinding
import br.com.souzabrunoj.architecturesample.ui.feature_a.home.view_model.FeatureAViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FeatureAHomeFragment : Fragment() {

    private val viewModel: FeatureAViewModel by viewModel { parametersOf(activity) }
    private lateinit var binding: FragmentFeatureAHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFeatureAHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.feature_a)
            setDisplayHomeAsUpEnabled(true)
        }

        binding.btOpenNewFeature.setOnClickListener { viewModel.openFeatureB() }
    }
}