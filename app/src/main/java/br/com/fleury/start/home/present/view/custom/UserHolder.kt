package br.com.fleury.start.home.present.view.custom

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import br.com.fleury.start.R
import br.com.fleury.start.core.domain.User
import br.com.fleury.start.home.present.view.mapper.UserMapped
import org.jetbrains.anko.find

class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name = itemView.find<TextView>(R.id.name)
    val birth = itemView.find<TextView>(R.id.birth)

    fun bind(user: UserMapped) {
        name.text = user.name
        birth.text = user.birthDate
    }

}