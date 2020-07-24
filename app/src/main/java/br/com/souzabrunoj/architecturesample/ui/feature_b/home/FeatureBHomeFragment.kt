package br.com.souzabrunoj.architecturesample.ui.feature_b.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.souzabrunoj.architecturesample.R
import br.com.souzabrunoj.architecturesample.databinding.FragmentFeatureBHomeBinding
import br.com.souzabrunoj.architecturesample.extension.observeEvent
import br.com.souzabrunoj.architecturesample.ui.feature_b.home.view_model.FeatureBViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FeatureBHomeFragment : Fragment() {

    private val viewModel: FeatureBViewModel by viewModel { parametersOf(activity) }
    private lateinit var binding: FragmentFeatureBHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeatureBHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.feature_b)
            setDisplayHomeAsUpEnabled(true)
        }


        binding.btOpenNewFeature.setOnClickListener { viewModel.openFeatureA() }

        start()
        setupViewState()
    }

    private fun start() {
        viewModel.getGlobalData()
    }

    private fun setupViewState() {
        viewModel.globalDateState.observeEvent(this,
            onSuccess = {
                binding.tvNewConfirmed.text = requireContext().getString(R.string.new_world_cases, it.getNewConfirmedInStringFormat())
            },
            onError = {
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            })
    }
}