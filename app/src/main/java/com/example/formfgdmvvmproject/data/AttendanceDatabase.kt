package com.example.formfgdmvvmproject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.formfgdmvvmproject.model.AttendanceModel

@Database(entities=[AttendanceModel::class], version = 1, exportSchema = false)
abstract class AttendanceDatabase : RoomDatabase() {

    abstract fun attendanceDao(): AttendanceDao
}