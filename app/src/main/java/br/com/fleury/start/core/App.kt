package br.com.fleury.start.core

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import br.com.fleury.start.core.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasActivityInjector, HasSupportFragmentInjector {

  @Inject
  lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

  @Inject
  lateinit var fragmentDIsptachingAndroidInjector: DispatchingAndroidInjector<Fragment>

  override fun onCreate() {
    super.onCreate()
    initDependecyInjection()
    initLogger()
  }

  private fun initDependecyInjection() {
        val appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
        appComponent.inject(this)
  }

  private fun initLogger() {
    Timber.plant(Timber.DebugTree())
  }

  override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDIsptachingAndroidInjector

  override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

}