package br.com.fleury.start.core.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import br.com.fleury.start.core.local.converter.DateConverter
import br.com.fleury.start.core.local.dao.UserDAO
import br.com.fleury.start.core.local.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class DatabaseStart: RoomDatabase(){

    abstract fun userDao(): UserDAO

    companion object {
        val INSTANCE: DatabaseStart? = null
    }
}