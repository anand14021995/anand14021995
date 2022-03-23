package com.alo.eparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alo.eparts.recycler.notificationActivity;

public class oem_activityfilterall extends AppCompatActivity {

    ImageView backIconImageView,propic;
    LinearLayout itemclick ,cart;
    Button viewproducts;
    private Animator mCurrentAnimatorEffect;
    private int mShortAnimationDurationEffect;
    RecyclerView viewproductsdet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oem_activityfilterall);
        backIconImageView = findViewById(R.id.backIconImageView);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
//        Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
//        imageView.startAnimation(zoomAnimation);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomImageFromThumb(imageView, R.drawable.carsevron);
            }
        });
        mShortAnimationDurationEffect = getResources().getInteger(android.R.integer.config_shortAnimTime);
        MyViewListData[] MyViewListData = new MyViewListData[] {
                new MyViewListData("Roof combination aerial",R.drawable.carsevron),
                new MyViewListData("Primed",R.drawable.carsevron),

        };
        viewproductsdet = (RecyclerView)findViewById(R.id.viewproductsdet);
        MyViewListAdapter adapter = new MyViewListAdapter(MyViewListData);

        viewproductsdet.setLayoutManager(new LinearLayoutManager(this));
        viewproductsdet.setAdapter(adapter);
        propic = findViewById(R.id.propic);
        //notification clicked
        propic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_activityfilterall.this, notificationActivity.class);
                startActivity(intent);
            }
        });
        //backicon Clicked
        backIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_activityfilterall.this, navigationbar.class);
                startActivity(intent);
            }
        });
        //MyorderClicked

        itemclick = findViewById(R.id.itemclick);
        itemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oem_activityfilterall.this, myOrdersActivity.class);
                startActivity(intent);
            }
        });

//        viewproducts = findViewById(R.id.viewproducts);
//        viewproducts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(oem_activityfilterall.this, BuypartsOrder.class);
//                startActivity(intent);
//            }
//        });
    }
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void zoomImageFromThumb(final View thumbView, int imageResId) {
        if (mCurrentAnimatorEffect != null) {
            mCurrentAnimatorEffect.cancel();
        }

        final ImageView expandedImageView = (ImageView) findViewById(
                R.id.expanded_image);
        expandedImageView.setImageResource(imageResId);

        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.container)
                .getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        thumbView.setAlpha(0f);
        expandedImageView.setVisibility(View.VISIBLE);

        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(expandedImageView, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X,
                        startScale, 1f)).with(ObjectAnimator.ofFloat(expandedImageView,
                View.SCALE_Y, startScale, 1f));
        set.setDuration(mShortAnimationDurationEffect);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimatorEffect = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimatorEffect = null;
            }
        });
        set.start();
        mCurrentAnimatorEffect = set;

        final float startScaleFinal = startScale;
        expandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimatorEffect != null) {
                    mCurrentAnimatorEffect.cancel();
                }

                // back to their original values.
                AnimatorSet set = new AnimatorSet();
                set.play(ObjectAnimator
                        .ofFloat(expandedImageView, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.Y,startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_Y, startScaleFinal));
                set.setDuration(mShortAnimationDurationEffect);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimatorEffect = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimatorEffect = null;
                    }
                });
                set.start();
                mCurrentAnimatorEffect = set;
            }
        });
    }
}