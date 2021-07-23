package dev.goobar.androidstudyguidejuly21.studyguide

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi.Builder
import com.squareup.moshi.Types
import dev.goobar.androidstudyguidejuly21.R
import dev.goobar.androidstudyguidejuly21.R.layout
import dev.goobar.androidstudyguidejuly21.data.Topic
import org.json.JSONArray
import org.json.JSONException
import java.lang.reflect.Type

class StudyGuideFragment : Fragment() {

  private val adapter = StudyGuideListAdapter()

  private val topicListResponseListener = Response.Listener<JSONArray> {
    adapter.submitList(parseResponse(it))
  }

  private val topicListErrorListener = Response.ErrorListener { error ->
    Log.e(StudyGuideFragment::class.simpleName, error?.message ?: "error loading topics")
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(layout.fragment_study_guide, container, false)

    val list = view.findViewById<RecyclerView>(R.id.topicList)
    list.layoutManager = LinearLayoutManager(requireContext())
    list.adapter = adapter

    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val url = "https://raw.githubusercontent.com/goobar-dev/workshop-sample-data/main/android-study-guide-data.json"

    val jsonObjectRequest =  JsonArrayRequest(
      Request.Method.GET,
      url,
      null,
      topicListResponseListener,
      topicListErrorListener
    )

    Volley.newRequestQueue(requireContext()).add(jsonObjectRequest)
  }

  private fun parseResponse(response: JSONArray): List<Topic> {
    val moshi = Builder().build()
    val type: Type = Types.newParameterizedType(MutableList::class.java, Topic::class.java)
    val adapter: JsonAdapter<List<Topic>> = moshi.adapter(type)
    return adapter.fromJson(response.toString()) ?: throw JSONException("Could not parse Topic list")
  }
}