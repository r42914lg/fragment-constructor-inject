package com.r42914lg.feature_list.impl.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.feature_list.databinding.ActivityListBinding
import javax.inject.Inject

class ListFragment @Inject constructor(
    private val featureListNavigationContract: FeatureListNavigationContract,
) : Fragment() {

    private var _binding: ActivityListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)

        _binding = ActivityListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                featureListNavigationContract.goBackFromList()
            }
        })

        initUi()
        getListItems()
    }

    private fun initUi() {
        binding.feedRecycler.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
    }

    private fun getListItems() {
        println("FRAGMENT-1 >>> Navigating to fragment-2")
        featureListNavigationContract.nextAction()
    }
}