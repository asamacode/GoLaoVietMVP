package com.asama.luong.golaovietmvp.ui.search_word.interactor

import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface SearchWordMVPInteractor: MVPInteractor {

    fun searchWordInDatabse(str: String) : Observable<List<WordFull>>
}