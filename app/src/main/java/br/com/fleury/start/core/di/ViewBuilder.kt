package br.com.fleury.start.core.di

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.fleury.start.home.di.HomeComponent
import br.com.fleury.start.home.presentation.view.HomeActivity
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Module
abstract class ViewBuilder {

  @Binds
  @IntoMap
  @ActivityKey(HomeActivity::class)
  abstract fun bindHomeActivity(builder: HomeComponent.Builder): AndroidInjector.Factory<out Activity>

}