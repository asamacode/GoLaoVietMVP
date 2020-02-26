package com.asama.luong.golaovietmvp.ui.detail_word.interactor

import android.content.Intent
import com.asama.luong.golaovietmvp.data.model.Mean
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface DetailMVPInteractor: MVPInteractor {

    fun getWordData(intent: Intent) : WordFull

    fun getMeanByWord(word: String) : Observable<Mean>
}