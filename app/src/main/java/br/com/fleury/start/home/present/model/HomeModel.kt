package br.com.fleury.start.home.present.model

import android.arch.lifecycle.MutableLiveData
import br.com.fleury.start.core.api.IApi
import br.com.fleury.start.core.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection

class HomeModel(val api: IApi) : IHomeModel {

    override fun getData(): MutableLiveData<List<User>> {
        val data = MutableLiveData<List<User>>()
        val request = api.getUsers()
        GlobalScope.launch(Dispatchers.Main) {
            val response = request.await()
            when (response.code()) {
                HttpURLConnection.HTTP_OK -> data.value = response.body()
            }
        }
        return data
    }


}