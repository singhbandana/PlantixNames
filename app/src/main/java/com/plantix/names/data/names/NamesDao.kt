package com.plantix.names.data.names

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NamesDao {
    @Query("SELECT * FROM Names")
    fun getNames(): LiveData<List<Names>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(videos: List<Names>)
}