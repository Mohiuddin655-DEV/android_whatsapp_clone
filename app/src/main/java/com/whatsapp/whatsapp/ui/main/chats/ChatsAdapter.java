package com.whatsapp.whatsapp.ui.main.chats;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whatsapp.whatsapp.databinding.ItemChatUserBinding;
import com.whatsapp.whatsapp.model.Chat;

import java.util.List;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder> {

    private List<Chat> chats;

    @NonNull
    @Override
    public ChatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChatUserBinding binding = ItemChatUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ChatsViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ChatsViewHolder holder, int position) {
        //onLoad();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ChatsViewHolder extends RecyclerView.ViewHolder {

        public ChatsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
