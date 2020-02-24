package com.asama.luong.golaovietmvp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asama.luong.golaovietmvp.data.db.dao.ExampleDAO
import com.asama.luong.golaovietmvp.data.db.dao.WordFullDAO
import com.asama.luong.golaovietmvp.data.db.entity.ExampleEntity
import com.asama.luong.golaovietmvp.data.db.entity.WordFullEntity

@Database(entities = [(WordFullEntity::class), (ExampleEntity::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wordFullDao(): WordFullDAO

    abstract fun exampleDao(): ExampleDAO
}