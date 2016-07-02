# SpannableString
SpannableString
====
效果图为：<br>
![](https://github.com/18380460383/SpannableString/3803687822.gif)  
关键代码
-------
```Java
    //设置删除线
        SpannableString spannableString4 = new SpannableString("￥499 ￥599");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString4.setSpan(strikethroughSpan, 5, spannableString4.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        ForegroundColorSpan colorSpan4 = new ForegroundColorSpan(Color.parseColor("#EA2506"));
        spannableString4.setSpan(colorSpan4, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        yuanjia.setText(spannableString4);
```


