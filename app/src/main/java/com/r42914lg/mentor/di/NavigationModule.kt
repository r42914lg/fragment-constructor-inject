package com.r42914lg.mentor.di

import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.mentor.ActivityNavigationContract
import com.r42914lg.mentor.ActivityNavigationImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindFeatureListNavigationApi(navigationImpl: ActivityNavigationImpl): FeatureListNavigationContract

    @Binds
    fun bindFeatureDetailsNavigationApi(navigationImpl: ActivityNavigationImpl): FeatureDetailsNavigationContract

    @Binds
    fun bindAppNavigationApi(navigationImpl: ActivityNavigationImpl): ActivityNavigationContract

}