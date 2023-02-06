package com.r42914lg.feature_details.di

import com.r42914lg.feature_details.api.FeatureDetailsApi
import dagger.Component

@Component(
    modules = [FeatureDetailsStarterModule::class]
)
interface FeatureDetailsComponent : FeatureDetailsApi {

    @Component.Factory
    interface Factory {
        fun create(): FeatureDetailsComponent
    }

    companion object {
        fun initAndGet(): FeatureDetailsComponent {
            return DaggerFeatureDetailsComponent.factory().create()
        }
    }

}