package com.example.formfgdmvvmproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.formfgdmvvmproject.model.AttendanceModel

class AttandanceViewModel : ViewModel() {

    private val  _attendanceData = MutableLiveData<AttendanceModel>()
    val attendanceData: LiveData<AttendanceModel> get() = _attendanceData

    //fungsi menyimpan data peserta
    fun setAttandanceData(model: AttendanceModel) {
        _attendanceData.value = model
    }
}