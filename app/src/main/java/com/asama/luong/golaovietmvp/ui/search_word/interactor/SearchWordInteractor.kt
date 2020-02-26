package com.asama.luong.golaovietmvp.ui.search_word.interactor

import com.asama.luong.golaovietmvp.data.DataManager
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class SearchWordInteractor @Inject constructor(
    private val dataManager: DataManager
) : SearchWordMVPInteractor, BaseInteractor(dataManager) {

    override fun searchWordInDatabse(str: String): Observable<List<WordFull>> {
        return dataManager.searchWord(str)
    }

}