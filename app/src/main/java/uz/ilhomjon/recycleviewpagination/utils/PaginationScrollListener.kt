package uz.ilhomjon.recycleviewpagination.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationScrollListener(var linearLayoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener(){

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = linearLayoutManager.childCount
        val totalItemCount = linearLayoutManager.itemCount
        val firsVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition()

        if (!isLoading() && !isLastPage()){
            if (visibleItemCount + firsVisiblePosition >= totalItemCount && firsVisiblePosition>=0){
                loadMoreItems()
            }
        }
    }

    abstract fun loadMoreItems()
    abstract fun isLastPage():Boolean
    abstract fun isLoading():Boolean

}