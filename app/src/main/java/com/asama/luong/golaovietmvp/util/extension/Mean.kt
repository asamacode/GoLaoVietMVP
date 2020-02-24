package com.asama.luong.golaovietmvp.util.extension

import com.asama.luong.golaovietmvp.data.db.entity.ExampleEntity
import com.asama.luong.golaovietmvp.data.model.Example
import com.asama.luong.golaovietmvp.data.model.Mean
import com.asama.luong.golaovietmvp.data.model.MeanType

internal fun List<Mean>.toEntity(): List<ExampleEntity> {
    val listMeanEntity = ArrayList<ExampleEntity>()

    for (mean in this) {
        val example = ExampleEntity()
        example.word_id = mean.word!!
        for (listType in mean.listType!!) {
            example.type = listType.type

            for (ex in listType.meanList!!) {
                example.ex = ex.ex
                example.extran = ex.extran
                example.mean = ex.mean

                listMeanEntity.add(example)
            }
        }
    }
    return listMeanEntity
}

internal fun List<ExampleEntity>.toMean() : Mean{
    val mean = Mean()
    val examListN = ArrayList<Example>()
    val examListV = ArrayList<Example>()
    val examListA = ArrayList<Example>()
    val meanTypeList = ArrayList<MeanType>()

    for (example in this) {
        if (example.type == "1") {
            val exam = Example()
            exam.ex = example.ex
            exam.extran = example.extran
            exam.mean = example.mean
            examListN.add(exam)
        } else if (example.type == "2") {
            val exam = Example()
            exam.ex = example.ex
            exam.extran = example.extran
            exam.mean = example.mean
            examListV.add(exam)
        } else if (example.type == "3") {
            val exam = Example()
            exam.ex = example.ex
            exam.extran = example.extran
            exam.mean = example.mean
            examListA.add(exam)
        }
    }

    if (examListN.size > 0) {
        val meanType = MeanType()
        meanType.type = "1"
        meanType.meanList = examListN
        meanTypeList.add(meanType)
    }
    if (examListV.size > 0) {
        val meanType = MeanType()
        meanType.type = "2"
        meanType.meanList = examListV
        meanTypeList.add(meanType)
    }
    if (examListA.size > 0) {
        val meanType = MeanType()
        meanType.type = "3"
        meanType.meanList = examListA
        meanTypeList.add(meanType)
    }

    mean.word = this.get(0).word_id
    mean.listType = meanTypeList

    return mean
}