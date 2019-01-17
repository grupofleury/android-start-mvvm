package br.com.fleury.start.core.di

import android.app.Application
import android.content.Context
import br.com.fleury.start.home.di.HomeComponent
import dagger.Module
import dagger.Provides

@Module(
  subcomponents = [
    HomeComponent::class
  ]
)
class AppModule {

  @Provides
  fun providesAppContext(applicat: Application): Context = applicat.applicationContext

}