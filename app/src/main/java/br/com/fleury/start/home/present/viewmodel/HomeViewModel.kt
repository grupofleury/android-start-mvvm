package br.com.fleury.start.home.present.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import br.com.fleury.start.core.domain.User
import br.com.fleury.start.home.present.model.IHomeModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(val model: IHomeModel, app: Application) : AndroidViewModel(app) {

    fun getData(): MutableLiveData<List<User>> = model.getData()

}