package br.com.fleury.start.home.di

import br.com.fleury.start.home.present.view.custom.UserAdapter
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun providesUserAdapter(): UserAdapter = UserAdapter()

}