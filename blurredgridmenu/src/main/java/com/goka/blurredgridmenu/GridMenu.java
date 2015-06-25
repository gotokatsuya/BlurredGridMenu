package com.goka.blurredgridmenu;

/**
 * Created by katsuyagoto on 15/06/16.
 */
public class GridMenu {

    public String title;

    public int icon;

    public GridMenu(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
