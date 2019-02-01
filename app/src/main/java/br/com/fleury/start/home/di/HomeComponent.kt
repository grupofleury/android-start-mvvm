package br.com.fleury.start.home.di

import br.com.fleury.start.home.present.view.HomeActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [
  HomeModule::class
])
interface HomeComponent : AndroidInjector<HomeActivity> {

  @Subcomponent.Builder
  abstract class Builder() : AndroidInjector.Builder<HomeActivity>()

}