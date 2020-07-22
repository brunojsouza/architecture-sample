package br.com.souzabrunoj.architecturesample.ui.feature_a.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.souzabrunoj.architecturesample.databinding.FragmentFeatureAHomeBinding

class FeatureAHomeFragment : Fragment() {

    private lateinit var binding: FragmentFeatureAHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFeatureAHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}