### Status
[![Build Status](https://travis-ci.com/RowlandOti/KokoKeyboard.svg?branch=master)](https://travis-ci.com/RowlandOti/KokoKeyboard)[ ![Download](https://api.bintray.com/packages/rowlandoti/maven/KokoKeyboard/images/download.svg) ](https://bintray.com/rowlandoti/maven/KokoKeyboard/_latestVersion)


## Koko Keyboard

Custom and re-usable Android Keypad example.

### Preview:

![Alt text](https://github.com/RowlandOti/KokoKeyboard/blob/master/documentation/qwertykeypadnum.png?raw=true "Qwerty Keypad Preview")![Alt text](https://github.com/RowlandOti/KokoKeyboard/blob/master/documentation/qwertykeypad.png?raw=true "Qwerty Keypad Preview")

### Download
Grab the latest version via Maven:
```xml
<dependency>
  <groupId>com.rowland.keyboard</groupId>
  <artifactId>KokoKeyboard</artifactId>
  <version>$latest_version</version>
  <type>pom</type>
</dependency>
```
or Gradle:
```groovy
repositories {
  jcenter()
}

dependencies {
  implementation 'com.rowland.keyboard:KokoKeyboard:$latest_version'
}
```

### How to use

>activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/rl_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.rowland.keyboard.KeyboardActivity">

    <androidx.core.widget.NestedScrollView
        android:id="@+id/nc_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@+id/keyboardview"
        android:layout_alignParentTop="true"
        android:padding="10dp">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <com.google.android.material.textfield.TextInputLayout
                android:id="@+id/textinput_layout"
                style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.Dense"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="5dp">

                <com.google.android.material.textfield.TextInputEditText
                    android:id="@+id/input_text"
                    style="@style/Widget.MaterialComponents.TextInputEditText.OutlinedBox.Dense"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="@string/type_something_with_custom_keypad"
                    android:inputType="text"
                    android:textColor="@android:color/black" />
            </com.google.android.material.textfield.TextInputLayout>

            <com.google.android.material.textfield.TextInputLayout
                android:id="@+id/text_non_numinput_layout"
                style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.Dense"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="5dp">

                <com.google.android.material.textfield.TextInputEditText
                    android:id="@+id/input_text_non_num"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="@string/type_something_with_no_numbers"
                    android:inputType="text"
                    android:textColor="@android:color/black" />
            </com.google.android.material.textfield.TextInputLayout>

            <com.google.android.material.textfield.TextInputLayout
                android:id="@+id/text_input_stockkeypad_layout"
                style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.Dense"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="5dp">

                <com.google.android.material.textfield.TextInputEditText
                    android:id="@+id/input_text_stockkeypad"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="@string/type_something_with_android_stock_keypad"
                    android:inputType="text"
                    android:textColor="@android:color/black" />
            </com.google.android.material.textfield.TextInputLayout>

        </LinearLayout>

    </androidx.core.widget.NestedScrollView>

    <com.rowland.kokokeyboard.keypad.KokoKeyboardView
        android:id="@+id/keyboardview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:background="@android:color/background_light"
        android:focusable="true"
        android:focusableInTouchMode="true"
        android:orientation="vertical"
        app:el_expanded="true"
        app:el_parallax="0.5"
        app:elevation="1dp"
        tools:layout_height="250dp" />
</RelativeLayout>
```

>MainActivity.java

```java
public class KeyboardActivity extends AppCompatActivity {

    private KokoKeyboardView keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        keyboard = findViewById(R.id.keyboardview);
        keyboard.registerEditText(KokoKeyboardView.INPUT_TYPE_QWERTY_NUM, findViewById(R.id.input_text));
        keyboard.registerEditText(KokoKeyboardView.INPUT_TYPE_QWERTY, findViewById(R.id.input_text_non_num));
    }

    @Override
    public void onBackPressed() {
        if (keyboard.isExpanded()) {
            keyboard.toggle();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        keyboard.unregisterEditText(findViewById(R.id.input_text));
        keyboard.unregisterEditText(findViewById(R.id.input_text_non_num));
    }
}
```



Calling `keyboard.registerEditText()` enables the specific `EditText` to use the custom keyboard. The first argument determines the type of keypad that will be used. Currently the options supported are `KokoKeyboardView.INPUT_TYPE_QWERTY` and `KokoKeyboardView.INPUT_TYPE_QWERTY_NUM `.
We have various key types like `SquareKeyView` for normal `char` entry and `RectangularKeyView` to handle special actions.

### Coming Soon

- Availability as system-wide Android Keyboard. This will be achieved using `KeyInputMethodService` implementaion of `InputMethodService`.
- Support for more special `char` and special actions like delete select, forward delete, mode change e.t.c
- Support for customized look i.e themes.

### Developers
<table>
<tr>
<td>
     <img src="https://avatars2.githubusercontent.com/u/8356008?v=4&s=150" />

     Otieno Rowland

<p align="center">
<a href = "https://github.com/rowlandoti"><img src = "http://www.iconninja.com/files/241/825/211/round-collaboration-social-github-code-circle-network-icon.svg" width="36" height = "36"/></a>
<a href = "https://twitter.com/rowlandoti"><img src = "https://www.shareicon.net/download/2016/07/06/107115_media.svg" width="36" height="36"/></a>
<a href = "https://www.linkedin.com/in/rowlandoti"><img src = "http://www.iconninja.com/files/863/607/751/network-linkedin-social-connection-circular-circle-media-icon.svg" width="36" height="36"/></a>
</p>
</td>


</tr>
  </table>

### Licence

 Copyright (c) Otieno Rowland

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
