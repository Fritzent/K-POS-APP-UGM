package com.example.k_pos.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.k_pos.R;

import java.util.List;

public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.OnboardingViewHolder>{

    private List<OnBoardingItem> onBoardingItems;

    public OnBoardingAdapter(List<OnBoardingItem> onBoardingItems) {
        this.onBoardingItems = onBoardingItems;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_onboarding, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnboardingData(onBoardingItems.get(position));

    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle;
        private TextView txtDescription;
        private ImageView imgOnBoarding;

        OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.textTitle);
            txtDescription = itemView.findViewById(R.id.textDescription);
            imgOnBoarding = itemView.findViewById(R.id.ImageOnBoarding);
        }

        void setOnboardingData(OnBoardingItem onBoardingItem){
            txtTitle.setText(onBoardingItem.getTitle());
            txtDescription.setText(onBoardingItem.getDescription());
            imgOnBoarding.setImageResource(onBoardingItem.getImg());
        }
    }
}
