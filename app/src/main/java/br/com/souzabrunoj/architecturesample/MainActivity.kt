package br.com.souzabrunoj.architecturesample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.souzabrunoj.architecturesample.databinding.ActivityMainBinding
import br.com.souzabrunoj.architecturesample.ui.feature_a.FeatureAActivity
import br.com.souzabrunoj.architecturesample.ui.feature_b.FeatureBActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tiTextInputError.showError()

        binding.btFeatureA.setOnClickListener { startActivity(Intent(this, FeatureAActivity::class.java)) }
        binding.btFeatureB.setOnClickListener { startActivity(Intent(this, FeatureBActivity::class.java)) }
    }
}