package com.example.kotlin_android_week8

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_android_week8.databinding.ItemMemoListBinding

class MemoDataRVAdapter(private val context: Context, private val dataList:MutableList<Memo>): RecyclerView.Adapter<MemoDataRVAdapter.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemMemoListBinding) : RecyclerView.ViewHolder(viewBinding.root){
        val sharedPrefs = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()

        fun bind(data: Memo) {
            viewBinding.memoTitle.text = data.title
            viewBinding.memoContent.text = data.content
            viewBinding.favorite.isChecked = sharedPrefs.getBoolean(data.title, false)

            viewBinding.favorite.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    editor.putBoolean(data.title, true)
                    Log.d("check", "mySharedPrefs is saved")
                }
                else {
                    editor.remove(data.title)
                    Log.d("check", "mySharedPrefs isn't saved")
                }
                editor.apply()
            }
        }
    }

    // ViewHolder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemMemoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    // ViewHolder 가 실제로 데이터를 표시해야할 때 호출
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.itemView

    }

    // 표한할 item 의 총 개수
    override fun getItemCount(): Int = dataList.size

    interface MyItemClickListener{
        fun onItemClick(memo : Memo)
        fun onRemoveMemo(position: Int)
    }

    private lateinit var mItemClickListener: MemoDataRVAdapter.MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MemoDataRVAdapter.MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    fun removeItem(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, getItemCount());
    }

    fun addItem(title:String, content:String){
        dataList.add(Memo(title, content))
        notifyItemInserted(dataList.size)
        notifyItemRangeChanged(dataList.size, getItemCount());
    }
}