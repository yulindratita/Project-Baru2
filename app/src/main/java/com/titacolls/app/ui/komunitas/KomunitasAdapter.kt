package com.titacolls.app.ui.komunitas

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.titacolls.app.R
import com.titacolls.app.data.model.Komunitas
import com.titacolls.app.databinding.ItemKomunitasBinding
import com.titacolls.app.ui.base.BaseAdapter

class KomunitasAdapter(val context: Context) : BaseAdapter<Komunitas>(R.layout.item_komunitas) {
    override fun onBind(binding: ViewDataBinding?, komunitas: Komunitas) {
        val mBinding = binding as ItemKomunitasBinding
        Glide.with(context).load(komunitas.poster).into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, komunitas: Komunitas) {
        val intent = Intent(context, KomunitasActivity::class.java)
        intent.putExtra(KomunitasActivity.OPEN_KOMUNITAS, komunitas)
        context.startActivity(intent)
    }
}