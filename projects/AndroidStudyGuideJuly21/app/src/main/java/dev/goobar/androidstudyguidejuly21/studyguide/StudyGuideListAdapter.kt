package dev.goobar.androidstudyguidejuly21.studyguide

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.goobar.androidstudyguidejuly21.R
import dev.goobar.androidstudyguidejuly21.data.Topic

class TopicViewHolder(view: View) : RecyclerView.ViewHolder(view) {

  val title: TextView = view.findViewById(R.id.topicTitle)
  val content: TextView = view.findViewById(R.id.topicContent)

  fun bindTopic(topic: Topic) {
    title.text = topic.title
    content.text = topic.content
  }
}

object TopicDiffUtil : DiffUtil.ItemCallback<Topic>() {
  override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
    return oldItem == newItem
  }

  override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
    return oldItem == newItem
  }
}

class StudyGuideListAdapter : ListAdapter<Topic, TopicViewHolder>(TopicDiffUtil) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
    return TopicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_topic, parent, false))
  }

  override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
    val topic = getItem(position)
    holder.bindTopic(topic)
  }
}