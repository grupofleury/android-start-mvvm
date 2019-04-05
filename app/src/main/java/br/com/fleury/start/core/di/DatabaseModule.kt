package br.com.fleury.start.core.di

import android.app.Application
import android.arch.persistence.room.Room
import br.com.fleury.start.core.api.Constants.databasename
import br.com.fleury.start.core.local.DatabaseStart
import br.com.fleury.start.core.local.dao.UserDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): DatabaseStart {
        return Room.databaseBuilder(
            application,
            DatabaseStart::class.java,
            databasename
        )
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideToken(database: DatabaseStart): UserDAO {
        return database.userDao()
    }
}

