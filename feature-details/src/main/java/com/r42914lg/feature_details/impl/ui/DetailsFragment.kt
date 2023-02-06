package com.r42914lg.feature_details.impl.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_details.databinding.ActivityDetailsBinding
import javax.inject.Inject

class DetailsFragment @Inject constructor(
    private val featureDetailsNavigationContract: FeatureDetailsNavigationContract,
): Fragment() {

    private var _binding: ActivityDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("FRAGMENT-2 >>> in fragment")

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                featureDetailsNavigationContract.goBackFromDetails()
                println("FRAGMENT-2 >>> getting back to parent activity")
            }
        })
    }
}