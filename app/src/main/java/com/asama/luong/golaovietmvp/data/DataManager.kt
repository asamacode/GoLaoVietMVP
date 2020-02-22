package com.asama.luong.golaovietmvp.data

import com.asama.luong.golaovietmvp.data.db.DbHelper
import com.asama.luong.golaovietmvp.data.preferences.PrefHelper

interface DataManager : DbHelper, PrefHelper {
}