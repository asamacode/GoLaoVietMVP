package com.asama.luong.golaovietmvp.ui.detail_word.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
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

    @Inject
    internal lateinit var mLayoutManagerNoun: LinearLayoutManager

    @Inject
    internal lateinit var mLayoutManagerVerb: LinearLayoutManager

    @Inject
    internal lateinit var mLayoutManagerAdj: LinearLayoutManager

    @Inject
    internal lateinit var mAdapterNoun: ExampleAdapter

    @Inject
    internal lateinit var mAdapterVerb: ExampleAdapter

    @Inject
    internal lateinit var mAdapterAdj: ExampleAdapter

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

        setUpListExample()

        mPresenter.onAttach(this)

        mPresenter.getWordFullData(intent)
    }

    override fun setUp() {

    }

    private fun setUpListExample() {
        listn.layoutManager = mLayoutManagerNoun
        listn.hasFixedSize()

        listadj.layoutManager = mLayoutManagerAdj
        listadj.hasFixedSize()

        listv.layoutManager = mLayoutManagerVerb
        listv.hasFixedSize()
    }

    override fun setWordData(wordFull: WordFull) {
        txtSearch.setText(wordFull.word)
        txtWord.text = wordFull.word
        txtSpell.text = "/${wordFull.spell}/"
        txtMean.text = wordFull.commonmean

        if (!TextUtils.isEmpty(wordFull.image))
            Glide.with(this).load(wordFull.image).into(imgw)

        // then call get mean
        mPresenter.getMeanData(wordFull.word!!)
    }

    override fun setMeanData(mean: Mean) {
        for (i in 0 until mean.listType!!.size) {
            if (mean.listType!!.get(i).type.equals("1")) {
                container_1.setVisibility(View.VISIBLE)
                val list1 = mean.listType!!.get(i).meanList

                mAdapterNoun.addToExampleList(list1!!)
                listn.adapter = mAdapterNoun
            } else if (mean.listType!!.get(i).type.equals("2")) {
                container_2.setVisibility(View.VISIBLE)
                val list2 = mean.listType!!.get(i).meanList

                mAdapterAdj.addToExampleList(list2!!)
                listadj.adapter = mAdapterAdj
            } else if (mean.listType!!.get(i).type.equals("3")) {
                container_3.setVisibility(View.VISIBLE)
                val list3 = mean.listType!!.get(i).meanList

                mAdapterVerb.addToExampleList(list3!!)
                listv.adapter = mAdapterVerb
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
