package com.asama.luong.golaovietmvp.ui.detail_word.interactor

import android.content.Intent
import com.asama.luong.golaovietmvp.data.DataManager
import com.asama.luong.golaovietmvp.data.model.Mean
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.interactor.BaseInteractor
import com.asama.luong.golaovietmvp.util.AppConstants
import io.reactivex.Observable
import javax.inject.Inject

class DetailWordInteractor @Inject constructor(
    private val dataManager: DataManager
) : DetailMVPInteractor, BaseInteractor(dataManager) {


    override fun getWordData(intent: Intent): WordFull {
        var wordFull = WordFull()
        if (intent.extras != null) {
            wordFull = intent.getSerializableExtra(AppConstants.KEY_SEND_WORD) as WordFull
            return wordFull
        }
        return wordFull
    }

    override fun getMeanByWord(word: String): Observable<Mean> {
        return dataManager.getMeanWordByWordId(word)
    }
}