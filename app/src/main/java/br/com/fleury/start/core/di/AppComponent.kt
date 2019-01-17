package br.com.fleury.start.core.di

import android.app.Application
import br.com.fleury.start.core.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
          AndroidSupportInjectionModule::class,
          AppModule::class,
          NetworkModule::class,
          ViewBuilder::class
        ]
)
interface AppComponent {

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun application(application: Application): Builder

    fun build(): AppComponent

  }

  fun inject(app: App)
}