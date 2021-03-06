package com.mbmc.template.common.core.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mbmc.template.common.core.di.scope.CoreScope
import javax.inject.Inject
import javax.inject.Provider

// https://github.com/googlesamples/android-architecture-components/blob/master/GithubBrowserSample
// /app/src/main/java/com/android/example/github/viewmodel/GithubViewModelFactory.kt
@CoreScope
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}