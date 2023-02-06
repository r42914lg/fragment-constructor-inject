package com.r42914lg.mentor

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.r42914lg.feature_details.api.FeatureDetailsApi
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_list.api.FeatureListApi
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import javax.inject.Inject

class ActivityNavigationImpl @Inject constructor(
    private val activity: Activity,
    private val fragmentManager: FragmentManager,
    private val featureDetailsApi: FeatureDetailsApi,
    private val featureListApi: FeatureListApi,
) : ActivityNavigationContract, FeatureListNavigationContract, FeatureDetailsNavigationContract {

    override fun startApp() {
        openList()
    }

    override fun goBackFromDetails() {
        openList()
    }

    override fun goBackFromList() {
        activity.finish()
    }

    override fun nextAction() {
        featureDetailsApi.featureDetailsStarter()
            .start(fragmentManager, R.id.fragment_container)
    }

    private fun openList() {
        featureListApi.featureListStarter()
            .start(fragmentManager, R.id.fragment_container)
    }
}