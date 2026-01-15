package com.nb1190322.gmina.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nb1190322.gmina.data_classes.JoinRequest
import com.nb1190322.gmina.data_classes.RequestStatus
import com.nb1190322.gmina.data_classes.SessionStatus

class RehearsalLobbyViewModel : ViewModel() {
    private val _sessionStatus = MutableLiveData<SessionStatus>(SessionStatus.IDLE)
    val sessionStatus: LiveData<SessionStatus> = _sessionStatus

    private val _joinRequests = MutableLiveData<MutableList<JoinRequest>>(mutableListOf())
    val joinRequests: LiveData<MutableList<JoinRequest>> = _joinRequests

    fun addJoinRequest(request: JoinRequest) {
        _joinRequests.value?.add(request)
        _joinRequests.value = _joinRequests.value
    }

    fun acceptRequest(request: JoinRequest) {
        updateRequestStatus(request, RequestStatus.ACCEPTED)
    }

    fun declineRequest(request: JoinRequest) {
        updateRequestStatus(request, RequestStatus.DECLINED)
    }

    private fun updateRequestStatus(request: JoinRequest, status: RequestStatus) {
        _joinRequests.value = _joinRequests.value?.map {
            if (it.endpointId == request.endpointId) it.copy(status = status) else it
        }?.toMutableList()
    }

    fun startSession() {
        _sessionStatus.value = SessionStatus.LOBBY
        // TODO: Trigger advertisement / notify musicians
    }

    fun startPerformance() {
        // TODO: Lock joins and enter song views
    }
}