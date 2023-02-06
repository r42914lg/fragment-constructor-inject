package com.r42914lg.feature_details.di

import com.r42914lg.feature_details.api.FeatureDetailsStarter
import com.r42914lg.feature_details.impl.start.FeatureDetailsStarterImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class FeatureDetailsStarterModule {

    @Binds
    abstract fun bindFeatureListStarter(
        featureDetailsStarterImpl: FeatureDetailsStarterImpl): FeatureDetailsStarter

}