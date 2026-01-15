package com.nb1190322.gmina.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nb1190322.gmina.data_classes.JoinRequest
import com.nb1190322.gmina.data_classes.RequestStatus
import com.nb1190322.gmina.databinding.ActivityRehearsalLobbyBinding
import com.nb1190322.gmina.ui.adapters.JoinRequestAdapter
import com.nb1190322.gmina.view_models.RehearsalLobbyViewModel
import androidx.activity.viewModels

class RehearsalLobbyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRehearsalLobbyBinding
    private lateinit var joinRequestAdapter: JoinRequestAdapter

    private val viewModel: RehearsalLobbyViewModel by viewModels()

    private val tempMusicians = mutableListOf(
        JoinRequest("1", "1", "Nathan Beckman", "Percussion", "LET ME IN", RequestStatus.PENDING),
        JoinRequest("2", "2", "Allie Gray", "Flute", "HEYYYYYY", RequestStatus.PENDING)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRehearsalLobbyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupJoinRequestRecycler()
    }

    private fun setupJoinRequestRecycler() {
        joinRequestAdapter = JoinRequestAdapter(
            requests = tempMusicians,
            onAccept = { request -> viewModel.acceptRequest(request) },
            onDecline = { request -> viewModel.declineRequest(request) }
        )

        binding.recyclerJoinRequests.apply {
            adapter = joinRequestAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.joinRequests.observe(this) { list ->
            joinRequestAdapter.updateRequests(list)
        }
    }
}