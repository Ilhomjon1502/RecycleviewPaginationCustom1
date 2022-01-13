package uz.ilhomjon.recycleviewpagination.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.ilhomjon.recycleviewpagination.databinding.ItemDataBinding
import uz.ilhomjon.recycleviewpagination.databinding.ItemLoadingBinding
import uz.ilhomjon.recycleviewpagination.models.Data

class PaginationAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val LOADING = 0
    private val DATA = 1
    private var isLoadingAdded = true

    private val list: ArrayList<Data> = ArrayList()

    inner class LoadingVh(var itemRv: ItemLoadingBinding):RecyclerView.ViewHolder(itemRv.root){
        fun onBind(){
            itemRv.progressItem.visibility = View.VISIBLE
        }
    }

    inner class DataVH(var itemRv: ItemDataBinding):RecyclerView.ViewHolder(itemRv.root){
        fun onBind(data: Data){
            itemRv.apply {
                Picasso.get().load(data.avatar)
                tvName.text = "${data.last_name} ${data.first_name}"
                tvEmail.text = data.email
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == LOADING){
            return LoadingVh(ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }else{
            return DataVH(ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewType = getItemViewType(position)
        if (itemViewType == LOADING){
            val loadVh = holder as LoadingVh
            loadVh.onBind()
        }else{
            val data = holder as DataVH
            data.onBind(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return if(position == list.size-1 && isLoadingAdded) LOADING else DATA
    }

    fun addAll(otherList: List<Data>){
        list.addAll(otherList)
        notifyDataSetChanged()
    }

    fun editLoading() {
        isLoadingAdded = true
    }

    fun removeLoading() {
        isLoadingAdded = false
    }
}