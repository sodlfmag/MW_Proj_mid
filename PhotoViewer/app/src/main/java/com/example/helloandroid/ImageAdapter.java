package com.example.helloandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private List<PostData> postList;
    
    public ImageAdapter(List<PostData> postList) {
        // 생성자에서 포스트 목록 입력
        this.postList = postList;
    }
    
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 이미지 항목을 나타낼 뷰 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        // 해당 위치의 이미지를 뷰에 설정
        PostData post = postList.get(position);
        holder.imageView.setImageBitmap(post.getBitmap());
        
        // 클릭 리스너 추가
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ImageDetailActivity.class);
                // Bitmap 대신 URL과 메타데이터만 전달 (크기 제한 회피)
                intent.putExtra("imageUrl", post.getImageUrl());
                intent.putExtra("title", post.getTitle());
                intent.putExtra("text", post.getText());
                // Bitmap은 static 변수로 임시 저장 (메모리 상에 있으므로 재다운로드 불필요)
                ImageDetailActivity.setTempBitmap(post.getBitmap());
                v.getContext().startActivity(intent);
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return postList.size();
    }
    
    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        
        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewItem); // item_image.xml에 있는 ImageView
        }
    }
}

