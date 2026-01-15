package com.nb1190322.gmina.ui.adapters

import android.view.LayoutInflater
import android.view.View
import com.nb1190322.gmina.R
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.nb1190322.gmina.data_classes.JoinRequest

class JoinRequestAdapter(
    private val requests: MutableList<JoinRequest>,
    private val onAccept: (JoinRequest) -> Unit,
    private val onDecline: (JoinRequest) -> Unit
) : RecyclerView.Adapter<JoinRequestAdapter.JoinRequestViewHolder>() {
    class JoinRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textMusicianName)
        val textInstrument: TextView = itemView.findViewById(R.id.textInstrument)
        val textMessage: TextView = itemView.findViewById(R.id.textMessage)
        val btnAccept: MaterialButton = itemView.findViewById(R.id.btnAccept)
        val btnDecline: MaterialButton = itemView.findViewById(R.id.btnDecline)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JoinRequestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_join_request, parent, false)
        return JoinRequestViewHolder(view)
    }

    override fun onBindViewHolder(holder: JoinRequestViewHolder, position: Int) {
        val request = requests[position]
        holder.textName.text = request.musicianName
        holder.textInstrument.text = "Instrument: ${request.instrument}"

        if (request.message.isNullOrBlank()) {
            holder.textMessage.visibility = View.GONE
        } else {
            holder.textMessage.visibility = View.VISIBLE
            holder.textMessage.text = request.message
        }

        val isPending = request.status.name == "PENDING"
        holder.btnAccept.isEnabled = isPending
        holder.btnDecline.isEnabled = isPending

        holder.btnAccept.setOnClickListener {
            onAccept(request)
            removeRequest(position)
        }

        holder.btnDecline.setOnClickListener {
            onDecline(request)
            removeRequest(position)
        }
    }

    override fun getItemCount(): Int = requests.size

    private fun removeRequest(position: Int) {
        requests.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateRequests(newRequests: List<JoinRequest>) {
        requests.clear()
        requests.addAll(newRequests)
        notifyDataSetChanged()
    }
}