package com.test.effectcollection;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.TextView;

import com.test.swipactivity.SwipeBackExample;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SpannableStringActitity extends AppCompatActivity {

    @Bind(R.id.qiandao)
    TextView qiandao;
    @Bind(R.id.url)
    TextView url;
    @Bind(R.id.background)
    TextView background;
    @Bind(R.id.genhao)
    TextView genhao;
    @Bind(R.id.yuanjia)
    TextView yuanjia;
    @Bind(R.id.animator)
    TextView animator;
    int loc=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_string);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //设置前景色
        SpannableString spannableString = new SpannableString("共累计完成签到24次");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0079E6"));
        spannableString.setSpan(colorSpan, 7, spannableString.length()-1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        qiandao.setText(spannableString);

        //添加网页
        SpannableString spannableString1 = new SpannableString("为文字设置点击事件");
        MyClickableSpan clickableSpan = new MyClickableSpan("http://www.jianshu.com/users/dbae9ac95c78");
        spannableString1.setSpan(clickableSpan, 5, spannableString1.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        url.setMovementMethod(LinkMovementMethod.getInstance());
        url.setHighlightColor(Color.parseColor("#0079E6"));
        url.setText(spannableString1);

        //设置点击时间
        SpannableString spannableString2 = new SpannableString("点击蓝色背景的字体实现跳转");
        BackgroundColorSpan colorSpan2 = new BackgroundColorSpan(Color.parseColor("#0079E6"));
        spannableString2.setSpan(colorSpan2,2,6,Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        background.setText(spannableString2);

        //设置上标2^2+3^2=13
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(0.4f);
        RelativeSizeSpan sizeSpan02 = new RelativeSizeSpan(0.4f);
        SpannableString spannableString3 = new SpannableString("22+33=13");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        spannableString3.setSpan(superscriptSpan, 1,2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString3.setSpan(sizeSpan02, 1,2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        spannableString3.setSpan(subscriptSpan, 4,5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString3.setSpan(sizeSpan01, 4,5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        genhao.setText(spannableString3);

        //设置删除线
        SpannableString spannableString4 = new SpannableString("￥499 ￥599");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString4.setSpan(strikethroughSpan, 5, spannableString4.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        ForegroundColorSpan colorSpan4 = new ForegroundColorSpan(Color.parseColor("#EA2506"));
        spannableString4.setSpan(colorSpan4, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        yuanjia.setText(spannableString4);


        handler.sendEmptyMessageDelayed(0,100);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            SpannableString spannableString=new SpannableString("看，这里的文字会动的哦！");
            if(loc<spannableString.length()){

            }else{
                loc=0;
            }
            RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1.5f);
            ForegroundColorSpan colorSpan4 = new ForegroundColorSpan(Color.parseColor("#EA2506"));
            spannableString.setSpan(sizeSpan01,loc,loc+1,Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            spannableString.setSpan(colorSpan4,loc,loc+1,Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            animator.setText(spannableString);
            loc++;
            handler.sendEmptyMessageDelayed(0,400);
            super.handleMessage(msg);
        }
    };
    class MyClickableSpan extends ClickableSpan {private String content;

        public MyClickableSpan(String content) {
            this.content = content;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View widget) {
            Intent intent = new Intent(SpannableStringActitity.this, SwipeBackExample.class);
            Bundle bundle = new Bundle();
            bundle.putString("content", content);
            intent.putExtra("bundle", bundle);
            startActivity(intent);
        }
    }
}
