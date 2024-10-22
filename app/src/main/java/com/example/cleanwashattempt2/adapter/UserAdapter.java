package com.example.cleanwashattempt2.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cleanwashattempt2.R;
import com.example.cleanwashattempt2.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    Context context;
    List<User> list;
    Dialog dialog;

    public interface Dialog{
        void onclick(int pos);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public UserAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.row_user, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama.setText(list.get(position).getNama());
        holder.hp.setText(list.get(position).getHp());
        holder.cucian.setText(list.get(position).getCucian());
        holder.tglmasuk.setText(list.get(position).getTanggal());
        holder.berat.setText(list.get(position).getBerat());
        holder.harga.setText(list.get(position).getHarga());
        holder.status.setText(list.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nama, hp, cucian, tglmasuk, berat, harga, status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            hp = itemView.findViewById(R.id.hp);
            cucian = itemView.findViewById(R.id.cucian);
            tglmasuk = itemView.findViewById(R.id.tglmasuk);
            berat = itemView.findViewById(R.id.berat);
            harga = itemView.findViewById(R.id.harga);
            status = itemView.findViewById(R.id.status);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onclick(getLayoutPosition());
                    }
                }
            });
        }
    }
}
