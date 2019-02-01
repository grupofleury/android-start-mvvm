package br.com.fleury.start.home.present.view.custom

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.fleury.start.R
import br.com.fleury.start.core.domain.User
import br.com.fleury.start.home.present.view.mapper.UserMapper

class UserAdapter : RecyclerView.Adapter<UserHolder>() {

    private var list = ArrayList<User>()

    fun addItems(items: List<User>) {
        list = items as ArrayList<User>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder = UserHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.user_adapter, parent, false
        )
    )

    override fun getItemCount() = list.count()

    override fun onBindViewHolder(holder: UserHolder, position: Int) = holder.bind(UserMapper.map(list[position]))

}