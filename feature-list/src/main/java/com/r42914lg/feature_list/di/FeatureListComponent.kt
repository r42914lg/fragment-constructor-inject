package com.r42914lg.feature_list.di

import com.r42914lg.feature_list.api.FeatureListApi
import dagger.Component

@Component(
    modules = [FeatureListStarterModule::class]
)
interface FeatureListComponent : FeatureListApi {

    @Component.Factory
    interface Factory {
        fun create(): FeatureListComponent
    }

    companion object {
        fun initAndGet(): FeatureListComponent {
            return DaggerFeatureListComponent.factory().create()
        }
    }

}