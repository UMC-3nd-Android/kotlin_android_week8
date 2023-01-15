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
        //val sharedPrefs = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        //val editor = sharedPrefs.edit()

        val roomDb = AppDatabase!!.getInstance(context)

        fun bind(data: Memo) {
            viewBinding.memoTitle.text = data.title
            viewBinding.memoContent.text = data.content
            viewBinding.favorite.isChecked = roomDb?.memoDao()?.selectByTitle(data.title)!!.on
            // viewBinding.favorite.isChecked = sharedPrefs.getBoolean(data.title, false)

            viewBinding.favorite.setOnCheckedChangeListener { _, isChecked ->
                val selectedMemo = roomDb?.memoDao()?.selectByTitle(data.title)
                roomDb?.memoDao()?.updateFavoriteByMemoIdx(
                    !selectedMemo!!.on, selectedMemo.memoIdx
                )
                /*
                if (isChecked) {
                    //editor.putBoolean(data.title, true)
                    Log.d("check", "favorite update")
                }
                    editor.remove(data.title)
                    Log.d("check", "mySharedPrefs isn't saved or deleted!")
                }
                editor.apply() */
            }
        }
    }

    // ViewHolder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoDataRVAdapter.DataViewHolder {
        val viewBinding = ItemMemoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    // ViewHolder 가 실제로 데이터를 표시해야할 때 호출
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])

        holder.itemView.setOnClickListener(){
            mItemClickListener.onRemoveMemo(position)
        }
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
        dataList.add(Memo(title, content, false))
        notifyItemInserted(dataList.size)
        notifyItemRangeChanged(dataList.size, getItemCount());
    }
}