# To_Do_App_Compose


📸 Screenshots
<table>
  <tr>
    <td align="center">
      <img src="https://github.com/baris-gungorr/To_Do_App_Compose/assets/121685398/0909ad42-ab18-4c92-8947-5f5bbbbd0e03" alt="TO_DO_APP" width="250">
    </td>
    <td align="center">
      <img src="https://github.com/baris-gungorr/To_Do_App_Compose/assets/121685398/332114dc-348b-40f6-a7ec-d7695b779b4f" alt="NOTLARIM" width="250">
    </td>
    <td align="center">
      <img src="https://github.com/baris-gungorr/To_Do_App_Compose/assets/121685398/d88ebf5c-9348-45fe-b745-a16838e70392" alt="NOTLARIM" width="250">
    </td>

  </tr>
  
</table>

👇 Structures Used

Application architecture: MVVM

- View Binding 
- Coroutine
- ViewModel
- Navigation
- Hilt
- Room


 ✏️ Dependency
 ```gradle


 implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
 implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

 implementation("androidx.lifecycle:lifecycle-viewmodel:2.5.1")
 implementation("androidx.activity:activity-ktx:1.6.1")

 implementation("com.google.dagger:hilt-android:2.44")
 kapt("com.google.dagger:hilt-android-compiler:2.44")



 implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
 implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

 implementation ("androidx.room:room-runtime:2.5.0-beta02")
 kapt("androidx.room:room-compiler:2.5.0-beta02")
 implementation("androidx.room:room-ktx:2.4.3")
 implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
```

```groovy
plugins {
   id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}
```
