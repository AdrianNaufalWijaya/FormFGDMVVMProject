package com.example.formfgdmvvmproject.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.formfgdmvvmproject.model.AttendanceModel
import kotlinx.coroutines.flow.Flow


@Dao
interface AttendanceDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(attendance: AttendanceModel)

    @Query("SELECT * FROM attendance")
    fun getAll(): Flow<List<AttendanceModel>>
}