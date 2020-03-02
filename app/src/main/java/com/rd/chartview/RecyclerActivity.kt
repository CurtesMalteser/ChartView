package com.rd.chartview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rd.chartview.view.draw.data.InputData
import kotlinx.android.synthetic.main.activity_recycler.*
import net.gotev.recycleradapter.RecyclerAdapter
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)


        val lManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = RecyclerAdapter()

        rv.layoutManager = lManager
        rv.adapter = adapter

        val listItem = mutableListOf<ChartListItem>()

        for (i in 1..30) {
            listItem.add(
                    ChartListItem(
                            ChartModel(
                                    createChartData()
                            )
                    )
            )
        }

        listItem.map {
            adapter.add(it)
        }

        adapter.notifyDataSetChanged()

    }


    private fun createChartData(): List<InputData> {
        val dataList: MutableList<InputData> = ArrayList()

        for (i in 1..7) {
            dataList.add(InputData(random))
        }

        var currMillis = System.currentTimeMillis()
        currMillis -= currMillis % TimeUnit.DAYS.toMillis(1)

        for (i in dataList.indices) {
            val position = dataList.size - 1 - i.toLong()
            val offsetMillis = TimeUnit.DAYS.toMillis(position)
            val millis = currMillis - offsetMillis
            dataList[i].millis = millis
        }

        return dataList
    }

    private val random: Int
        get() = Random.nextInt(0, 50)
}
