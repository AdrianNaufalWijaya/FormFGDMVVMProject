package com.example.formfgdmvvmproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.formfgdmvvmproject.model.AttendanceModel
import com.example.formfgdmvvmproject.repository.AttendanceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AttandanceViewModel @Inject constructor(
    private val repository: AttendanceRepository
) : ViewModel() {

    private val  _attendanceData = MutableLiveData<AttendanceModel>()
    val attendanceData: LiveData<AttendanceModel> get() = _attendanceData

    val attendanceList = repository.getAll().asLiveData()

    //fungsi menyimpan data peserta
    fun setAttandanceData(model: AttendanceModel) {
       // _attendanceData.value = model
        viewModelScope.launch {
            repository.insert(model)
        }
    }
}