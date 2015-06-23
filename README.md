# BlurredGridMenu
============
Cool grid menu.

![](https://github.com/gotokatsuya/BlurredGridMenu/blob/master/image.jpg)

## How to use

### Enable renderscript
renderscriptTargetApi 22
renderscriptSupportModeEnabled true

### Code
```java

// Configuration
private void makeBlurConfig() {
  Config.build(new Config.Builder()
    .radius(1)
    .downsample(1)
    .overlayColor(Color.parseColor("#000000")));
}

// GridMenuFragment
private void makeGridMenuFragment() {
  // This image will be blurred.
  int backgroundResourceId = ...;
  mGridMenuFragment = GridMenuFragment.newInstance(resourceId)
  List<MenuItem> menus = new ArrayList<>();
  menus.add(new MenuItem("Home", R.drawable.home));
  ...
  menus.add(new MenuItem(.., ..))
  ...
  mGridMenuFragment.setMenu(menus);
  mGridMenuFragment.setOnClickMenuListener(new GridMenuFragment.OnClickMenuListener() {
  @Override
  public void onClickMenu(MenuItem menuItem) {
      Toast.makeText(context, menuItem.title, Toast.LENGTH_SHORT).show();
      }
  });
}
```
[Check this sample code](https://github.com/gotokatsuya/BlurredGridMenu/blob/master/app/src/main/java/com/goka/sample/MainActivity.java)


## Gradle

Caution : Not release now yet.  

```java
repositories {
    jcenter()
}

dependencies {
    compile 'com.github.goka.blurredgridmenu:blurredgridmenu:1.0.0'
}
```


## Release
1.0.0


## Blur
Reference
[500px](https://github.com/500px/500px-android-blur)

