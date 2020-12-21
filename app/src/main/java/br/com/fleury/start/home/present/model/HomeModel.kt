package br.com.fleury.start.home.present.model

import android.arch.lifecycle.MutableLiveData
import br.com.fleury.start.core.api.IApi
import br.com.fleury.start.core.local.dao.UserDAO
import br.com.fleury.start.core.local.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection

class HomeModel(val api: IApi, val userDAO: UserDAO) : IHomeModel {

    override fun getData(): MutableLiveData<List<br.com.fleury.start.core.local.entity.User>> {
        val data = MutableLiveData<List<br.com.fleury.start.core.local.entity.User>>()

        val request = api.getUsers()
        GlobalScope.launch(Dispatchers.Main) {
            val response = request.await()
            when (response.code()) {
                HttpURLConnection.HTTP_OK -> data.value = response.body()
            }
            //Save API data into SQLite
            saveData(data.value)
        }

        return data
    }

    private fun saveData(list: List<User>?) {
        for (i in 0 until list!!.size){
            userDAO.save(list.get(i))
        }
    }
}