package br.com.fleury.start.home.present.view.mapper

import br.com.fleury.start.core.local.entity.User

object UserMapper {

    fun map(user: User) = UserMapped(
        name = user.fullName,
        birthDate = user.birthDate
    )

}