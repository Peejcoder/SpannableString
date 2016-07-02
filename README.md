# SpannableString
使用SpannableString实现文字的一些特殊效果
====
效果图为：<br>
![](https://github.com/18380460383/SpannableString/raw/master/123.gif)  
关键代码
-------
1 购物的原价和现价效果
###
```Java
    //设置删除线
        SpannableString spannableString4 = new SpannableString("￥499 ￥599");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString4.setSpan(strikethroughSpan, 5, spannableString4.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        ForegroundColorSpan colorSpan4 = new ForegroundColorSpan(Color.parseColor("#EA2506"));
        spannableString4.setSpan(colorSpan4, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        yuanjia.setText(spannableString4);
```

----
2 上标和下标效果
###
```java
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
        
```
3 文字的放大效果和移动显示效果
###
```java
handler.sendEmptyMessageDelayed(0,100);
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
```
说明
-----
第一次使用github很多东西不是很会，上传了java和布局文件。参考了一些大神的介绍和做法。


