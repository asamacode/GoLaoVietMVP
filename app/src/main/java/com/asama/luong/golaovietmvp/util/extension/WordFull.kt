package com.asama.luong.golaovietmvp.util.extension

import com.asama.luong.golaovietmvp.data.db.entity.WordFullEntity
import com.asama.luong.golaovietmvp.data.model.WordFull

internal fun WordFull.toEntity() : WordFullEntity {
    return WordFullEntity(this.word!!, this.commonmean, this.image, this.spell)
}

internal fun WordFullEntity.toWordFull() : WordFull {
    return WordFull(this.word, this.commonMean, this.image, this.spell)
}
