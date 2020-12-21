package br.com.fleury.start.home.present.model

import android.arch.lifecycle.MutableLiveData
import br.com.fleury.start.core.local.entity.User

interface IHomeModel {

    fun getData(): MutableLiveData<List<User>>
}