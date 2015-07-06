# BlurredGridMenu

[![AndroidArsenal](https://img.shields.io/badge/Android%20Arse ak-BlurredGridMenu-brightgreen.svg?style=flat)]()

Cool grid menu.

![](https://github.com/gotokatsuya/BlurredGridMenu/blob/master/image.jpg)

## How to use

### Enable renderscript
```
renderscriptTargetApi 22  
renderscriptSupportModeEnabled true
```

### Code
```java

// Configuration (You can call on Application)
private void makeBlurConfig() {
  BlurredGridMenuConfig
      .build(new BlurredGridMenuConfig.Builder()
              .radius(1)
              .downsample(1)
              .overlayColor(Color.parseColor("#AA000000")));
}

// GridMenuFragment
private void makeGridMenuFragment() {
  // This image will be blurred.
  int backgroundResourceId = ...;
  mGridMenuFragment = GridMenuFragment.newInstance(backgroundResourceId)

  List<GridMenu> menus = new ArrayList<>();
  menus.add(new GridMenu("Home", R.drawable.home));
  ...
  menus.add(new GridMenu("Setting", R.drawable.settings));
  ...
  mGridMenuFragment.setupMenu(menus);

  mGridMenuFragment.setOnClickMenuListener(new GridMenuFragment.OnClickMenuListener() {
      @Override
      public void onClickMenu(GridMenu gridMenu, int position) {
          Toast.makeText(context, "Title:" + gridMenu.getTitle() + ", Position:" + position,
                          Toast.LENGTH_SHORT).show();
      }
  });
}
```
[Check this sample code](https://github.com/gotokatsuya/BlurredGridMenu/blob/master/app/src/main/java/com/goka/sample/MainActivity.java)


## Gradle

```java
repositories {
    jcenter()
}

dependencies {
    compile 'com.github.goka.blurredgridmenu:blurredgridmenu:1.0.2'
}
```


## Release
1.0.0
 First release.

1.0.1
 Modified some class names.

1.0.2
 Delete resources we don't need.

## Blur
Reference
[500px](https://github.com/500px/500px-android-blur)

