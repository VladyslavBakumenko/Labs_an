package com.example.labs_an

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ApplicationDao {
    @Insert
    suspend fun insert(television: Application)

    @Query("SELECT * FROM tv_table")
    suspend fun getAllTelevisions(): List<Application>

    @Update
    suspend fun update(television: Application)

    @Delete
    suspend fun delete(television: Application)
}