package com.example.formfgdmvvmproject.repository

import com.example.formfgdmvvmproject.data.AttendanceDao
import com.example.formfgdmvvmproject.model.AttendanceModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AttendanceRepository @Inject constructor(private val attendanceDao: AttendanceDao) {

    suspend fun insert(attendance: AttendanceModel) = attendanceDao.insert(attendance)

    fun getAll():Flow<List<AttendanceModel>> = attendanceDao.getAll()
    }