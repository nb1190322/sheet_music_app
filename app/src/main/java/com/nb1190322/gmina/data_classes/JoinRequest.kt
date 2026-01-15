package com.nb1190322.gmina.data_classes

data class JoinRequest(
    val endpointId: String,
    val musicianId: String,
    val musicianName: String,
    val instrument: String,
    val message: String?,
    val status: RequestStatus
)