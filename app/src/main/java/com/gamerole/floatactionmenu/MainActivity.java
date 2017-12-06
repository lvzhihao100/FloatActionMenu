package com.gamerole.floatactionmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.gamerole.floatactionmenulib.RapidFloatingActionButton;
import com.gamerole.floatactionmenulib.RapidFloatingActionHelper;
import com.gamerole.floatactionmenulib.RapidFloatingActionLayout;
import com.gamerole.floatactionmenulib.contentimpl.labellist.RFACLabelItem;
import com.gamerole.floatactionmenulib.contentimpl.labellist.RapidFloatingActionContentLabelList;
import com.gamerole.floatactionmenulib.util.ABShape;
import com.gamerole.floatactionmenulib.util.ABTextUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener {

    private RapidFloatingActionHelper rfabHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(this);
        rfaContent.setOnRapidFloatingActionContentLabelListListener(this);
        List<RFACLabelItem> items = new ArrayList<>();
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Github: wangjiegulu")
                .setResId(R.mipmap.ic_launcher)
                .setIconNormalColor(0xffd84315)
                .setIconPressedColor(0xffbf360c)
                .setWrapper(0)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("tiantian.china.2@gmail.com")
                .setResId(R.mipmap.ic_launcher)
                .setIconNormalColor(0xff4e342e)
                .setIconPressedColor(0xff3e2723)
                .setLabelColor(Color.WHITE)
                .setLabelSizeSp(14)
                .setLabelBackgroundDrawable(ABShape.generateCornerShapeDrawable(0xaa000000, ABTextUtil.dip2px(this, 4)))
                .setWrapper(1)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("WangJie")
                .setResId(R.mipmap.ic_launcher)
                .setIconNormalColor(0xff056f00)
                .setIconPressedColor(0xff0d5302)
                .setLabelColor(0xff056f00)
                .setWrapper(2)
        );
        items.add(new RFACLabelItem<Integer>()
                .setLabel("Compose")
                .setResId(R.mipmap.ic_launcher)
                .setIconNormalColor(0xff283593)
                .setIconPressedColor(0xff1a237e)
                .setLabelColor(0xff283593)
                .setWrapper(3)
        );
        rfaContent
                .setItems(items)
                .setIconShadowRadius(ABTextUtil.dip2px(this, 5))
                .setIconShadowColor(0xff888888)
                .setIconShadowDy(ABTextUtil.dip2px(this, 5))
        ;
        rfabHelper = new RapidFloatingActionHelper(
                this,
                (RapidFloatingActionLayout) findViewById(R.id.activity_main_rfal),
                (RapidFloatingActionButton) findViewById(R.id.activity_main_rfab),
                rfaContent
        ).build();
    }

    @Override
    public void onRFACItemLabelClick(int position, RFACLabelItem item) {
        Toast.makeText(this, "clicked label: " + position, Toast.LENGTH_SHORT).show();
        rfabHelper.toggleContent();
    }

    @Override
    public void onRFACItemIconClick(int position, RFACLabelItem item) {
        Toast.makeText(this, "clicked icon: " + position, Toast.LENGTH_SHORT).show();
        rfabHelper.toggleContent();
    }
}
