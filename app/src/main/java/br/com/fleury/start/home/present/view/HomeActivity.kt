package br.com.fleury.start.home.present.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.fleury.start.R
import br.com.fleury.start.core.domain.User
import br.com.fleury.start.core.presentation.BaseActivity
import br.com.fleury.start.home.present.view.custom.UserAdapter
import br.com.fleury.start.home.present.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_activity.*
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        setUp()
        viewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
        showLoader()
    }

    fun setUp() {
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        viewModel.getData().observe(this, Observer {
            hideLoader()
            populate(it)
        })
    }

    fun populate(list: List<User>?) {
        list?.let {
            adapter.addItems(list)
            adapter.notifyDataSetChanged()
            recyclerView.adapter = adapter
        }
    }

}