package com.asama.luong.golaovietmvp.ui.search_word.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.asama.luong.golaovietmvp.R
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.view.BaseActivity
import com.asama.luong.golaovietmvp.ui.search_word.interactor.SearchWordInteractor
import com.asama.luong.golaovietmvp.ui.search_word.presenter.SearchWordPresenter
import com.asama.luong.golaovietmvp.util.ToastUtil
import com.asama.luong.golaovietmvp.util.custom.DelayTextWatcher
import kotlinx.android.synthetic.main.activity_search_word.*
import javax.inject.Inject

class SearchWordActivity : BaseActivity(), SearchWordMVPView {

    @Inject
    internal lateinit var mPresenter: SearchWordPresenter<SearchWordMVPView, SearchWordInteractor>

    @Inject
    internal lateinit var mAdapterSearch: SearchWordAdapter

    @Inject
    internal lateinit var mLinearLayoutManager: LinearLayoutManager

    companion object {

        internal fun newIntent(context: Context): Intent {
            val intent = Intent(context, SearchWordActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_word)

        mPresenter.onAttach(this)
        setUp()
    }

    override fun setUp() {
        //list result word
        listSearch.layoutManager = mLinearLayoutManager
        listSearch.hasFixedSize()

        //edittext search
        edtSearch.addTextChangedListener(DelayTextWatcher(textChanged = {
            if (!TextUtils.isEmpty(it))
                mPresenter.searchWord(it) else
                showLoadingSearch()
        }))
    }

    override fun setWordSearchData(listWord: List<WordFull>) {
        mAdapterSearch.addWordToList(listWord)
        listSearch.adapter = mAdapterSearch
    }

    override fun showLoadingSearch() {
        progressBar.visibility = View.VISIBLE
        listSearch.visibility = View.GONE
    }

    override fun hideLoadingSearch() {
        progressBar.visibility = View.GONE
        listSearch.visibility = View.VISIBLE
    }

    override fun handleError(throwable: Throwable) {
        ToastUtil.showToast(this, throwable.message)
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

}
