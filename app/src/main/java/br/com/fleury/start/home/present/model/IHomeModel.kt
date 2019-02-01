package br.com.fleury.start.home.present.model

import android.arch.lifecycle.MutableLiveData
import br.com.fleury.start.core.domain.User
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface IHomeModel {

    fun getData(): MutableLiveData<List<User>>
}