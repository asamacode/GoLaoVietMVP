package com.asama.luong.golaovietmvp.ui.detail_word.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.asama.luong.golaovietmvp.R
import com.asama.luong.golaovietmvp.data.model.Mean
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.view.BaseActivity
import com.asama.luong.golaovietmvp.ui.detail_word.interactor.DetailMVPInteractor
import com.asama.luong.golaovietmvp.ui.detail_word.presenter.DetailPresenter
import com.asama.luong.golaovietmvp.util.AppConstants
import com.asama.luong.golaovietmvp.util.ToastUtil
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_word.*
import javax.inject.Inject

class DetailWordActivity : BaseActivity(), DetailWordMVPView {

    @Inject
    internal lateinit var mPresenter : DetailPresenter<DetailWordMVPView, DetailMVPInteractor>

    companion object {

        internal fun newIntent(context: Context, wordFull: WordFull) : Intent {
            val intent = Intent(context, DetailWordActivity::class.java)
            intent.putExtra(AppConstants.KEY_SEND_WORD, wordFull)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_word)

        mPresenter.onAttach(this)

        mPresenter.getWordFullData(intent)
    }

    override fun setWordData(wordFull: WordFull) {
        txtSearch.setText(wordFull.word)
        txtWord.text = wordFull.word
        txtSpell.text = "/${wordFull.spell}/"
        txtMean.text = wordFull.commonmean
        Glide.with(this).load(wordFull.image).into(imgw)
    }

    override fun setMeanData(mean: Mean) {
        for (i in 0 until mean.listType!!.size) {
            if (mean.listType!!.get(i).type.equals("1")) {
                container_1.setVisibility(View.VISIBLE)
                val list1 = mean.listType!!.get(i).meanList
                // do later
//                adapter = DetailWordAdapter(list1, this)
//                listn.adapter = adapter
            } else if (mean.listType!!.get(i).type.equals("2")) {
                container_2.setVisibility(View.VISIBLE)
                val list2 = mean.listType!!.get(i).meanList
//                adapter2 = DetailWordAdapter(list2, this)
//                listadj.adapter = adapter2
            } else if (mean.listType!!.get(i).type.equals("3")) {
                container_3.setVisibility(View.VISIBLE)
                val list3 = mean.listType!!.get(i).meanList
//                adapter3 = DetailWordAdapter(list3, this)
//                listv.adapter = adapter3
            }
        }
    }

    override fun handleError(throwable: Throwable) {
        ToastUtil.showToast(this, throwable.message)
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }
}
