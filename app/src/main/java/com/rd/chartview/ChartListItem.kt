package com.rd.chartview

/**
 * @author António Bastião (antonio.bastiao@igenius.ai) on 2020-02-28
 */
import android.view.View
import com.rd.chartview.view.ChartView
import com.rd.chartview.view.draw.data.InputData
import net.gotev.recycleradapter.AdapterItem
import net.gotev.recycleradapter.RecyclerAdapterViewHolder

/**
 * @author António Bastião (antonio.bastiao@igenius.ai) on 2020-02-28
 */
open class ChartListItem(private val model: ChartModel)
    : AdapterItem<ChartListItem.Holder>(model) {

    override fun getLayoutId() = R.layout.chart_item_layout


    override fun bind(firstTime: Boolean, holder: Holder) = with(holder) {
        charViewItem.setData(model.dataList)
    }

    class Holder(itemView: View)
        : RecyclerAdapterViewHolder(itemView) {
        internal val charViewItem by
        lazy { itemView.findViewById<ChartView>(R.id.charViewItem) }
    }
}


data class ChartModel(
        val dataList: List<InputData>
)