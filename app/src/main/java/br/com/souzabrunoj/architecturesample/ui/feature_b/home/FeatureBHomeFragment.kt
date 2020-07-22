package br.com.souzabrunoj.architecturesample.ui.feature_b.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.souzabrunoj.architecturesample.databinding.FragmentFeatureBHomeBinding

class FeatureBHomeFragment : Fragment() {
    private lateinit var binding: FragmentFeatureBHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFeatureBHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}